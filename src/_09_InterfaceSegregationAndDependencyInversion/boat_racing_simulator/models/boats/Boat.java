package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Constants;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Validator;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Race;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Raceable;

public abstract class Boat implements Raceable {

    private String model;
    private int weight;
    private boolean hasMotor;

    protected Boat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public double calculateTimeToFinish(Race race) {
        double speed = this.calculateSpeed(race);
        double time = race.getDistance() / speed;
        return (time > 0) ? time : Double.MAX_VALUE;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public boolean getHasMotor() {
        return this.hasMotor;
    }

    protected int getWeight() {
        return weight;
    }

    protected void setHasMotor() {
        this.hasMotor = true;
    }

    protected abstract double calculateSpeed(Race race);

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}
