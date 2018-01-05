package _10_ObjectCommunicationAndEvents.ex.p04_work_force;

import _10_ObjectCommunicationAndEvents.ex.p04_work_force.employees.Employee;
import _10_ObjectCommunicationAndEvents.ex.p04_work_force.jobs.Job;
import _10_ObjectCommunicationAndEvents.ex.p04_work_force.jobs.JobCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Factory factory = new Factory();
        JobCollection jobCollection = new JobCollection();
        Map<String, Employee> employees = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Job":
                    addNewJob(factory, jobCollection, employees, tokens);
                    break;
                case "StandartEmployee":        // typo in description
                    addNewEmployee(factory, employees, tokens[1], true);
                    break;
                case "PartTimeEmployee":
                    addNewEmployee(factory, employees, tokens[1], false);
                    break;
                case "Pass":
                    jobCollection.updateAll();
                    break;
                case "Status":
                    jobCollection.getStatus();
            }
        }
    }

    private static void addNewJob(Factory factory, JobCollection jobCollection, Map<String, Employee> employees, String[] tokens) {
        String jobName = tokens[1];
        int hours = Integer.parseInt(tokens[2]);
        Employee existingEmployee = employees.get(tokens[3]);
        Job newJob = factory.createJob(jobName, hours, existingEmployee);
        jobCollection.addJob(newJob);
    }

    private static void addNewEmployee(Factory factory, Map<String, Employee> employees, String name, boolean isStandard) {
        Employee newEmployee;
        if (isStandard) {
            newEmployee = factory.createEmployee(name, true);
        } else {
            newEmployee = factory.createEmployee(name, false);
        }
        employees.put(name, newEmployee);
    }
}
