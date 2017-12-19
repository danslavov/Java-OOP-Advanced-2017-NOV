package _10_ObjectCommunicationAndEvents.lab.mediation;

import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.Attacker;
import _10_ObjectCommunicationAndEvents.lab.characters.interfaces.ObservableTarget;

public interface AttackGroup {

    void addMember(Attacker member);
    void groupTarget(ObservableTarget target);
    void groupAttack();
}
