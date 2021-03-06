package _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.entities;

import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.interfaces.Identifiable;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
