package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.DuplicateModelException;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.NonExistantModelException;

public interface Repository<T extends Modelable> {

    void addItem(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
}
