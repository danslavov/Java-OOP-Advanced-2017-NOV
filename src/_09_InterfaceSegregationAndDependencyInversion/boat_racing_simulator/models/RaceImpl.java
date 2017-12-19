package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.models;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Constants;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Validator;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Race;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Raceable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.DuplicateModelException;

import java.util.*;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private boolean allowMotorBoats;
    private Map<String, Raceable> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowMotorBoats = allowMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    public void addParticipant(Raceable boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<Raceable> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public int getWindSpeed() {
        return this.windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return this.oceanCurrentSpeed;
    }

    public boolean getAllowMotorboats() {
        return this.allowMotorBoats;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }
}