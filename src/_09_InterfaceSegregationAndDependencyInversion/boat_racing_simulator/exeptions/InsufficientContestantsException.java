package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions;

public class InsufficientContestantsException extends Exception{
    public InsufficientContestantsException(String message) {
        super(message);
    }
}
