package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.motors;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Constants;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Validator;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Propellable;

public abstract class Motor implements Propellable {

    private String model;
    private int horsepower;
    private int displacement;

    protected Motor(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    protected int getHorsepower() {
        return horsepower;
    }

    protected int getDisplacement() {
        return displacement;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
