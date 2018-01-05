package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters;

import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Observer;
import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Subject;

import java.util.LinkedHashMap;
import java.util.Map;

public class King implements Subject {

    private static final String NOTIFICATION_MESSAGE = "King %s is under attack!%n";

    private String name;
    private Map<String, Observer> observers;

    public King(String name) {
        this.name = name;
        this.observers = new LinkedHashMap<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.put(observer.getName(), observer);
    }

    public void harmObserver(String name) {
        Observer currentObserver = this.observers.get(name);
        int newHealth = currentObserver.getHealth() - 1;
        currentObserver.setHealth(newHealth);
        if (currentObserver.getHealth() <= 0) {
            this.removeObserver(currentObserver.getName());
        }
    }

    @Override
    public void removeObserver(String name) {
        this.observers.remove(name);
    }

    @Override
    public void notifyObservers() {
        System.out.printf(NOTIFICATION_MESSAGE, this.name);
        for (Observer o : observers.values()) {
            o.respond();
        }
    }
}
