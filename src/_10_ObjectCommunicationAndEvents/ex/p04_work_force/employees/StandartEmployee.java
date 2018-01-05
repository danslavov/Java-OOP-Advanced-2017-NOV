package _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees;

public class StandartEmployee extends BasicEmployee {

    private static final int HOURS = 40;

    public StandartEmployee(String name) {
        super(name);
        super.setHoursPerWeek(HOURS);
    }
}
