package _03_Generics.Exercises.P03_04_GenericSwapMethodStringAndInteger;

import _03_Generics.Exercises.P01_02_GenericBox.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Box> list = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            // Box box = new Box(scanner.nextLine());   // for Problem 3

            Box box = new Box(Integer.parseInt(scanner.nextLine()));
            list.add(box);
        }

        int[] indices = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int from = indices[0];
        int to = indices[1];

        swap(list, from, to);

        for (Box box : list) {
            System.out.println(box);
        }
    }
}
