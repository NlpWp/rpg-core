package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.Equipment.EquipmentSlot;

public class LeatherBoots extends Armor {

    public LeatherBoots() {
        super("Кожаные ботинки",4,30);
    }


    @Override
    public EquipmentSlot getSlot() {
        return EquipmentSlot.BOOTS;
    }
}
