package _10_ObjectCommunicationAndEvents.ex.p01_event_implementation;

public class NameChange {

    private String changedName;

    public NameChange(String changedName) {
        this.changedName = changedName;
    }

    public String getChangedName() {
        return changedName;
    }
}
