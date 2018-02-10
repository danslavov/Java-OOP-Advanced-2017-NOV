package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseVehicle implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private long attack;
    private long defense;
    private long hitPoints;
    private Assembler assembler;

    // order of input
    private List<Part> partsByInput;

    protected BaseVehicle(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints, Assembler assembler) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = assembler;
        this.partsByInput = new LinkedList<>();
    }


    @Override
    public double getTotalWeight() {
        return this.assembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.assembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.assembler.getTotalAttackModification() + this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.assembler.getTotalDefenseModification() + this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.assembler.getTotalHitPointModification() + this.hitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
        this.partsByInput.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
        this.partsByInput.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
        this.partsByInput.add(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.partsByInput;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {

        String type = this.getClass().getSimpleName();
        StringBuilder parts = new StringBuilder();
        parts.append("Parts: ");

        if (this.partsByInput.size() > 0) {
            for (Part part : partsByInput) {
                parts.append(part.getModel()).append(", ");
            }
            parts.delete(parts.length() - 2, parts.length() - 1);
        } else {
            parts.append("None");
        }

        StringBuilder result = new StringBuilder();

        String totalWeight = String.format("%.3f", this.getTotalWeight());
        String totalPrice = String.format("%.3f", this.getTotalPrice());

        result
                .append(type + " - " + this.getModel())
                .append(System.lineSeparator())
                .append("Total Weight: " + totalWeight)
                .append(System.lineSeparator())
                .append("Total Price: " + totalPrice)
                .append(System.lineSeparator())
                .append("Attack: " + this.getTotalAttack())
                .append(System.lineSeparator())
                .append("Defense: " + this.getTotalDefense())
                .append(System.lineSeparator())
                .append("HitPoints: " + this.getTotalHitPoints())
                .append(System.lineSeparator())
                .append(parts);

        return result.toString();
    }
}
