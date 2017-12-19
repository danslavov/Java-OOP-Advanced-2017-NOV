package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.DuplicateModelException;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    boolean getAllowMotorboats();

    void addParticipant(Raceable boat) throws DuplicateModelException;

    List<Raceable> getParticipants();
}
