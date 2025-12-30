package RPG.inventory;

import RPG.item.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }


    public void addItem(Item item){ //добавить итем если он пустой
        if(item == null){
            return;
        }
        items.add(item);
    }

    public boolean remove(Item item){ // возращает получилось ли удалить
        if(item == null){
            return false;
        }
        return items.remove(item);
    }

    public boolean contains(Item item){
        if(item == null){
            return false;
        }
        return items.contains(item);
    }

    public Item getItemByIndex(int index){
        if (index < 1 || index > items.size()) return null;
        return items.get(index -1);

    }

    public void print(){ // просто вывод инвентаря
        if(items.isEmpty()){
            System.out.println("ИНВЕНТАРЬ ПУСТОЙ");
            return;
        }
        int index = 1;
        for(Item i : items){
            System.out.println(index++ + ") " + i.getItemsName());
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

}
