package _10_ObjectCommunicationAndEvents.ex.p04_work_force;

import _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees.Employee;
import _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees.PartTimeEmployee;
import _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees.StandartEmployee;
import _10_ObjectCommunicationAndEvents.ex.p04_work_force.jobs.Job;
import _10_ObjectCommunicationAndEvents.ex.p04_work_force.jobs.JobImpl;

public class Factory {

    public Job createJob(String jobName, int hours, Employee employee) {
        return new JobImpl(jobName, hours, employee);
    }

    public Employee createEmployee(String name, boolean isStandard) {
        if (isStandard) {
            return new StandartEmployee(name);
        } else {
            return new PartTimeEmployee(name);
        }
    }
}
