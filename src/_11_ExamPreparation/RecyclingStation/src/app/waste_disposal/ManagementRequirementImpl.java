package app.waste_disposal;

import app.waste_disposal.contracts.ManagementRequirement;

public class ManagementRequirementImpl implements ManagementRequirement {

    private String wasteTypeName;
    private double energyRequirement;
    private double capitalRequirement;

    public ManagementRequirementImpl() {
        this.wasteTypeName = "";
    }

    @Override
    public String getWasteTypeName() {
        return this.wasteTypeName;
    }

    @Override
    public double getEnergyRequirement() {
        return this.energyRequirement;
    }

    @Override
    public double getCapitalRequirement() {
        return this.capitalRequirement;
    }

    @Override
    public void setWasteTypeName(String wasteTypeName) {
        this.wasteTypeName = wasteTypeName;
    }

    @Override
    public void setEnergyRequirement(double energyRequirement) {
        this.energyRequirement = energyRequirement;
    }

    @Override
    public void setCapitalRequirement(double capitalRequirement) {
        this.capitalRequirement = capitalRequirement;
    }
}
