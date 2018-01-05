package bg.softuni.commands;

import bg.softuni.annotations.InjectArgs;
import bg.softuni.core.ManagementSystem;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.emergencies.Emergency;
import bg.softuni.models.emergencies.PropertyEmergency;
import bg.softuni.utils.RegistrationTime;
import bg.softuni.utils.RegistrationTimeImpl;

public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private RegistrationTime registrationTime;
    private Emergency emergency;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        Integer propertyDamage = Integer.valueOf(this.params[4]);
        this.createRegistrationTime(this.params[3]);
        this.emergency = new PropertyEmergency(description, level, this.registrationTime, propertyDamage);
        return super.getManagementSystem().registerPropertyEmergency(this.emergency);
    }

    private void createRegistrationTime(String registrationTime) {
        this.registrationTime = new RegistrationTimeImpl(registrationTime);
    }
}
