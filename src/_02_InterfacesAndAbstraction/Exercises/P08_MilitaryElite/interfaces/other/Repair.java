package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other;

public interface Repair {
    String getPartName();
    int getHoursWorked();

    @Override
    String toString();
}
