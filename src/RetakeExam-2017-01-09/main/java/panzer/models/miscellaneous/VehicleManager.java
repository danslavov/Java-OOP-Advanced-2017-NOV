package panzer.models.miscellaneous;

import panzer.contracts.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class VehicleManager implements Manager {

    private static final String CREATED_VEHICLE = "Created %s Vehicle - %s";
    public static final String PART_ADDED_TO_VEHICLE = "Added %s - %s to Vehicle - %s";

    private Map<String, Vehicle> vehicles;
    // Defeated Vehicles
    private List<String> defeatedVehicles;
    private BattleOperator battleOperator;
    private Factory factory;


    public VehicleManager(BattleOperator battleOperator, Factory factory) {

        this.vehicles = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedList<>();
        this.battleOperator = battleOperator;
        this.factory = factory;
    }

    @Override
    public String addVehicle(List<String> arguments) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Vehicle vehicle = this.factory.createVehicle(arguments);
        String type = arguments.get(1);
        String model = arguments.get(2);
        this.vehicles.putIfAbsent(model, vehicle);

        return String.format(CREATED_VEHICLE, type, model);
    }

    @Override
    public String addPart(List<String> arguments) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Part part = this.factory.createPart(arguments);
        String vehicleModel = arguments.get(1);
        String type = arguments.get(2);
        String model = arguments.get(3);

        switch (type) {
            case "Arsenal":
                Vehicle vehicle = this.vehicles.get(vehicleModel);
                vehicle.addArsenalPart(part);
                break;
            case "Shell":
                this.vehicles.get(vehicleModel).addShellPart(part);
                break;
            case "Endurance":
                this.vehicles.get(vehicleModel).addEndurancePart(part);
                break;
        }

        return String.format(PART_ADDED_TO_VEHICLE,
                type, model, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String vehicleModel = arguments.get(1);
        return this.vehicles.get(vehicleModel).toString();
    }

    @Override
    public String battle(List<String> arguments) {

        String firstName = arguments.get(1);
        String secondName = arguments.get(2);

        Vehicle first = this.vehicles.get(firstName);
        Vehicle second = this.vehicles.get(secondName);
        String winner = this.battleOperator.battle(first, second);

        String loserName = firstName;
        if (winner.equals(firstName)) {
            loserName = secondName;
        }
        this.defeatedVehicles.add(this.vehicles.remove(loserName).getModel());

        return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                firstName, secondName, winner);
    }

    @Override
    public String terminate(List<String> arguments) {

        StringBuilder result = new StringBuilder();

        result.append("Remaining Vehicles: ");
        if (this.vehicles.size() > 0) {
            for (String vehicleModel : vehicles.keySet()) {
                result.append(vehicleModel).append(", ");
            }
            result.delete(result.length() - 2, result.length() - 1);
        } else {
            result.append("None");
        }
        result.append(System.lineSeparator());

        result.append("Defeated Vehicles: ");
        if (this.defeatedVehicles.size() > 0) {
            for (String vehicleModel : this.defeatedVehicles) {
                result.append(vehicleModel).append(", ");
            }
            result.delete(result.length() - 2, result.length() - 1);
        } else {
            result.append("None");
        }
        result.append(System.lineSeparator());

        int partCount = 0;
        for (Map.Entry<String, Vehicle> vehicle : vehicles.entrySet()) {
            for (Part part : vehicle.getValue().getParts()) {
                partCount++;
            }
        }
        result.append(String.format("Currently Used Parts: %d", partCount));

        return result.toString();
    }
}
