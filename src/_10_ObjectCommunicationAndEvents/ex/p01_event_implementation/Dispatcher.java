package _10_ObjectCommunicationAndEvents.ex.p01_event_implementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener ncl) {
        this.nameChangeListeners.add(ncl);
    }

    public void removeNameChangeListener(NameChangeListener ncl) {
        this.nameChangeListeners.remove(ncl);
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent();
    }

    private void fireNameChangeEvent() {
        NameChange event = new NameChange(this.name);
        for (NameChangeListener ncl : this.nameChangeListeners) {
            ncl.handleChangedName(event);
        }
    }
}
