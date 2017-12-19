package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts;

public interface Raceable extends Modelable {

    boolean getHasMotor();
    double calculateTimeToFinish(Race race);
}
