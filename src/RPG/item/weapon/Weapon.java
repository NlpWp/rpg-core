package RPG.item.weapon;

import RPG.Equipment.Equipment;
import RPG.Equipment.EquipmentSlot;
import RPG.core.Character;
import RPG.item.Equipable;
import RPG.item.Item;

public abstract class Weapon extends Item implements Equipable {
    protected int damageBonus;

    public Weapon(String itemsName,int damageBonus) {
        super(itemsName);
        this.damageBonus = damageBonus;
    }
    public abstract EquipmentSlot getSlot();

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
