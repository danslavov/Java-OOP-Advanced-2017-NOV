package _03_Generics.Lab.L04_05_06_07_ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        T minValue = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            if (current.compareTo(minValue) < 0) {
                minValue = current;
            }
        }
        return minValue;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        T maxValue = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            if (current.compareTo(maxValue) > 0) {
                maxValue = current;
            }
        }
        return maxValue;
    }

    public static List<Integer> getNullIndices(List<?> list) {

        // Is this needed?
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }

        List<Integer> indices = new ArrayList<>();      //  linked list?
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static <T> void flatten(
            List<? super T> destination, List<List<? extends T>> source) {  // Maybe just "List<T> destination"?
        for (List<? extends T> innerList : source) {
            destination.addAll(innerList);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }
}
