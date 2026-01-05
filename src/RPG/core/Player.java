package RPG.core;

import RPG.Equipment.Equipment;
import RPG.Equipment.EquipmentSlot;
import RPG.inventory.Inventory;
import RPG.item.Equipable;
import RPG.item.Item;

public class Player extends Character {
    private int exp;
    private int lvl = 1;
    private int deadPenalty = 1;
    private final Inventory inventory;
    private final Equipment equipment;


    public Player(String name, int damage, int hp) {
        super(name, damage, hp);
        inventory = new Inventory();
        equipment = new Equipment(this);
    }


    protected void fineDeath() {
        deadPenalty = Math.max(0, Math.min(deadPenalty, 9));// ограничиваем диапазон от 0 до 9
        double multiplier = 1.0 - (deadPenalty * 0.1); // считаем множитель: 1.0 - (penalty * 10%)

        this.damage = (int) (this.damage * multiplier);
        this.critDamage = this.critDamage * multiplier;
        this.critChance = this.critChance * multiplier;
    }

    public void pickUp(Item item) { //поднять
        if (item == null) {
            return;
        }
        inventory.addItem(item);
    }

    public boolean drop(Item item) { // выбросить
        if (item == null) {
            return false;
        }
        if (equipment.isItemEquipped(item)) {
            return false;
        }
        return inventory.remove(item);
    }

    public void equip(Item item) { //Игрок надевает предмет, но сам Player не должен знать детали слотов
        if (item == null) return; // проверка на нуль
        if (!(item instanceof Equipable))return; // Если item НЕ Equipable
        if (!inventory.contains(item)) return; //Если предмета нет в инвентаре
        equipment.equip( (Equipable) item); // Передать предмет в Equipment
        inventory.remove(item); // удалить предмет из инвентаря
    }

    public void unequip(Item item) { // Игрок снимает предмет, но сам Player не должен знать детали слотов
        if (item == null) return; // проверям полученный айтем не равен нулю
        if (!(item instanceof Equipable))return; // Проверка, что предмет экипируемый
        if (!equipment.isItemEquipped(item)) return; // Проверка, что предмет реально надет

            equipment.unequip(((Equipable) item).getSlot()); // Снятие предмета
            inventory.addItem(item); // Возврат предмета в инвентарь
    }

    public void equipByIndex(int index) { //одеваем по индексу
        Item item = inventory.getItemByIndex(index); // берем из инвентаря по индексу
        if (item == null) {
            System.out.println("❌НЕВЕРНЫЙ НОМЕР ПРДЕМЕТА ❌");
            return;
        }
        equip(item); // одеваем айтем по индексу
    }

    public boolean dropByIndex(int index) { // выбросить по индексу
        Item item = inventory.getItemByIndex(index); //берем из инветаря по индексу
        if (item == null) { // проверка на нуль
            System.out.println("❌НЕВЕРНЫЙ НОМЕР ПРДЕМЕТА ❌");
            return false;
        }
        if (equipment.isItemEquipped(item)) { // проверяем одет ли предмет который мы хотим выкинуть
            System.out.println("❌ сначала сними предмет ❌");
            return false;
        }
        if (inventory.remove(item)) { // удаляем предмет если условия соблюдены
            System.out.println("✅ выброшено: " + item.getItemsName());
            return true;
        } else { //ошибка удаления предмета
            System.out.println("⚠\uFE0F не получилось выбросить ⚠\uFE0F");
            return false;
        }
    }

    public boolean unequipByIndex(int index) { // снимаем предмет по индексу
        if(index < 1 || index > EquipmentSlot.values().length){ //Проверка индекса чтобы не вышел за рамки
            System.out.println("⚠️НЕРПАВИЛЬНЫЙ ИНДЕКС⚠️");
            return false;
        }
        EquipmentSlot slot = EquipmentSlot.values()[index - 1]; // Получаем слот по индексу
        if(!equipment.hasItemInSlot(slot)){ //Проверяем, есть ли предмет в этом слоте
            System.out.println("⚠️ В этом слоте ничего не надето");
            return false;
        }
        Item item = equipment.getItemInSlot(slot); //Забираем предмет из слота
        equipment.unequip(slot); // Снимаем предмет
        inventory.addItem(item); // Кладём предмет в инвентарь
        return true;
    }

    @Override
    protected void onDeath() {
        this.deadPenalty++;
        this.hp = 200;
        fineDeath();
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " | HP: " + hp +
                " | Damage: " + damage +
                " | Defense: " + defense;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}