package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.soldiers;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.soldiers.SpecialisedSoldier;

public abstract class SpecialisedSoldierImp extends PrivateImp implements SpecialisedSoldier {
    private String corps;

    public SpecialisedSoldierImp(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        setCorps(corps);
    }

    private void setCorps(String corps) {
        if ("Airforces".equals(corps) || "Marines".equals(corps)) {
            this.corps = corps;
        } else {
            throw new IllegalArgumentException("Wrong corps!");
        }
    }

    @Override
    public String getCorps() {
        return this.corps;
    }
}
