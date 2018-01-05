package rpg_tests;

import implementations.Hero;
import interfaces.Character;
import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Test;

import static rpg_tests.TestValues.*;

public class HeroTests {

    private Weapon fakeWeapon = new Weapon() {
        public int getAttackPoints() {
            return WEAPON_ATTACK;
        }

        public int getDurabilityPoints() {
            return WEAPON_DURABILITY;
        }

        public void attack(Target target) {
        }
    };

    private Target fakeTarget = new Target() {
        public int getHealth() {
            return TARGET_HEALTH;
        }

        public void takeAttack(int attackPoints) {
        }

        public int giveExperience() {
            return TARGET_XP;
        }

        public boolean isDead() {
            return true;
        }
    };

//    // Mockito integration problems :(
//    private Weapon mockedWeapon = Mockito.mock(Weapon.class);
//    private Target mockedTarget = Mockito.mock(Target.class);
//    Mockito.when(mockedTarget.isDead()).thenReturn(true);
//    Mockito.when(mockedTarget.giveExperience()).thenReturn(TARGET_XP);

    @Test
    public void heroGainsXPWhenKillsTarget() {
        Character hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Hero doesn't gain correct experience.",
                hero.getExperience(), fakeTarget.giveExperience());
    }

//    @Test
//    public void heroGainsXPWhenKillsMockedTarget() {
//        Character hero = new Hero(HERO_NAME, mockedWeapon);
//        hero.attack(mockedTarget);
//        Assert.assertEquals("Hero doesn't gain correct experience.",
//                hero.getExperience(), mockedTarget.giveExperience());
//    }
}
