package _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.ObservableTarget;
import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Command;
import _10_ObjectCommunicationAndEvents.lab.mediation.AttackGroup;

public class GroupTargetCommand implements Command {

    private AttackGroup attackGroup;
    private ObservableTarget target;

    public GroupTargetCommand(AttackGroup attackGroup, ObservableTarget target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}
