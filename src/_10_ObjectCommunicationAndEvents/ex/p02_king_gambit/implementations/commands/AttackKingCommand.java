package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.commands;

import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.command_layer.Command;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Subject;

public class AttackKingCommand implements Command {

    private Subject king;

    public AttackKingCommand(Subject king) {
        this.king = king;
    }

    @Override
    public void execute() {
        this.king.notifyObservers();
    }
}
