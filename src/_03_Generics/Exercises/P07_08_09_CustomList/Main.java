package _03_Generics.Exercises.P07_08_09_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomListImpl<>();
        String input = reader.readLine();

        while (!"End".equalsIgnoreCase(input)) {
            String[] params = input.split("\\s+");
            Interpreter.interpret(params, list);
            input = reader.readLine();
        }
    }
}
