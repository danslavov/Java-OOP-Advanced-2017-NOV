package panzer.models.miscellaneous;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() {

        String input;
        List<String> arguments = new ArrayList<>();
        try {
            while (!"Terminate".equals(input = reader.readLine())) {
                arguments = Arrays.asList(input.split("\\s+"));
                String command = arguments.get(0);
                switch (command) {
                    case "Vehicle":
                        writer.println(this.manager.addVehicle(arguments));
                        break;
                    case "Part":
                        writer.println(this.manager.addPart(arguments));
                        break;
                    case "Battle":
                        writer.println(this.manager.battle(arguments));
                        break;
                    case "Inspect":
                        writer.println(this.manager.inspect(arguments));
                        break;

                }
            }

            this.writer.println(this.manager.terminate(arguments));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
