package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.interfaces.observation_layer;

public interface Observer {
    String getName();
    int getHealth();
    void setHealth(int health);
    void respond();
}
