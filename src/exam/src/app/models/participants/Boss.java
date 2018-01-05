package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends AbstractParticipant {

    public Boss(String name) {
        super(name);
        super.setGold(Config.BOSS_GOLD);
        super.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        if (!target.isAlive()) {
            target.giveReward(this);
            this.levelUp();
        }

        return null;
    }

    @Override
    public void receiveReward(double reward) {
        super.receiveReward(reward * 10 / 100);
    }

    @Override
    public void levelUp() {
        super.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }


//    @Override
//    public void takeDamage(double damage) {
//
//    }

//    @Override
//    public String getName() {
//        return null;
//    }

//    @Override
//    public void setName(String name) {
//
//    }



//    @Override
//    public double getHealth() {
//        return 0;
//    }
//
//    @Override
//    public double getGold() {
//        return 0;
//    }
//
//    @Override
//    public void setHealth(double health) {
//
//    }

//    @Override
//    public void giveReward(Targetable targetable) {
//
//    }



//    @Override
//    public boolean isAlive() {
//        return false;
//    }
}
