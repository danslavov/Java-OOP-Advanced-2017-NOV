package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.database;

import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Utility.Constants;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Modelable;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.contracts.Repository;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.DuplicateModelException;
import _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.exeptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T extends Modelable> implements Repository<T> {

    private Map<String, T> itemsByModel;

    public RepositoryImpl() {
        this.itemsByModel = new HashMap<>();
    }

    @Override
    public void addItem(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public T getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTANT_MODEL_MESSAGE);
        }
        return this.itemsByModel.get(model);
    }
}
