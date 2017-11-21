package _03_Generics.Lab.L04_05_06_07_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 4, 0);

        List<String> words = new ArrayList<>();
        Collections.addAll(words, "Pesho", "gosho", "PENKA");
    }
}
