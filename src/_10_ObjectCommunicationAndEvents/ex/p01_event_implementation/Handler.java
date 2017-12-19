package _10_ObjectCommunicationAndEvents.ex.p01_event_implementation;

public class Handler implements NameChangeListener {
    @Override
    public void handleChangedName(NameChange event) {
        System.out.println("Dispatcher's name changed to " + event.getChangedName() + ".");
    }
}
