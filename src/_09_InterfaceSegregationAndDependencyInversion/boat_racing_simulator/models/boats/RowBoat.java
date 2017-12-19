package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Validator;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Race;

public class RowBoat extends Boat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        setOars(oars);
    }

    @Override
    protected double calculateSpeed(Race race) {
        return this.oars * 100 - super.getWeight() + race.getOceanCurrentSpeed();
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    public int getOars() {
        return this.oars;
    }
}
