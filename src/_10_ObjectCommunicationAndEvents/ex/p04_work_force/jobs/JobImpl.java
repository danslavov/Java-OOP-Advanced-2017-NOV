package _10_ObjectCommunicationAndEvents.ex.p04_work_force.jobs;

import _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees.Employee;

public class JobImpl implements Job {

    private String name;
    private int requiredHours;
    private Employee employee;
    private boolean isDone;

    public JobImpl(String name, int requiredHours, Employee employee) {
        this.name = name;
        this.requiredHours = requiredHours;
        this.employee = employee;
        this.isDone = false;
    }

    @Override
    public void update() {
        this.requiredHours -= this.employee.getHoursPerWeek();
        if (this.requiredHours <= 0) {
            this.isDone = true;
        }
    }

    @Override
    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getRequiredHours() {
        return requiredHours;
    }
}
