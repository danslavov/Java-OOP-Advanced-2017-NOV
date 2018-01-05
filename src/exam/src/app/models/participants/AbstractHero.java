package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class AbstractHero extends AbstractParticipant implements Hero {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;

    protected AbstractHero() {
        super.setGold(Config.HERO_START_GOLD);
        this.level = Config.HERO_START_LEVEL;
    }

    protected AbstractHero(String name) {
        super(name);
        super.setGold(Config.HERO_START_GOLD);
        this.level = Config.HERO_START_LEVEL;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void levelUp() {
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        super.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.setLevel(this.getLevel() + 1);
    }

    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        // Warrior triggers his special right after he receives damage
        if (target instanceof Warrior) {

        }


        String result = "";

        if (!(target instanceof Boss)) {
            result = this.getName() + " attacked!";
        }

        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);

            if (!(target instanceof Boss)) {
                result += String.format(" %s has been slain by %s.",
                        target.getName(), this.getName());
            }
        }

        return result;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), super.getGold()));

        return sb.toString();
    }

    private int getLevel() {
        return this.level;
    }

    private void setLevel(int level) {
        this.level = level;
    }
}
