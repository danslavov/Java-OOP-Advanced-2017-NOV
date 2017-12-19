package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.commands;

import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.command_layer.Command;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.command_layer.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
