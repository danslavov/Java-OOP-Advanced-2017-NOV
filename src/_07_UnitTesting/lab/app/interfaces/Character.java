package interfaces;

public interface Character {
    String getName();
    int getExperience();
    Weapon getWeapon();
    void attack(Target target);
}
