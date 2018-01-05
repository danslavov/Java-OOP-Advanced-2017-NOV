package _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees;

public abstract class BasicEmployee implements Employee {

    private String name;
    private int hoursPerWeek;

    protected BasicEmployee(String name) {
        this.name = name;
    }

    @Override
    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    @Override
    public void setHoursPerWeek(int hours) {
        this.hoursPerWeek = hours;
    }
}
