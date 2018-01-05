package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency {

    private Integer countCasualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel,
                           RegistrationTime registrationTime,
                           Integer countCasualties) {
        super(description, emergencyLevel, registrationTime);
        this.countCasualties = countCasualties;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.countCasualties;
    }
}
