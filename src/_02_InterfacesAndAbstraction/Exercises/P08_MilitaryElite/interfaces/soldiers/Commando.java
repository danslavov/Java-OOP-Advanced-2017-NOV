package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Mission;

import java.util.List;

public interface Commando extends SpecialisedSoldier {
    List<Mission> getMissions();
}
