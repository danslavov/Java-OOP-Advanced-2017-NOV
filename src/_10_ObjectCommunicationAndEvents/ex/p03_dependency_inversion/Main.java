package _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion;

import _10_ObjectCommunicationAndEvents.ex.p03_dependency_inversion.interfaces.Strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrimitiveCalculator calc = new PrimitiveCalculator();
        StrategyFactory factory = new StrategyFactory();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if ("mode".equals(tokens[0])) {
                Strategy newStrategy = factory.chooseStrategy(tokens[1].charAt(0));
                calc.changeStrategy(newStrategy);
            } else {
                int firstNum = Integer.parseInt(tokens[0]);
                int secondNum = Integer.parseInt(tokens[1]);
                int result = calc.performCalculation(firstNum, secondNum);
                System.out.println(result);
            }
        }
    }


}
