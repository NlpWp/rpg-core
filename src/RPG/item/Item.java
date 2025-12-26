package RPG.item;

import RPG.core.Character;

public abstract class Item {
    protected String itemsName;

    public Item(String itemsName) {
        this.itemsName = itemsName;

    }

    public abstract void applyTo(Character character); // персонаж одевает броню
    public abstract void removeFrom(Character character); // персонаж снимает броню


    public String getItemsName() {
        return itemsName;
    }

   /* @Override
    public String toString(){
        return "Item: " + getItemsName() + "\n" + "Damage: " + getDamageBonus() + "\n"
                + "Defense: " + getDefenseBonus() + "\n" + "HP: " + getHpBonus();
    }

    */
}
