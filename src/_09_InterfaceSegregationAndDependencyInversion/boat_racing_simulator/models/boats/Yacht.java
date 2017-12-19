package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Validator;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Propellable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Race;

public class Yacht extends Boat {

    private Propellable engine;
    private int cargoWeight;

    public Yacht(String model, int weight, Propellable engine, int cargoWeight) {
        super(model, weight);
        super.setHasMotor();
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    @Override
    protected double calculateSpeed(Race race) {
        return
                this.engine.getOutput()
                - (super.getWeight() + this.cargoWeight)
                + race.getOceanCurrentSpeed() / 2;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }
}
