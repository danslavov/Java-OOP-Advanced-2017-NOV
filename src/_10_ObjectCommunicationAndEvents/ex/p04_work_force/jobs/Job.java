package _10_ObjectCommunicationAndEvents.ex.p04_work_force.jobs;

public interface Job {
    void update();
    boolean isDone();
    String getName();
    int getRequiredHours();
}
