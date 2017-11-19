package _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.entities.other;

import _02_InterfacesAndAbstraction.Exercises.P08_MilitaryElite.interfaces.other.Repair;

public class RepairImp implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImp(String partName, int hoursWorked) {
        setPartName(partName);
        setHoursWorked(hoursWorked);
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",
                this.getPartName(), this.getHoursWorked());
    }
}
