package _10_ObjectCommunicationAndEvents.ex.p02_king_gambit.implementations.characters;

public class RoyalGuard extends ObserverImpl {

    private static final String RESPOND_MESSAGE = "Royal Guard %s is defending!%n";
    private static final int HEALTH = 3;

    public RoyalGuard(String name) {
        super(name);
        super.setHealth(HEALTH);
    }

    @Override
    public void respond() {
        System.out.printf(RESPOND_MESSAGE, super.getName());
    }
}
