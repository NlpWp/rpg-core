package RPG.Equipment;

import RPG.core.Character;
import RPG.item.armor.Armor;
import RPG.item.armor.ArmorSlot;
import RPG.item.weapon.Weapon;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Equipment {
    private final Character character;
    private final Map<ArmorSlot, Armor> armorSlot = new EnumMap<>(ArmorSlot.class);
    private Weapon weapon;

    public Equipment(Character character) {
        this.character = character;
    }

    public void equipWeapon(Weapon newWeapon) {
        if (weapon != null) {
            weapon.removeFrom(character);
        }
        weapon = newWeapon;
        weapon.applyTo(character);
    }

    public void unequipWeapon() {
        if (weapon == null) {
            return;
        }
        weapon.removeFrom(character);
        weapon = null;
    }

    public void equipArmor(Armor armor) { //надеть броню в правильный слот, заменив старую
        ArmorSlot slot = armor.getSlot();
        Armor oldArmor = armorSlot.get(slot);
        if (oldArmor != null) {
            oldArmor.removeFrom(character);
        }
        armorSlot.put(slot, armor);
        armor.applyTo(character);
    }

    public void unequipArmor(ArmorSlot slot) { // снять броню из слота, если она там есть
        Armor armor = armorSlot.remove(slot);
        if(armor != null){
            armor.removeFrom(character);
        }
    }
}
