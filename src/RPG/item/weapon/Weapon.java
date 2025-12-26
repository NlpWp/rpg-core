package RPG.item.weapon;

import RPG.core.Character;
import RPG.item.Item;

public class Weapon extends Item {
    protected int damageBonus;

    public Weapon(String itemsName,int damageBonus) {
        super(itemsName);
        this.damageBonus = damageBonus;
    }

    @Override
    public void applyTo(Character character) {
        character.increaseDamage(damageBonus);
    }

    @Override
    public void removeFrom(Character character) {
        character.decreaseDamage(damageBonus);
    }

    public int getDamageBonus() {
        return damageBonus;
    }
}
