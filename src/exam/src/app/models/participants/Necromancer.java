package app.models.participants;

import app.models.Config;

public class Necromancer extends AbstractHero {
    public Necromancer(String name) {
        super(name);
        super.setStrength(Config.NECROMANCER_BASE_STRENGTH);
        super.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
        super.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
        super.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * Config.NECROMANCER_DAMAGE_MULTIPLIER) +
                (super.getDexterity() * Config.NECROMANCER_DAMAGE_MULTIPLIER) +
                (super.getStrength() * Config.NECROMANCER_DAMAGE_MULTIPLIER);
    }

//    @Override
//    public void levelUp() {
//        super.setStrength(super.getStrength() * 2);
//        this.setDexterity(this.getDexterity() * 2);
//        this.setIntelligence(this.getIntelligence() * 2);
//        super.setHealth(super.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
//        super.setLevel(super.getLevel() + 1);
//    }
}
