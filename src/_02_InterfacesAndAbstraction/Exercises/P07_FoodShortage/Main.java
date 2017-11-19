package _02_InterfacesAndAbstraction.Exercises.P07_FoodShortage;

import _02_InterfacesAndAbstraction.Exercises.P07_FoodShortage.entities.Citizen;
import _02_InterfacesAndAbstraction.Exercises.P07_FoodShortage.entities.Rebel;
import _02_InterfacesAndAbstraction.Exercises.P07_FoodShortage.interfaces.Buyer;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Buyer> buyers = getBuyers();
        buyFoodAndPrintResult(buyers);
    }

    private static void buyFoodAndPrintResult(Map<String, Buyer> buyers) {
        String name;
        while (!"End".equalsIgnoreCase(name = scanner.nextLine())) {
            if (buyers.containsKey(name)) {
                buyers.get(name).buyFood();
            }
        }

        int sum = buyers.values().stream()
                .map(Buyer::getFood)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }

    private static Map<String,Buyer> getBuyers() {
        Map<String, Buyer> buyers = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String groupOrId = tokens[2];
            if (tokens.length == 3) {
                Rebel rebel = new Rebel(name, age, groupOrId);
                buyers.putIfAbsent(name, rebel);
            } else {
                String bDay = tokens[3];
                Citizen citizen = new Citizen(name, age, groupOrId, bDay);
                buyers.putIfAbsent(name, citizen);
            }
        }
        return buyers;
    }
}
