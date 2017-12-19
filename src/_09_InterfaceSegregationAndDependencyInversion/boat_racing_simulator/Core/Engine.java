package _09_InterfaceSegregationAndDependencyInversion.boat_racing_simulator.Core;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandlerImpl commandHandler;

    public Engine() {
        this.commandHandler = new CommandHandlerImpl();
    }

    public void Run() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String line;
        while (true) {
            line = scanner.nextLine();
            List<String> parameters;

            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            name = tokens.get(0);
            parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                System.out.println(commandResult);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
