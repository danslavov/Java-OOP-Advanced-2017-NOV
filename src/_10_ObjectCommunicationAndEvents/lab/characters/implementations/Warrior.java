package _10_ObjectCommunicationAndEvents.lab.characters.implementations;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Target;
import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;
import _10_ObjectCommunicationAndEvents.lab.loggers.interfaces.Handler;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg, Handler logger) {
        logger.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
