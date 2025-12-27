package RPG.inventory;

import RPG.item.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }


    public void addItem(Item item){ //добавить итем если он пустой
        if(item == null){
            return;
        }
        items.add(item);
    }

    public void removeItem(Item item){ //удалить итем если не пустой
        if(item == null){
            return;
        }
        items.remove(item);
    }

    public boolean contains(Item item){
        return items.contains(item);
    }

    public List<Item> getItems() {
        return items;
    }

}
