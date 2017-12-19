package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.database;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Propellable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Raceable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Repository;

public class Database {
    private Repository<Raceable> boats;
    private Repository<Propellable> motors;

    public Database() {
        this.boats = new RepositoryImpl<>();
        this.motors = new RepositoryImpl<>();
    }

    public Repository<Raceable> getBoats() {
        return this.boats;
    }

    public Repository<Propellable> getMotors() {
        return this.motors;
    }
}
