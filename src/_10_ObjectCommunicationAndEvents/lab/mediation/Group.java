package _10_ObjectCommunicationAndEvents.lab.mediation;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Attacker;
import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.ObservableTarget;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        for (Attacker a : attackers) {
            a.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        this.attackers.forEach(Attacker::attack);
    }
}
