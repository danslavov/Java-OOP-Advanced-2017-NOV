package _10_ObjectCommunicationAndEvents.lab;

import _10_ObjectCommunicationAndEvents.lab.characters.implementations.ObservedDragon;
import _10_ObjectCommunicationAndEvents.lab.characters.implementations.Warrior;
import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Attacker;
import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.ObservableTarget;
import _10_ObjectCommunicationAndEvents.lab.commands.implementations.CommandExecutor;
import _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands.AttackCommand;
import _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands.GroupAttackCommand;
import _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands.GroupTargetCommand;
import _10_ObjectCommunicationAndEvents.lab.commands.implementations.concrete_commands.TargetCommand;
import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Command;
import _10_ObjectCommunicationAndEvents.lab.commands.interfaces.Executor;
import _10_ObjectCommunicationAndEvents.lab.loggers.implementations.CombatLogger;
import _10_ObjectCommunicationAndEvents.lab.loggers.implementations.ErrorLogger;
import _10_ObjectCommunicationAndEvents.lab.loggers.implementations.EventLogger;
import _10_ObjectCommunicationAndEvents.lab.loggers.implementations.TargetLogger;
import _10_ObjectCommunicationAndEvents.lab.loggers.interfaces.Handler;
import _10_ObjectCommunicationAndEvents.lab.mediation.AttackGroup;
import _10_ObjectCommunicationAndEvents.lab.mediation.Group;

public class Main {
    public static void main(String[] args) {
        Handler combatLog = new CombatLogger();
        Handler targetLog = new TargetLogger();
        Handler errorLog = new ErrorLogger();
        Handler eventLog = new EventLogger();

        combatLog.setSuccessor(targetLog);
        targetLog.setSuccessor(errorLog);
        errorLog.setSuccessor(eventLog);
//        eventLog.setSuccessor(combatLog);

        Executor commandExecutor = new CommandExecutor();

        Attacker firstAttacker = new Warrior("Sveti Georgi", 15, combatLog);
        Attacker secondAttacker = new Warrior("Sveti Georgi", 15, combatLog);
        Attacker thirdAttacker = new Warrior("Sveti Georgi", 15, combatLog);
//        Target target = new Dragon("Spaska", 100, 1000, targetLog);
        ObservableTarget target = new ObservedDragon("Spaska", 100, 1000, targetLog);


        Command targetCommand = new TargetCommand(firstAttacker, target);
        Command attackCommand = new AttackCommand(firstAttacker);
        commandExecutor.executeCommand(targetCommand);
        commandExecutor.executeCommand(attackCommand);

        AttackGroup group = new Group();
        group.addMember(firstAttacker);
        group.addMember(secondAttacker);
        group.addMember(thirdAttacker);

        Command gtc = new GroupTargetCommand(group, target);
        Command gac = new GroupAttackCommand(group);

        commandExecutor.executeCommand(gtc);
        commandExecutor.executeCommand(gac);
        commandExecutor.executeCommand(gac);



    }
}
