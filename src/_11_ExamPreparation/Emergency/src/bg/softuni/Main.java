package bg.softuni;

import bg.softuni.core.EmergencyManagementSystem;
import bg.softuni.core.ManagementSystem;
import bg.softuni.engines.Engine;
import bg.softuni.interpreters.CommandInterpreter;
import bg.softuni.interpreters.Interpreter;
import bg.softuni.io.ConsoleReader;
import bg.softuni.io.ConsoleWriter;
import bg.softuni.io.Reader;
import bg.softuni.io.Writer;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(managementSystem);
        Runnable engine = new Engine(reader,writer,interpreter);
        engine.run();
    }
}
