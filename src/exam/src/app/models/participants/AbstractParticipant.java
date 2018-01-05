package app.models.participants;

import app.contracts.Targetable;

public abstract class AbstractParticipant implements Targetable {

    private String name;
    private double health;
    private double gold;
    private boolean isAlive;

    protected AbstractParticipant() {
        this.isAlive = true;
    }

    protected AbstractParticipant(String name) {
        this();
        this.setName(name);
    }

    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.isAlive = false;
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void receiveReward(double reward) {
        this.gold += reward;
    }

    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    public abstract double getDamage();

    protected void setGold(double gold) {
        this.gold = gold;
    }
}
