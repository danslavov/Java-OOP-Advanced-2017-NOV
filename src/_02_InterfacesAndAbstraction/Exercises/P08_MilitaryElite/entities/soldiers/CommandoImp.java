package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Mission;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Repair;
import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Commando;

import java.util.Collections;
import java.util.List;

public class CommandoImp extends SpecialisedSoldierImp implements Commando {
    private List<Mission> missions;

    public CommandoImp(int id, String firstName, String lastName,
                       double salary, String corps, List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        setMissions(missions);
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    private void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(super.getCorps())
                .append(System.lineSeparator())
                .append("Missions:");

        for (Mission mission : this.getMissions()) {
            sb
                    .append(System.lineSeparator())
                    .append("  " + mission.toString());
        }

        return sb.toString();
    }
}
