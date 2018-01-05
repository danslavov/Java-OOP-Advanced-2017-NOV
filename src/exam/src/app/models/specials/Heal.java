package app.models.specials;

import app.contracts.Hero;
import app.contracts.Special;
import app.models.Config;

import java.lang.reflect.Field;

public class Heal implements Special {

    @Override
    public void trigger(Hero hero) throws NoSuchFieldException, IllegalAccessException {

        String simpleClassName = hero.getClass().getSimpleName();
        simpleClassName = simpleClassName.toUpperCase();
        String baseStrengthName = simpleClassName + "_BASE_STRENGTH";
        Class<Config> configClass = Config.class;
        Field baseStrengthField = configClass.getField(baseStrengthName);
        baseStrengthField.setAccessible(true);
        int baseStrength = (int) baseStrengthField.get(null);
        double initialHealth = baseStrength * Config.HERO_HEALTH_MULTIPLIER;

        if (hero.getHealth() <= initialHealth * 50d / 100) {
            hero.setHealth(hero.getHealth() + hero.getIntelligence());
        }
    }
}
