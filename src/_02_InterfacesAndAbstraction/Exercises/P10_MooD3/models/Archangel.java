package _02_InterfacesAndAbstraction.Exercises.P10_MooD3.models;

import _02_InterfacesAndAbstraction.Exercises.P10_MooD3.interfaces.GameObject;

public class Archangel extends GameObjectImpl implements GameObject {
    public Archangel(String username, int level, int specialPoints) {
        super(username, level, specialPoints);
    }

    @Override
    public String getHashedPassword() {
        return new StringBuilder(super.getUsername()).reverse().toString()
                + super.getUsername().length() * 21;
    }
}
