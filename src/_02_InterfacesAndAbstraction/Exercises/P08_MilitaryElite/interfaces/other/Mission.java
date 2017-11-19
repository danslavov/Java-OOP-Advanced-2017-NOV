package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other;

public interface Mission {
    String getCodeName();
    String getState();
    void completeMission();

    @Override
    String toString();
}
