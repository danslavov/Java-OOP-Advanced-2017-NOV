package bg.softuni.commands;

import bg.softuni.annotations.InjectArgs;
import bg.softuni.core.ManagementSystem;
import bg.softuni.models.centers.EmergencyCenter;
import bg.softuni.models.centers.PoliceServiceCenter;

public class RegisterPoliceServiceCenterCommand extends BaseCommand implements Executable {

    @InjectArgs
    private String[] params;
    private EmergencyCenter center;

    public RegisterPoliceServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String centerName = this.params[1];
        Integer amountOfEmergencies = Integer.valueOf(this.params[2]);

        this.center = new PoliceServiceCenter(centerName, amountOfEmergencies);
        return super.getManagementSystem().registerPoliceServiceCenter(this.center);
    }
}
