package _10_ObjectCommunicationAndEvents.lab.characters.implementations;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Target;
import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;
import _10_ObjectCommunicationAndEvents.lab.loggers.interfaces.Handler;

public class Dragon implements Target {

    protected static final String THIS_DIED_EVENT = "%s dies";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private Handler logger;

    public Dragon(String id, int hp, int reward, Handler logger) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.logger = logger;
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
        }

        if (this.isDead() && !eventTriggered) {
            this.logger.handle(LogType.EVENT, String.format(THIS_DIED_EVENT, this));
            this.eventTriggered = true;
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected int getHp() {
        return hp;
    }

    protected void setHp(int hp) {
        this.hp = hp;
    }

    public int getReward() {
        return reward;
    }

    protected void setReward(int reward) {
        this.reward = reward;
    }

    protected boolean isEventTriggered() {
        return eventTriggered;
    }

    protected void setEventTriggered(boolean eventTriggered) {
        this.eventTriggered = eventTriggered;
    }

    protected Handler getLogger() {
        return logger;
    }
}
