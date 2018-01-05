package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(String observer);
    void harmObserver(String name);
    void notifyObservers();
}
