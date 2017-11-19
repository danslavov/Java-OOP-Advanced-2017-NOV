package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Soldier;

public abstract class SoldierImp implements Soldier {
    private int id;
    private String firstName;
    private String lastName;

    public SoldierImp(int id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("Name: %s %s Id: %d",
                this.getFirstName(), this.getLastName(), this.getId());
    }
}
