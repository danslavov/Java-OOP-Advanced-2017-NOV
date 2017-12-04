package _02_InterfacesAndAbstraction.Exercises.P10_MooD3.models;

import _02_InterfacesAndAbstraction.Exercises.P10_MooD3.interfaces.GameObject;

public abstract class GameObjectImpl <T> implements GameObject {

    private String username;
    private int level;
    private T specialPoints;

    public GameObjectImpl(String username, int level, T specialPoints) {
        this.setUsername(username);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public abstract String getHashedPassword();

    @Override
    public int getLevel() {
        return this.level;
    }

//    @Override
//    public <A> A getSpecialPoints() {
//        return (A) this.specialPoints;
//    }




    private void setUsername(String username) {
        this.username = username;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setSpecialPoints(T specialPoints) {
        this.specialPoints = specialPoints;
    }
}
