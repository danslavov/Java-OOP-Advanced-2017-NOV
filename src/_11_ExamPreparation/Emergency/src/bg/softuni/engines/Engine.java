package bg.softuni.engines;

import bg.softuni.commands.Executable;
import bg.softuni.interpreters.Interpreter;
import bg.softuni.io.Reader;
import bg.softuni.io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private Interpreter commandInterpreter;

    public Engine(Reader reader, Writer writer, Interpreter commandInterpreter) {
        this.reader = reader;
        this.writer = writer;
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        try {
            String line = this.reader.read();

            while (!line.equals("EmergencyBreak")) {
                Executable command = this.commandInterpreter.interpretCommand(line);
                this.writer.write(command.execute());
                line = this.reader.read();
            }
        } catch (IOException | InstantiationException |
                InvocationTargetException | NoSuchMethodException |
                IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
