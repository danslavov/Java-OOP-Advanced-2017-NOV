package app.waste_disposal.contracts;

public interface ManagementRequirement {

    String getWasteTypeName();
    double getEnergyRequirement();
    double getCapitalRequirement();

    void setWasteTypeName(String wasteTypeName);
    void setEnergyRequirement(double value);
    void setCapitalRequirement(double value);
}
