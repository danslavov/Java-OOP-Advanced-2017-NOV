package bg.softuni.commands;

import bg.softuni.annotations.InjectArgs;
import bg.softuni.core.ManagementSystem;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.enums.Status;
import bg.softuni.models.emergencies.Emergency;
import bg.softuni.models.emergencies.OrderEmergency;
import bg.softuni.utils.RegistrationTime;
import bg.softuni.utils.RegistrationTimeImpl;

public class RegisterOrderEmergencyCommand extends BaseCommand implements Executable {

    @InjectArgs
    private String[] params;
    private RegistrationTime registrationTime;
    private Emergency emergency;

    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        String statusValue = this.params[4].replaceAll("-","_").toUpperCase();
        Status status = Status.valueOf(statusValue);
        this.createRegistrationTime(this.params[3]);
        this.emergency = new OrderEmergency(description, level, this.registrationTime, status);
        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }

    private void createRegistrationTime(String registrationTime) {
        this.registrationTime = new RegistrationTimeImpl(registrationTime);
    }
}
