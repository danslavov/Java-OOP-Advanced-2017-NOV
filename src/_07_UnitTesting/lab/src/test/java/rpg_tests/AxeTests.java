package rpg_tests;

import implementations.Axe;
import implementations.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static rpg_tests.TestValues.*;

public class AxeTests {

    private Axe weapon;
    private Dummy target;

    @Before
    public void initializeTestObjects() {
        this.weapon = new Axe(WEAPON_ATTACK, WEAPON_DURABILITY);
        this.target = new Dummy(TARGET_HEALTH, TARGET_XP);
    }

    @Test
    public void weaponAttackLosesDurability() {
        this.weapon.attack(this.target);
        Assert.assertEquals("Weapon doesn't lose durability when attacks.",
                        EXPECTED_DURABILITY, this.weapon.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        this.weapon = new Axe(WEAPON_ATTACK, ZERO_DURABILITY);
        this.weapon.attack(this.target);
    }
}
