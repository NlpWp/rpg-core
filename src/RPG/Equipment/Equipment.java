package RPG.Equipment;

import RPG.core.Character;
import RPG.item.Equipable;
import RPG.item.Item;
import RPG.item.armor.Armor;
import RPG.item.weapon.Weapon;

import java.util.EnumMap;
import java.util.Map;

public class Equipment { //применяет
    private final Character character;
    private final Map<EquipmentSlot, Equipable> itemSlot = new EnumMap<>(EquipmentSlot.class);

    public Equipment(Character character) {
        this.character = character;
    }

    public void equip(Equipable item) { // надеть слот заменив старый
        if (item == null) {
            return;
        }
        EquipmentSlot slot = item.getSlot();
        Equipable oldItem = itemSlot.get(slot);
        if (oldItem == item) {
            return;
        }
        if (oldItem != null) {
            oldItem.removeFrom(character);
        }
        itemSlot.put(slot, item);
        item.applyTo(character);

    }

    public void unequip(EquipmentSlot slot) { //снять прдемет
        Equipable oldItem = itemSlot.remove(slot);
        if (oldItem != null) {
            oldItem.removeFrom(character);
        }
    }

    public boolean isItemEquipped(Item item) { // какой предмет сейчас одет?
        if (item == null) {
            return false;
        }
        if (!(item instanceof Equipable equipable)) {
            return false;
        }

        EquipmentSlot slot = equipable.getSlot();
        return itemSlot.get(slot) == equipable;
    }

    public boolean hasItemInSlot(EquipmentSlot slot) {
        if (slot == null) {
            return false;
        }
        if (itemSlot.containsKey(slot)) {
            return true;
        }
        return false;
    }

    public Item getItemInSlot(EquipmentSlot slot) {
        if (slot == null){
            return null;
        }
        if(itemSlot.get(slot) == null){
            return null;
        }
        Item item = (Item) itemSlot.get(slot);
        return item;
    }

    public void printEquipped() { // вывод
        System.out.println("ОДЕТО: 🛡️");

        EquipmentSlot[] slots = EquipmentSlot.values();

        for (int i = 0; i < slots.length; i++) {
            EquipmentSlot slot = slots[i];
            Equipable equipable = itemSlot.get(slot);

            String name;
            if (equipable != null) {
                Item item = (Item) equipable;
                name = item.getItemsName();
            } else {
                name = "--------";
            }

            System.out.println((i + 1) + ") " + slot + " - " + name);
        }
    }
}
