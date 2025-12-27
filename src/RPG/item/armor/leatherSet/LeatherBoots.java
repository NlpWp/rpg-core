package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.item.armor.ArmorSlot;

public class LeatherBoots extends Armor {

    public LeatherBoots() {
        super("Кожаные ботинки",4,30);
    }


    @Override
    public ArmorSlot getSlot() {
        return ArmorSlot.BOOTS;
    }
}
