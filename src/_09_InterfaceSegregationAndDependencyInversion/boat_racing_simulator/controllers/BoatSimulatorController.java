package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.controllers;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Constants;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Controller;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Propellable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Race;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Raceable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.database.Database;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.*;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.RaceImpl;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats.PowerBoat;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats.RowBoat;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats.SailBoat;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.boats.Yacht;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.motors.Jet;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models.motors.Sterndrive;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BoatSimulatorController implements Controller {
    private Database database;
    private Race currentRace;

    public BoatSimulatorController() {
        this.database = new Database();
    }

    @Override
    public String createJet(String model, int horsepower, int displacement) throws DuplicateModelException {
        Propellable motor = new Jet(model, horsepower, displacement);
        this.database.getMotors().addItem(motor);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model, horsepower, displacement);
    }

    @Override
    public String createSterndrive(String model, int horsepower, int displacement) throws DuplicateModelException {
        Propellable motor = new Sterndrive(model, horsepower, displacement);
        this.database.getMotors().addItem(motor);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model, horsepower, displacement);
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Raceable boat = new RowBoat(model, weight, oars);
        this.database.getBoats().addItem(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Raceable boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().addItem(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        Propellable firstEngine = this.database.getMotors().getItem(firstEngineModel);
        Propellable secondEngine = this.database.getMotors().getItem(secondEngineModel);
        Raceable boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().addItem(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        Propellable motor = this.database.getMotors().getItem(engineModel);
        Raceable boat = new Yacht(model, weight, motor, cargoWeight);
        this.database.getBoats().addItem(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorboats) throws RaceAlreadyExistsException {
        this.validateRaceIsEmpty();
        this.currentRace = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        return String.format("A new race with distance %s meters, " +
                        "wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {

        // check if a race is open (not required in problem description)
        this.validateRaceIsSet();

        Raceable boat = this.database.getBoats().getItem(model);

        // check if race allows motor boats
        if (!this.currentRace.getAllowMotorboats() && boat.getHasMotor()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }

        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();

        List<Raceable> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        participants = participants.stream()
                .sorted(Comparator.comparingDouble(p -> p.calculateTimeToFinish(this.currentRace)))
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder result = composeResult(participants);

        this.currentRace = null;

        return result.toString();
    }

    @Override
    public String getStatistic() throws NoSetRaceException {
        this.validateRaceIsSet();
        List<Raceable> participants = this.currentRace.getParticipants();
        Map<String, Integer> participantsByType = new TreeMap<>();
        double totalCount = 0d;

        for (Raceable p : participants) {
            String typeName = p.getClass().getSimpleName();

            participantsByType.merge(typeName, 1, Integer::sum);
            /*
            used instead of:

            if (!participantsByType.containsKey(typeName)) {
                participantsByType.put(typeName, 0);
            }
            participantsByType.put(typeName, participantsByType.get(typeName) + a);
             */


            totalCount++;
        }

        StringBuilder result = new StringBuilder();
        boolean isFirstIteration = true;
        for (Map.Entry<String, Integer> type : participantsByType.entrySet()) {
            if (!isFirstIteration) {
                result.append(System.lineSeparator());
            }
            double share = type.getValue() / totalCount * 100;
            result.append(String.format("%s -> %.2f%%",
                    type.getKey(), share
                    ));
            isFirstIteration = false;
        }
        return result.toString();
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }

    private StringBuilder composeResult(List<Raceable> participants) {
        StringBuilder result = new StringBuilder();
        int counter = 1;
        boolean isFirstIteration = true;

        for (Raceable p : participants) {

            String place;
            if (counter == 1) {
                place = "First";
            } else if (counter == 2) {
                place = "Second";
            } else {
                place = "Third";
            }

            String timeAsString;
            double time = p.calculateTimeToFinish(this.currentRace);
            if (time > 999_999_999) {
                timeAsString = "Did not finish!";
            } else {
                timeAsString = String.format("%.2f sec", time);
            }

            if (!isFirstIteration) {
                result.append(System.lineSeparator());
            }
            result.append(String.format("%s place: %s Model: %s Time: %s",
                    place,
                    p.getClass().getSimpleName(),
                    p.getModel(),
                    timeAsString));

            isFirstIteration = false;
            counter++;
        }

        return result;
    }

}
