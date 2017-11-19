package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Repair;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Engineer;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Private;

import java.util.Collections;
import java.util.List;

public class EngineerImp extends SpecialisedSoldierImp implements Engineer {
    private List<Repair> repairs;

    public EngineerImp(int id, String firstName, String lastName,
                       double salary, String corps, List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        setRepairs(repairs);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    private void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(super.getCorps())
                .append(System.lineSeparator())
                .append("Repairs:");

        for (Repair repair : this.getRepairs()) {
            sb
                    .append(System.lineSeparator())
                    .append("  " + repair.toString());
        }

        return sb.toString();
    }
}
