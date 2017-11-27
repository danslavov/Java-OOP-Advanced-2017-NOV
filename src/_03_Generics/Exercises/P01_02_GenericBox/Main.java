package _03_Generics.Exercises.P01_02_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box box = new Box();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            /*
            // for Problem 1:
            String input;
            input = scanner.nextLine();
             */

            // for Problem 2:
            int input = Integer.parseInt(scanner.nextLine());

            box.setContainer(input);
            System.out.println(box);
        }
    }
}
