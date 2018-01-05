package app;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.core.EngineImpl;
import app.factories.ActionFactoryImpl;
import app.factories.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        TargetableFactory targetableFactory = new TargetableFactoryImpl("app.models.participants.");
        ActionFactory actionFactory = new ActionFactoryImpl("app.models.actions.");
        Battlefield battlefield = new BattlefieldImplementation(writer, targetableFactory, actionFactory);
        Engine engine = new EngineImpl(reader, writer, battlefield);

        try {
            engine.run();
        } catch (Exception e) {
            writer.writeLine(e.getMessage());
        }
    }
}
