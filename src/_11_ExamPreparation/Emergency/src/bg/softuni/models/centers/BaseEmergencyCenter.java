package bg.softuni.models.centers;

public abstract class BaseEmergencyCenter implements EmergencyCenter {

    private String name;

    private Integer amountOfMaximumEmergencies;

    private Integer processedEmergencies = 0;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    @Override
    public Integer getProcessedEmergencies() {
        return this.processedEmergencies;
    }

    @Override
    public void processEmergency() {
        this.processedEmergencies++;
    }

    public Boolean isForRetirement() {
        return this.processedEmergencies >= this.amountOfMaximumEmergencies;
    }
}
