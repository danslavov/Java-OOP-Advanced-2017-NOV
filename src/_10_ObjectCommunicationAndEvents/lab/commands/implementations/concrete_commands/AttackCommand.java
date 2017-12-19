package _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Attacker;
import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Command;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
