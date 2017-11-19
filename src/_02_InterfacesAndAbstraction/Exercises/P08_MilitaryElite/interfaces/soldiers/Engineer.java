package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Repair;

import java.util.List;

public interface Engineer extends SpecialisedSoldier {
    List<Repair> getRepairs();
}
