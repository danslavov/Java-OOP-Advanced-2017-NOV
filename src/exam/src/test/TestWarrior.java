import app.models.participants.Warrior;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class TestWarrior {

    private static final int DAMAGE_TO_TAKE = 10;
    private static final int EXPECTED_HEALTH = 40;
    private static final int ZERO_VALUE = 0;
    private static final int DAMAGE_TO_DIE = 1000;
    private static final Object[] EXPECTED_STATS_AFTER_LEVEL_UP =
            {100.0, 28.0, 10, 8, 2};
    private static final double REWARD_TO_RECEIVE = 50.5;
    private static final double EXPECTED_GOLD_AFTER_REWARD = 200.0 + REWARD_TO_RECEIVE;



    private Warrior warrior;

    @Before
    public void init() {
        this.warrior = new Warrior();
    }

    @Test
    public void takesCorrectDamage() {
        this.warrior.takeDamage(DAMAGE_TO_TAKE);
        Assert.assertEquals("Incorrect damage taken",
                EXPECTED_HEALTH, this.warrior.getHealth(), ZERO_VALUE);
    }

//    test if dead warrior can take damage (probably not needed)

    @Test
    public void returnsCorrectDeadState() {
        this.warrior.takeDamage(DAMAGE_TO_DIE);
        Assert.assertEquals("Should not be living",
                false, this.warrior.isAlive());
    }


// doesn't earn points from Judge
    @Test
    public void returnsCorrectLiveState() {
        this.warrior.takeDamage(DAMAGE_TO_TAKE);
        Assert.assertEquals("Should not be dead",
                true, this.warrior.isAlive());
    }

    @Test
    public void statsAreCorrectAfterLevelUp() {
        this.warrior.levelUp();
        Object[] actualStats = new Object[5];
        actualStats[0] = this.warrior.getHealth();
        actualStats[1] = this.warrior.getDamage();
        actualStats[2] = this.warrior.getStrength();
        actualStats[3] = this.warrior.getDexterity();
        actualStats[4] = this.warrior.getIntelligence();
        Assert.assertArrayEquals("Incorrect value after level up",
                EXPECTED_STATS_AFTER_LEVEL_UP, actualStats);
    }

    @Test
    public void correctlyReceivesReward() {
        this.warrior.receiveReward(REWARD_TO_RECEIVE);
        Assert.assertEquals("Incorrect gold after receiving reward",
                EXPECTED_GOLD_AFTER_REWARD,
                this.getGold(this.warrior), ZERO_VALUE);
// Judge doesn't have .getGold for Warrior so we need this class' method to get the value of "gold" by reflection
    }

    private double getGold(Warrior warrior) {
        try {
            Field goldField = warrior.getClass().getDeclaredField("gold");
            goldField.setAccessible(true);
            return (double) goldField.get(warrior);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0d;
    }
}
