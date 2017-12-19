package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters;

import _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer.Observer;

public abstract class ObserverImpl implements Observer {

    private String name;

    protected ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
