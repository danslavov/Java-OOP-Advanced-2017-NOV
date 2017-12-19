package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.*;

import java.util.List;

public interface CommandHandler {
    String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
