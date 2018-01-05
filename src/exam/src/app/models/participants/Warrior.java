package app.models.participants;

import app.models.Config;

public class Warrior extends AbstractHero {

    public Warrior() {
        this.setStrength(Config.WARRIOR_BASE_STRENGTH);
        this.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        this.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
        super.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    public Warrior(String name){
        super(name);
        this.setStrength(Config.WARRIOR_BASE_STRENGTH);
        this.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        this.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
        super.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);

    }

    @Override
    public double getDamage() {
        return (this.getStrength() * Config.WARRIOR_DAMAGE_MULTIPLIER)
                + this.getDexterity();
    }
}
