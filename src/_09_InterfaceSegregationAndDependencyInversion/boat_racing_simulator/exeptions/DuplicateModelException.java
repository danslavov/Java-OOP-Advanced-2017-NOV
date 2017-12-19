package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions;

public class DuplicateModelException extends Exception {
    public DuplicateModelException(String message) {
        super(message);
    }

}
