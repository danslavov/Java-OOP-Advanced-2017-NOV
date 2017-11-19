package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Soldier;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// 80/100

public class Main {

    private static Map<Integer, Soldier> army = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input;
        while(!"End".equals(input = scanner.nextLine())) {
            String[] params = input.split("\\s+");
            int id = Integer.parseInt(params[1]);
            Soldier soldier = Factory.createSoldier(params);
            army.putIfAbsent(id, soldier);
        }

        System.out.println();

        for (Soldier soldier : army.values()) {
            if (soldier != null) {
                System.out.println(soldier);
            }
        }
    }

    public static Map<Integer, Soldier> getArmy() {
        return Collections.unmodifiableMap(army);
    }
}
