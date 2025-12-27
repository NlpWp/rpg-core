package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.item.armor.ArmorSlot;

public class LeatherChest extends Armor {

    public LeatherChest() {
        super("Кожаная накидка", 13, 130);
    }

    @Override
    public ArmorSlot getSlot() {
        return ArmorSlot.CHEST;
    }
}
