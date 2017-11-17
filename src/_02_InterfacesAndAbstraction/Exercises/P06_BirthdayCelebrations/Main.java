package _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations;

import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.interfaces.BirthdayCelebratable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factory factory = new Factory();
        List<BirthdayCelebratable> list = new ArrayList<>();
        String input;

        while (!"End".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            list.add(factory.makeElement(tokens));
        }

        String yearOfBirth = scanner.nextLine();
        printBirthdays(list, yearOfBirth);
    }

    private static void printBirthdays(List<BirthdayCelebratable> list, String yearOfBirth) {
        for (BirthdayCelebratable el : list) {
            if (el != null) {
                String bDay = el.getBirthday();
                if (bDay != null && bDay.endsWith(yearOfBirth)) {
                    System.out.println(bDay);
                }
            }
        }
    }
}
