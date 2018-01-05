package app.core;

import app.factories.Factory;
import app.io.Reader;
import app.io.Writer;
import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.*;

import java.lang.annotation.Annotation;

public class Engine implements Runnable {

    private static final String SUCCESS = "%.2f kg of %s successfully processed!%n";
    private static final String FAILURE = "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.";
    private static final String STATUS = "Energy: %.2f Capital: %.2f%n";
    private static final String INVALID_COMMAND = "Invalid command";
    private static final String INVALID_WASTE_TYPE = "Invalid waste type!";
    private static final String DENIED = "Processing Denied!%n";
    public static final String MANAGEMENT_REQUIREMENT_CHANGED = "Management requirement changed!%n";

    private Reader reader;
    private Writer writer;
    private GarbageProcessor garbageProcessor;
    private BalanceManager balanceManager;
    private Factory<Waste> wasteFactory;
    private Factory<GarbageDisposalStrategy> strategyFactory;
    private ManagementRequirement managementRequirement;

    public Engine(
            Reader reader,
            Writer writer,
            GarbageProcessor garbageProcessor,
            BalanceManager balanceManager,
            Factory<Waste> wasteFactory,
            Factory<GarbageDisposalStrategy> strategyFactory,
            ManagementRequirement managementRequirement) {
        this.reader = reader;
        this.writer = writer;
        this.garbageProcessor = garbageProcessor;
        this.balanceManager = balanceManager;
        this.wasteFactory = wasteFactory;
        this.strategyFactory = strategyFactory;
        this.managementRequirement = managementRequirement;
    }

    @Override
    public void run() {
        String line = this.reader.read();

        while (!line.equals("TimeToRecycle")) {
            String[] cmdArgs = line.split("(?<=\\w)\\s(?=[\\w\\-])");
            String cmdType = cmdArgs[0];

            switch (cmdType) {
                case "ProcessGarbage":
                    this.writer.write(this.processGarbage(cmdArgs[1]));
                    break;
                case "Status":
                    this.writer.write(this.getStatus());
                    break;
                case "ChangeManagementRequirement":
                    try {
                        this.writer.write(setRequirements(cmdArgs[1]));
                    } catch (ClassNotFoundException cnfe) {
                        this.writer.writeln(INVALID_WASTE_TYPE);
                    }
                    break;
                default:
                    this.writer.write(INVALID_COMMAND);
            }

            line = this.reader.read();
        }
    }

    private String getStatus() {
        return String.format(
                STATUS,
                this.balanceManager.getEnergyBalance(),
                this.balanceManager.getCapitalBalance());
    }

    private String processGarbage(String parameters) {
        String[] args = parameters.split("\\s*\\|\\s*");
        String name = args[0];
        double weight = Double.parseDouble(args[1]);

        try {
            Waste waste = this.wasteFactory.create(args);

            if (checkManagementRequirements(waste)) {
                return String.format(DENIED);
            }

            this.loadStrategy(waste);
            ProcessingData processingData = this.garbageProcessor.processWaste(waste);
            this.balanceManager.processData(processingData);
            return String.format(SUCCESS, weight, name);
        } catch (Exception e) {
            //TODO: handle exceptions properly
            return FAILURE;
        }
    }

    private Class<? extends  Annotation> getDisposableAnnotationClass(Waste waste) {
        for (Annotation annotation : waste.getClass().getAnnotations()) {
            if (annotation.annotationType().isAnnotationPresent(Disposable.class)) {
                return annotation.annotationType();
            }
        }

        return null;
    }

    private void loadStrategy(Waste waste) throws Exception {
        Class<? extends Annotation> annotationClass = this.getDisposableAnnotationClass(waste);
        if (annotationClass == null) {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
        }

        if (! this.garbageProcessor.getStrategyHolder().getDisposalStrategies().containsKey(annotationClass)) {
            GarbageDisposalStrategy garbageDisposalStrategy = this.strategyFactory.create(annotationClass.getSimpleName());
            this.garbageProcessor.getStrategyHolder().addStrategy(annotationClass, garbageDisposalStrategy);
        }
    }

    private String setRequirements(String requirements) throws ClassNotFoundException {
        String[] args = requirements.split("\\s*\\|\\s*");
        double energyRequirement = Double.parseDouble(args[0]);
        double capitalRequirement = Double.parseDouble(args[1]);
        String wasteTypeName = args[2];

        this.managementRequirement.setEnergyRequirement(energyRequirement);
        this.managementRequirement.setCapitalRequirement(capitalRequirement);
        this.managementRequirement.setWasteTypeName(wasteTypeName);

        return String.format(MANAGEMENT_REQUIREMENT_CHANGED);
    }

    private boolean checkManagementRequirements(Waste waste) {
        Class wasteType = getDisposableAnnotationClass(waste);
        String deniedWasteTypeName = wasteType.getSimpleName();
        String deniedWaste = this.managementRequirement.getWasteTypeName();
        double requiredEnergy = this.managementRequirement.getEnergyRequirement();
        double requiredCapital = this.managementRequirement.getCapitalRequirement();
        double availableEnergy = this.balanceManager.getEnergyBalance();
        double availableCapital = this.balanceManager.getCapitalBalance();

        return deniedWaste.equals(deniedWasteTypeName) &&
                (availableCapital < requiredCapital ||
                        availableEnergy < requiredEnergy);
    }

}
