package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions;

public class NoSetRaceException extends Exception{
    public NoSetRaceException(String message) {
        super(message);
    }
}
