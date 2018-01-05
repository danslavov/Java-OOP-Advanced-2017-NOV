package bg.softuni.commands;

import bg.softuni.core.ManagementSystem;

public class EmergencyReportCommand extends BaseCommand implements Executable {

    public EmergencyReportCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().emergencyReport();
    }
}
