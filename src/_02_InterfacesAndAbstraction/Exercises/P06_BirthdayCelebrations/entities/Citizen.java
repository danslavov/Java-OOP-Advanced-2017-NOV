package _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.entities;

import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.interfaces.BirthdayCelebratable;
import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.interfaces.Identifiable;

public class Citizen implements BirthdayCelebratable {
    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
