package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.enums.Status;
import bg.softuni.utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {

    private Status status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel,
                          RegistrationTime registrationTime,
                          Status status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public Integer getResultAfterProcessing() {

        switch (this.status) {
            case SPECIAL:
                return 1;
            case NON_SPECIAL:
                return 0;
            default:
                return null;
        }
    }
}
