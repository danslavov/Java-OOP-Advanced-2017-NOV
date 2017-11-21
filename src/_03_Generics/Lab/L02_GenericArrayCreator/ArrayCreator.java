package _03_Generics.Lab.L02_GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        T[] result = (T[]) new Object[length];
        return fillArray(result, item);
    }

    public static <T> T[] create(Class<T> cl, int length, T item) {
        T[] result = (T[]) Array.newInstance(cl, length);
        return fillArray(result, item);
    }

    private static <T> T[] fillArray(T[] arr, T item) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}
