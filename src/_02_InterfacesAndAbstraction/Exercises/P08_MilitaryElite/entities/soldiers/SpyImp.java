package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.Spy;

public class SpyImp extends SoldierImp implements Spy {
    private int codeNumber;

    public SpyImp(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    private void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%nCode Number: %d",
                super.toString(), this.getCodeNumber());
    }
}
