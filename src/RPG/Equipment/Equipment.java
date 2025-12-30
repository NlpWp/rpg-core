package RPG.Equipment;

import RPG.core.Character;
import RPG.item.Item;
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
        if (armor != null) {
            armor.removeFrom(character);
        }
    }

    public boolean isItemEquipped(Item item) { // какой предмет одетеваеться
        if (item == null) {
            return false;
        }
        if (item == weapon) {
            return item == weapon;
        }
        if (item instanceof Armor) {
            Armor armor = (Armor) item;
            ArmorSlot slot = armor.getSlot();
            Armor equipped = armorSlot.get(slot);
            return equipped == item;
        }
        return false;
    }
    public boolean hasArmorInSlot(ArmorSlot slot) { //проверка брони в слоте
        return armorSlot.containsKey(slot);
    }

    public boolean hasWeapon() { //проверка оружия
        return weapon != null;
    }

    public void printEquipped(){
        System.out.println("ОДЕТО: \uD83D\uDEE1\uFE0F");

        for (ArmorSlot slot: ArmorSlot.values()){
            Armor armor = armorSlot.get(slot);
            String name = (armor != null) ? armor.getItemsName() : "--------";
            System.out.println(slot + " - " + name);
        }
        String weaponName = (weapon != null) ? weapon.getItemsName() : "------";
        System.out.println("WEAPON " + weaponName);
    }
}
