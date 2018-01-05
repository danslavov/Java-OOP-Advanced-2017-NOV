package app.core;

import app.contracts.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private static final String INVALID_COMMAND = "Invalid command";
    private Reader reader;
    private Writer writer;
    private Battlefield battleField;

    public EngineImpl(Reader reader, Writer writer, Battlefield battleField) {
        this.reader = reader;
        this.writer = writer;
        this.battleField = battleField;
    }

    @Override
    public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        String line = reader.readLine();
        while (!line.equals("Peace")){
            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0].toLowerCase()){

                case "createparticipant" :
                    battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;

                case "createaction" :
                    battleField.createAction(lineTokens[1],
                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                    Arrays.stream(lineTokens).skip(2).toArray().length,
                                    String[].class));
                    break;

                case "statparticipants" :
                    battleField.reportParticipants();
                    break;

                case "statactions" :
                    battleField.reportActions();
                    break;

                default:
                    writer.writeLine(INVALID_COMMAND);
                    break;
            }

            line = reader.readLine();
        }
    }
}
