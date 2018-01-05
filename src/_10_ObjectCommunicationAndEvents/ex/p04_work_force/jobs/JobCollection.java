package _10_ObjectCommunicationAndEvents.ex.p04_work_force.jobs;

import java.util.ArrayList;
import java.util.List;

public class JobCollection {

    private static final String JOB_DONE_MESSAGE = "Job %s done!%n";
    private static final String JOB_STATUS_MESSAGE = "Job: %s Hours Remaining: %d%n";

    private List<Job> jobs;

    public JobCollection() {
        this.jobs = new ArrayList<>();
    }

    public void addJob(Job newJob) {
        this.jobs.add(newJob);
    }

    public void updateAll() {

        List<Job> jobsToRemove = new ArrayList<>();
        for (Job job : jobs) {
            job.update();
            if (job.isDone()) {
                System.out.printf(JOB_DONE_MESSAGE, job.getName());
                jobsToRemove.add(job);
            }
        }
        this.jobs.removeAll(jobsToRemove);
    }

    public void getStatus() {
        for (Job job : jobs) {
            System.out.printf(JOB_STATUS_MESSAGE,
                    job.getName(), job.getRequiredHours());
        }
    }
}
