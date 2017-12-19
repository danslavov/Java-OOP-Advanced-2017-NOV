package _10_ObjectCommunicationAndEvents.lab.observation;

public interface Subject {

    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();

}
