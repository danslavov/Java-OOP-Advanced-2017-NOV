package _10_ObjectCommunicationAndEvents.lab.characters.implementations;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Attacker;
import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.ObservableTarget;
import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Target;
import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;
import _10_ObjectCommunicationAndEvents.lab.loggers.interfaces.Handler;
import _10_ObjectCommunicationAndEvents.lab.observation.Observer;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";
    private static final String REWARD_RECEIVED_MESSAGE = "%s received %s";

    private String id;
    private int dmg;
    private  ObservableTarget target;
    private Handler logger;

    public AbstractHero(String id, int dmg, Handler logger) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
    }

    public void setTarget(ObservableTarget target) {
        if (target == null) {
            this.logger.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            this.target.register(this);
            this.logger.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            this.logger.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.logger.handle(LogType.ERROR, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg, this.logger);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void update(int reward) {
        this.logger.handle(LogType.EVENT, String.format(REWARD_RECEIVED_MESSAGE, this, reward));
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg, Handler logger);
}
