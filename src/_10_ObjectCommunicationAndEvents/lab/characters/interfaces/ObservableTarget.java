package _10_ObjectCommunicationAndEvents.lab.characters.interfaces;

import _10_ObjectCommunicationAndEvents.lab.observation.Observer;
import _10_ObjectCommunicationAndEvents.lab.observation.Subject;

public interface ObservableTarget extends Target, Subject {

    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}
