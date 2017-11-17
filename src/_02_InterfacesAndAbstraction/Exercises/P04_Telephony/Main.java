package _02_InterfacesAndAbstraction.Exercises.P04_Telephony;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        String[] sites = scanner.nextLine().split("\\s+");
        Smartphone phone = new Smartphone();

        for (String number : phoneNumbers) {
            phone.callNumber(number);
        }

        for (String site : sites) {
            phone.browseSite(site);
        }
    }
}
