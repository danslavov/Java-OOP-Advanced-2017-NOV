package _02_InterfacesAndAbstraction.Exercises.P03_Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {

        Scanner scanner = new Scanner(System.in);
        String driver = scanner.nextLine();
        Ferrari ferrari = new Ferrari(driver);

        System.out.print(ferrari.getModel() + "/");
        ferrari.pushBrakes();
        System.out.print("/");
        ferrari.pushGas();
        System.out.print("/");
        System.out.println(ferrari.getDriver());


        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
