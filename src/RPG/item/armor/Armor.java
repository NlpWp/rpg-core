package RPG.item.armor;

import RPG.core.Character;
import RPG.item.Item;

public class Armor extends Item {
    protected int defenseBonus;
    protected int hpBonus;

    public Armor(String itemsName,int defenseBonus,int hpBonus) {
        super(itemsName);
        this.defenseBonus = defenseBonus;
        this.hpBonus = hpBonus;
    }

    @Override
    public void applyTo(Character character) {
	character.increaseDefense(defenseBonus);
	character.increaseHp(hpBonus);
    }

    @Override
    public void removeFrom(Character character) {
    character.decreaseDefense(defenseBonus);
	character.decreaseHp(hpBonus);
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public int getHpBonus() {
        return hpBonus;
    }
}
