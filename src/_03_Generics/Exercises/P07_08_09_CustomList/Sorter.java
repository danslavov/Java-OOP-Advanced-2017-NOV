package _03_Generics.Exercises.P07_08_09_CustomList;

import java.util.Collections;

public class Sorter {
    public static <T extends Comparable> void sort(CustomList<T> customList) {
        Collections.sort(customList.getList());
    }
}
