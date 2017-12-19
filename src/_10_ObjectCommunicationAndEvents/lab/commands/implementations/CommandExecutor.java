package _10_ObjectCommunicationAndEvents.lab.commands.implementations;

import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Command;
import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
