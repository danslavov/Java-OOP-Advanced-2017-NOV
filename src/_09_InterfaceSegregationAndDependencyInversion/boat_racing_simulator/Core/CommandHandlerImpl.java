package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Core;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Constants;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Controller;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.CommandHandler;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.controllers.BoatSimulatorController;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.*;

import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    private Controller controller;

    @SuppressWarnings("WeakerAccess")
    public CommandHandlerImpl() {
        this.controller = new BoatSimulatorController();
    }

    public String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                String engineType = parameters.get(3);
                if (engineType.equals("Jet")) {
                    return this.controller.createJet(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)));
                } else if (parameters.get(3).equals("Sterndrive")) {
                    return this.controller.createSterndrive(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)));
                }

                throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);

            case "CreateRowBoat":
                return this.controller.createRowBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreateSailBoat":
                return this.controller.createSailBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreatePowerBoat":
                return this.controller.createPowerBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        parameters.get(3));
            case "CreateYacht":
                return this.controller.createYacht(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        Integer.parseInt(parameters.get(3)));
            case "OpenRace":
                return this.controller.openRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));
            case "SignUpBoat":
                return this.controller.signUpBoat(parameters.get(0));
            case "StartRace":
                return this.controller.startRace();
            case "GetStatistic":
                return this.controller.getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}