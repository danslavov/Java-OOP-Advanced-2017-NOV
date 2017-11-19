package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers;

public interface Soldier {
    int getId();
    String getFirstName();
    String getLastName();

    @Override
    String toString();
}
