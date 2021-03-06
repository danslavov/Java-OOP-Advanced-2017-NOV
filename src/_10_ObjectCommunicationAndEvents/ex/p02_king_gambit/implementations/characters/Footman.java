package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters;

public class Footman extends ObserverImpl {

    private static final String RESPOND_MESSAGE = "Footman %s is panicking!%n";
    private static final int HEALTH = 2;

    public Footman(String name) {
        super(name);
        super.setHealth(HEALTH);
    }

    @Override
    public void respond() {
        System.out.printf(RESPOND_MESSAGE, super.getName());
    }
}
