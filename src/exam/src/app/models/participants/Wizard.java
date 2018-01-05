package app.models.participants;

import app.models.Config;

public class Wizard extends AbstractHero {

    public Wizard(String name){
        super(name);
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
        super.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * Config.WIZARD_DAMAGE_MULTIPLIER)
                + super.getDexterity();
    }
}
