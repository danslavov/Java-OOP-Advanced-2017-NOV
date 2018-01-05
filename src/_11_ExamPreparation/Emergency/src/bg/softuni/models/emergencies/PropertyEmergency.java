package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {

    private Integer damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel,
                                RegistrationTime registrationTime,Integer damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.damage;
    }
}
