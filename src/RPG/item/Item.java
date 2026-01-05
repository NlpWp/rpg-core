package RPG.item;

import RPG.core.Character;

public abstract class Item { // данные
    protected String itemsName;

    public Item(String itemsName) {
        this.itemsName = itemsName;

    }

    public String getItemsName() {
        return itemsName;
    }

}
