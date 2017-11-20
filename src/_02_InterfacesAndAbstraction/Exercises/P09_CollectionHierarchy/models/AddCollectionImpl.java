package _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.models;

import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.interfaces.AddCollection;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImpl implements AddCollection {

    private List<String> collection;

    public AddCollectionImpl() {
        this.initialize();
    }

    @Override
    public int add(String item) {
        this.collection.add(item);
        return this.collection.size() - 1;
    }

    private void initialize() {
        this.collection = new ArrayList<>();
    }
}
