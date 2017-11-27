package _03_Generics.Exercises.P07_08_09_CustomList;

import java.util.List;

public interface CustomList<T extends Comparable> {
    void add(T element);
    T remove(int index);
    boolean contains(T element);
    void swap(int from, int to);
    int countGreaterThan(T element);
    T getMax();
    T getMin();
    List<T> getList();

}
