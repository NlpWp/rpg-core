package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.Equipment.EquipmentSlot;

public class LeatherChest extends Armor {

    public LeatherChest() {
        super("Кожаная накидка", 13, 130);
    }

    @Override
    public EquipmentSlot getSlot() {
        return EquipmentSlot.CHEST;
    }
}
