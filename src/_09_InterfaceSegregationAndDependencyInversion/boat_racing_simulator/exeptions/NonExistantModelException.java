package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions;

public class NonExistantModelException extends Exception {
    public NonExistantModelException(String message) {
        super(message);
    }
}
