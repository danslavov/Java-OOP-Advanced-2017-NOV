package _03_Generics.Exercises.P05_06_GenericCountMethod;

import _03_Generics.Exercises.P01_02_GenericBox.Box;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Box> list = fillList();
        printResult(list);
    }

    private static List<Box> fillList() {
        List<Box> list = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Box box = new Box();
            String input = scanner.nextLine();
            try {
                box.setContainer(Double.parseDouble(input));
            } catch (NumberFormatException nfe) {
                box.setContainer(input);
            }
            list.add(box);
        }
        return list;
    }

    private static int getGreaterElementsCount(List<Box> list, String itemToCompare) {
        int greaterElementsCount = 0;
        for (Box box : list) {
            if (box.getContainer().compareTo(itemToCompare) > 0) {
                greaterElementsCount++;
            }
        }
        return greaterElementsCount;
    }

    private static int getGreaterElementsCount(List<Box> list, double itemToCompare) {
        int greaterElementsCount = 0;
        for (Box box : list) {
            if (box.getContainer().compareTo(itemToCompare) > 0) {
                greaterElementsCount++;
            }
        }
        return greaterElementsCount;
    }

    private static void printResult(List<Box> list) {
        String itemToCompare = scanner.nextLine();
        try {
            System.out.println(getGreaterElementsCount(
                    list, Double.parseDouble(itemToCompare)));
        } catch (NumberFormatException nfe) {
            System.out.println(getGreaterElementsCount(
                    list, itemToCompare));
        }
    }
}
