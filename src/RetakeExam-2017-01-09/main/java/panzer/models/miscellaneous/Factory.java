package panzer.models.miscellaneous;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

public class Factory {

    private String vehiclePath;
    private String partPath;

    public Factory(Assembler assembler, String vehiclePath, String partPath) {
        this.vehiclePath = vehiclePath;
        this.partPath = partPath;
    }

    public Vehicle createVehicle(List<String> arguments) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int attack = Integer.parseInt(arguments.get(5));
        int defense = Integer.parseInt(arguments.get(6));
        int hitPoints = Integer.parseInt(arguments.get(7));
        Assembler assembler = new VehicleAssembler();

        String className = this.vehiclePath + type;
        Class<?> vehicleClass = Class.forName(className);
        Constructor<?> vehicleConstructor = vehicleClass.getDeclaredConstructors()[0];
        vehicleConstructor.setAccessible(true);
        Vehicle vehicle = (Vehicle) vehicleConstructor
                .newInstance(
                        model, weight, price, attack, defense, hitPoints, assembler
                );

        return vehicle;
    }

    public Part createPart(List<String> arguments) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String type = arguments.get(2);
        String model = arguments.get(3);
        double weight = Double.parseDouble(arguments.get(4));
        BigDecimal price = new BigDecimal(arguments.get(5));
        int parameter = Integer.parseInt(arguments.get(6));

        String className = this.partPath + type + "Part";
        Class<?> partClass = Class.forName(className);
        Constructor<?> partConstructor = partClass.getDeclaredConstructors()[0];
        partConstructor.setAccessible(true);
        Part part = (Part) partConstructor
                .newInstance(model, weight, price, parameter);

        return part;
    }
}
