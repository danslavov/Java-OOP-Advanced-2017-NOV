package _02_InterfacesAndAbstraction.Exercises.P05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Id> list = new ArrayList<>();
        String input;

        while (!"End".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 2) {
                addRobot(tokens, list);
            } else {
                addCitizen(tokens, list);
            }
        }

        String forbiddenEnding = scanner.nextLine();
        printBadIds(list, forbiddenEnding);
    }

    private static void addRobot(String[] tokens, List<Id> list) {
        String model = tokens[0];
        String id = tokens[1];
        list.add(new Robot(model, id));
    }

    private static void addCitizen(String[] tokens, List<Id> list) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String id = tokens[2];
        list.add(new Citizen(name, age, id));
    }

    private static void printBadIds(List<Id> list, String forbiddenEnding) {
        for (Id element : list) {
            String id = element.getId();
            if (id.endsWith(forbiddenEnding)) {
                System.out.println(id);
            }
        }
    }
}
