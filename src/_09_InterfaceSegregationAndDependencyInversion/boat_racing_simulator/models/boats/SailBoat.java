package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Validator;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Race;

public class SailBoat extends Boat {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        setSailEfficiency(sailEfficiency);
    }

    @Override
    protected double calculateSpeed(Race race) {
        return
                race.getWindSpeed() * this.sailEfficiency / 100
                - super.getWeight() + race.getOceanCurrentSpeed() / 2;
    }

    private void setSailEfficiency(int sailEfficiency) {
        Validator.validatePropertyValue(sailEfficiency, "Oars");
        this.sailEfficiency = sailEfficiency;
    }
}
