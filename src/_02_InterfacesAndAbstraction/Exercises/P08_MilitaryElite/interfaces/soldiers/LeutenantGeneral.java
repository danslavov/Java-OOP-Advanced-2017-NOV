package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers;

import java.util.Map;

public interface LeutenantGeneral extends Private {
    Map<Integer, Private> getPrivates();
}
