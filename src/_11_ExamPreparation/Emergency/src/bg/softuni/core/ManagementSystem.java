package bg.softuni.core;

import bg.softuni.models.centers.EmergencyCenter;
import bg.softuni.models.emergencies.Emergency;

public interface ManagementSystem {

    String registerPropertyEmergency(Emergency emergency);

    String registerHealthEmergency(Emergency emergency);

    String registerOrderEmergency(Emergency emergency);

    String registerFireServiceCenter(EmergencyCenter emergencyCenter);

    String registerMedicalServiceCenter(EmergencyCenter emergencyCenter);

    String registerPoliceServiceCenter(EmergencyCenter emergencyCenter);

    String processEmergencies(String type);

    String emergencyReport();
}
