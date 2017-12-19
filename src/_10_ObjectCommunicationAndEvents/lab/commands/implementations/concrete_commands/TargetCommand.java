package _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Attacker;
import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.ObservableTarget;
import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Command;

public class TargetCommand implements Command {

    private Attacker attacker;
    private ObservableTarget target;

    public TargetCommand(Attacker attacker, ObservableTarget target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
