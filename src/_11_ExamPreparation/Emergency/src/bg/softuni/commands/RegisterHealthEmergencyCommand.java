package bg.softuni.commands;

import bg.softuni.annotations.InjectArgs;
import bg.softuni.core.ManagementSystem;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.emergencies.Emergency;
import bg.softuni.models.emergencies.HealthEmergency;
import bg.softuni.utils.RegistrationTime;
import bg.softuni.utils.RegistrationTimeImpl;

public class RegisterHealthEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private RegistrationTime registrationTime;
    private Emergency emergency;

    public RegisterHealthEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        Integer casualties = Integer.valueOf(this.params[4]);
        this.createRegistrationTime(this.params[3]);
        this.emergency = new HealthEmergency(description, level, this.registrationTime, casualties);
        return super.getManagementSystem().registerHealthEmergency(this.emergency);
    }

    private void createRegistrationTime(String registrationTime) {
        this.registrationTime = new RegistrationTimeImpl(registrationTime);
    }
}
