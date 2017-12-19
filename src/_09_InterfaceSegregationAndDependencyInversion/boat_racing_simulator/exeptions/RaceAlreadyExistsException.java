package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions;

public class RaceAlreadyExistsException extends Exception {
    public RaceAlreadyExistsException(String message) {
        super(message);
    }
}
