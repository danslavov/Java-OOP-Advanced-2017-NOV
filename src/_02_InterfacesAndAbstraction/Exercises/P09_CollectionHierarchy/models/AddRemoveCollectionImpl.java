package _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.models;

import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.interfaces.AddRemoveCollection;

import java.util.ArrayDeque;
import java.util.Queue;

public class AddRemoveCollectionImpl implements AddRemoveCollection {

    private Queue<String> collection;

    public AddRemoveCollectionImpl() {
        this.initialize();
    }

    public int add(String item) {
        this.collection.offer(item);
        return 0;
    }

    @Override
    public String remove() {
        return this.collection.poll();
    }

    private void initialize() {
        this.collection = new ArrayDeque<>();
    }
}
