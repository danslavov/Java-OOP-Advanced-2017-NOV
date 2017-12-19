package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Propellable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Race;

public class PowerBoat extends Boat {

    private Propellable firstEngine;
    private Propellable secondEngine;

    public PowerBoat(String model, int weight, Propellable firstEngine, Propellable secondEngine) {
        super(model, weight);
        super.setHasMotor();
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    @Override
    protected double calculateSpeed(Race race) {
        return
                this.firstEngine.getOutput()
                + this.secondEngine.getOutput()
                - super.getWeight()
                + race.getOceanCurrentSpeed() / 5;
    }
}
