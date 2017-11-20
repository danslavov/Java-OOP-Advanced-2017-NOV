package _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.models;

import _02_InterfacesAndAbstraction.Exercises.P09_CollectionHierarchy.interfaces.MyList;

import java.util.Stack;

public class MyListImpl implements MyList {

    private Stack<String> collection;

    public MyListImpl() {
        this.initialize();
    }

    @Override
    public int add(String item) {
        this.collection.push(item);
        return 0;
    }

    @Override
    public String remove() {
        return this.collection.pop();
    }

    @Override
    public int used() {
        return this.collection.size();
    }

    private void initialize() {
        this.collection = new Stack<>();
    }
}
