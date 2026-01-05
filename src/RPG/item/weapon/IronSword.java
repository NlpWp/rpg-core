package RPG.item.weapon;

import RPG.Equipment.EquipmentSlot;

public class IronSword extends Weapon {

    public IronSword() {
        super("Iron Sword",10);
    }
    @Override
    public EquipmentSlot getSlot() {
        return EquipmentSlot.WEAPON_MAIN;
    }
}
