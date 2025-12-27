package RPG.item.armor.leatherSet;

import RPG.item.armor.Armor;
import RPG.item.armor.ArmorSlot;

public class LeatherGloves extends Armor {

    public LeatherGloves() {
        super("Кожаные перчатки",4,30);
    }

    @Override
    public ArmorSlot getSlot() {
        return ArmorSlot.GLOVES;
    }
}
