package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.other;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Mission;

public class MissionImp implements Mission {
    private String name;
    private String state;

    public MissionImp(String name, String state) {
        setCodeName(name);
        setState(state);
    }

    @Override
    public String getCodeName() {
        return this.name;
    }

    private void setCodeName(String name) {
        this.name = name;
    }

    @Override
    public String getState() {
        return this.state;
    }

    private void setState(String state) {
        if ("inProgress".equals(state) || "Finished".equals(state)) {
            this.state = state;
        } else {
            throw new IllegalArgumentException("Wrong state!");
        }
    }

    @Override
    public void completeMission() {
        this.setState("Finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(), this.getState());
    }
}
