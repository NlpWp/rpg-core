package RPG.core;

import RPG.Equipment.Equipment;
import RPG.inventory.Inventory;
import RPG.item.Item;
import RPG.item.armor.Armor;
import RPG.item.armor.ArmorSlot;
import RPG.item.weapon.Weapon;

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
        if (item == null) return;
        if (!inventory.contains(item)) return;
        if (item instanceof Armor armor) {
            equipment.equipArmor(armor);
            inventory.remove(item);
        } else if (item instanceof Weapon weapon) {
            equipment.equipWeapon(weapon);
            inventory.remove(item);
        }
    }

    public void unequip(Item item) { // Игрок снимает предмет, но сам Player не должен знать детали слотов
        if (item == null) return; // проверям полученный айтем не равен нулю
        if (!equipment.isItemEquipped(item)) return; // Проверить, что предмет НЕ надет
        if (item instanceof Armor armor) { //
            equipment.unequipArmor(armor.getSlot());
            inventory.addItem(item);
        } else if (item instanceof Weapon) {
            equipment.unequipWeapon();
            inventory.addItem(item);
        }
    }

    public void equipArmor(Armor armor) {
        if (!inventory.contains(armor)) {
            return;
        }
        equipment.equipArmor(armor);
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
        if (index < 1 || index > 5) { // ПРОВЕРКА НА ТО ЧТО У НАС 1 ОРУЖИЕ И 4 ШМОТКИ
            System.out.println("❌НЕВЕРНЫЙ НОМЕР ПРДЕМЕТА ❌");
            return false;
        }
        if (index <= 4) { // ЕСЛИ ПОПОДАЕТ В ДИАПОЗОН ВЕЩЕЙ
            ArmorSlot slot = ArmorSlot.values()[index - 1]; // СМОТРИМ ЧТО ЗА ВЕЩЬ ХРАНИТСЯ В ИНДЕКСЕ
            if (!equipment.hasArmorInSlot(slot)) { // Проверка, что в слоте вообще что-то есть
                System.out.println("⚠️ В этом слоте ничего не надето");
                return false;
            }
            equipment.unequipArmor(slot); // СНИМАЕМ ЭТУ ВЕЩЬ
            System.out.println("✅ Предмет снят: " + slot);
            return true;
        }
        if (index == 5) { // У НАС В 5 СЛОТЕ ЭТО ОРУЖИЕ
            if (!equipment.hasWeapon()) { // одето ли это оружие?
                System.out.println("⚠️ Оружие не надето");
                return false;
            }
            equipment.unequipWeapon(); // СНИМАЕМ ОРУЖИЕ
            System.out.println("✅ ВЫ СНЯЛИ ОРУЖИЕ");
            return true;
        }
        return false;
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