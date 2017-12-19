package _10_ObjectCommunicationAndEvents.lab.characters.implementations;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.ObservableTarget;
import _10_ObjectCommunicationAndEvents.lab.loggers.LogType;
import _10_ObjectCommunicationAndEvents.lab.loggers.interfaces.Handler;
import _10_ObjectCommunicationAndEvents.lab.observation.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservedDragon extends Dragon implements ObservableTarget {

    private List<Observer> observers;

    public ObservedDragon(String id, int hp, int reward, Handler logger) {
        super(id, hp, reward, logger);
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(super.getReward());
        }
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!super.isDead()) {
            super.setHp(super.getHp() - dmg);
        }

        if (this.isDead() && !super.isEventTriggered()) {
            super.getLogger().handle(LogType.EVENT, String.format(THIS_DIED_EVENT, this));
            super.setEventTriggered(true);
            notifyObservers();
        }
    }
}
