package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.commands;

import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.command_layer.Command;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Subject;

public class KillCharacterCommand implements Command {

    private Subject king;
    private String characterName;

    public KillCharacterCommand(Subject king, String characterName) {
        this.king = king;
        this.characterName = characterName;
    }

    @Override
    public void execute() {
        this.king.removeObserver(this.characterName);
    }
}
