package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit;

import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters.Footman;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters.King;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters.RoyalGuard;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.commands.AttackKingCommand;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.commands.CommandExecutor;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.commands.HarmCharacterCommand;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.command_layer.Command;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.command_layer.Executor;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Observer;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String kingName = reader.readLine();
        String[] guardNames = reader.readLine().split("\\s+");
        String[] footmanNames = reader.readLine().split("\\s+");
        Subject king = new King(kingName);
        addObservers(king, guardNames);
        addFootmen(king, footmanNames);
        Executor exe = new CommandExecutor();
        processCommands(reader, king, exe);
    }

    private static void addObservers(Subject king, String[] guardNames) {
        for (String name : guardNames) {
            Observer guard = new RoyalGuard(name);
            king.addObserver(guard);
        }
    }

    private static void addFootmen(Subject king, String[] footmanNames) {
        for (String name : footmanNames) {
            Observer footman = new Footman(name);
            king.addObserver(footman);
        }
    }

    private static void processCommands(BufferedReader reader, Subject king, Executor exe) throws IOException {
        String input;
        while(!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Attack")) {
                Command attackCommand = new AttackKingCommand(king);
                exe.executeCommand(attackCommand);
            } else {
                String characterName = tokens[1];
                Command harmCommand = new HarmCharacterCommand(king, characterName);
                exe.executeCommand(harmCommand);
            }
        }
    }
}
