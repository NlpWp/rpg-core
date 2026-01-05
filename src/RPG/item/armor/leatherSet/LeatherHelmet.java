package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.Equipment.EquipmentSlot;

public class LeatherHelmet extends Armor {

    public LeatherHelmet() {
        super("Кожаный шлем",7,40);
    }

    @Override
    public EquipmentSlot getSlot() {
        return EquipmentSlot.HELMET;
    }
}
