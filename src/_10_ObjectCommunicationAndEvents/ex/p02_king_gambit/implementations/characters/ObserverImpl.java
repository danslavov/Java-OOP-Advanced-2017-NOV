package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters;

import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Observer;

public abstract class ObserverImpl implements Observer {

    private String name;
    private int health;

    protected ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}
