package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.LeutenantGeneral;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Private;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Soldier;

import java.util.*;

public class LeutenantGeneralImp extends PrivateImp implements LeutenantGeneral {
    private Map<Integer, Private> privates;

    public LeutenantGeneralImp(int id, String firstName, String lastName,
                               double salary, Map<Integer, Private> privates) {
        super(id, firstName, lastName, salary);
        setPrivates(privates);
    }

    @Override
    public Map<Integer, Private> getPrivates() {
        return Collections.unmodifiableMap(this.privates);
    }

    private void setPrivates(Map<Integer, Private> privates) {
        this.privates = privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb
                .append(System.lineSeparator())
                .append("Privates:");

        for (Private aPrivate : this.getPrivates().values()) {
            sb
                    .append(System.lineSeparator())
                    .append("  " + aPrivate);
        }

        return sb.toString();
    }
}
