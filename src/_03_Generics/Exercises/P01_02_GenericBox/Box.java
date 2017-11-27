package _03_Generics.Exercises.P01_02_GenericBox;

public class Box <T extends Comparable<T>> {
    private T container;

    public Box(){};

    public Box(T input) {
        this.container = input;
    }

    public void setContainer(T item) {
        this.container = item;
    }

    public T getContainer() {
        return this.container;
    }

    @Override
    public String toString() {
        return this.getContainer().getClass().getName() + ": " + this.getContainer();
    }
}
