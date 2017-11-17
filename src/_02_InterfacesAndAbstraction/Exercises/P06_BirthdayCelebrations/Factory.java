package _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations;

import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.entities.Citizen;
import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.entities.Pet;
import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.entities.Robot;
import _02_InterfacesAndAbstraction.Exercises.P06_BirthdayCelebrations.interfaces.BirthdayCelebratable;

public class Factory {

    public BirthdayCelebratable makeElement(String[] tokens) {

        String type = tokens[0];
        String name = tokens[1];

        switch (type) {

            case "Citizen":
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String bDay = tokens[4];
                return new Citizen(name, age, id, bDay);

            case "Pet":
                bDay = tokens[2];
                return new Pet(name, bDay);

                default:
                    return null;
        }
    }
}
