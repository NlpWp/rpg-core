package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.Equipment.EquipmentSlot;

public class LeatherGloves extends Armor {

    public LeatherGloves() {
        super("Кожаные перчатки",4,30);
    }

    @Override
    public EquipmentSlot getSlot() {
        return EquipmentSlot.GLOVES;
    }
}
