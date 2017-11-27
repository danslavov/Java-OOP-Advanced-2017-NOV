package _03_Generics.Exercises.P07_08_09_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    private List<T> list;

    public CustomListImpl() {
        initialize();
    }

    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public T remove(int index) {
        return this.list.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return list.contains(element);
    }

    @Override
    public void swap(int fromIndex, int toIndex) {
        this.list.set(fromIndex, this.list.set(toIndex, this.list.get(fromIndex)));
    }

    @Override
    public int countGreaterThan(T element) {
        int result = 0;
        for (T t : this.list) {
            if (t.compareTo(element) > 0) {
                result++;
            }
        }
        return result;
    }

    @Override
    public T getMax() {
        T max = this.list.get(0);
        for (T t : list) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }

    @Override
    public T getMin() {
        T min = this.list.get(0);
        for (T t : list) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T t : this.list) {
            if (t != null) {
                result.append(t);
                result.append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    public List<T> getList() {
        return this.list;
    }

    private void initialize() {
        this.list = new ArrayList<>();
    }

}
