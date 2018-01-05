package bg.softuni.commands;

import bg.softuni.annotations.InjectType;
import bg.softuni.core.ManagementSystem;

public class ProcessEmergenciesCommand extends BaseCommand implements Executable {

    @InjectType
    private String type;

    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().processEmergencies(this.type);
    }
}
