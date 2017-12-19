package _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands;

import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Command;
import _10_ObjectCommunicationAndEvents.lab.mediation.AttackGroup;

public class GroupAttackCommand implements Command {

    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }

    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}
