package rpg_tests;

import implementations.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static rpg_tests.TestValues.*;

public class DummyTests {

    private Dummy target;

    @Before
    public void initializeTestObjects() {
        this.target = new Dummy(TARGET_HEALTH, TARGET_XP);
    }

    @Test
    public void targetLosesHealthWhenAttacked() {
        target.takeAttack(ATTACK_POINTS_LESS_THAN_HEALTH);
        Assert.assertEquals("Target doesn't lose health when attacked.",
                ATTACK_POINTS_LESS_THAN_HEALTH, target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void cantAttackDeadTarget() {
        this.target = new Dummy(ZERO_HEALTH, TARGET_XP);
        target.takeAttack(ATTACK_POINTS_LESS_THAN_HEALTH);
    }

    @Test
    public void deadTargetGivesXP() {
        target.takeAttack(ATTACK_POINTS_MORE_THAN_HEALTH);
        Assert.assertEquals("Target doesn't give XP",
                TARGET_XP, target.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveTargetDoesntGiveXP() {
        target.takeAttack(ATTACK_POINTS_LESS_THAN_HEALTH);
        target.giveExperience();
    }
}
