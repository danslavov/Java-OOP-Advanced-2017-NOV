package _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.entities;

import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.interfaces.BirthdayCelebratable;

public class Pet implements BirthdayCelebratable {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
