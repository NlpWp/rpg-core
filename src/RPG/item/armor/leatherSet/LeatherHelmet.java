package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.item.armor.ArmorSlot;

public class LeatherHelmet extends Armor {

    public LeatherHelmet() {
        super("Кожаный шлем",7,40);
    }

    @Override
    public ArmorSlot getSlot() {
        return ArmorSlot.HELMET;
    }
}
