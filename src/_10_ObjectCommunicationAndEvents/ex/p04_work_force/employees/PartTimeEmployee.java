package _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees;

public class PartTimeEmployee extends BasicEmployee {

    private static final int HOURS = 20;

    public PartTimeEmployee(String name) {
        super(name);
        super.setHoursPerWeek(HOURS);
    }
}