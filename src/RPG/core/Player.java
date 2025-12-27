package RPG.core;

import RPG.Equipment.Equipment;
import RPG.inventory.Inventory;
import RPG.item.Item;
import RPG.item.armor.Armor;
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

    public void equip(Item item) { //Игрок надевает предмет, но сам Player не должен знать детали слотов
        if (item == null) return;
        if (!inventory.contains(item)) return;
        if (item instanceof Armor armor) {
            equipment.equipArmor(armor);
        } else if (item instanceof Weapon weapon) {
            equipment.equipWeapon(weapon);
        }
    }

    public void unequip(Item item) { // Игрок снимает предмет, но сам Player не должен знать детали слотов
        if (item == null) return;
        if(item instanceof Armor armor){
            equipment.unequipArmor(armor.getSlot());
        }else if(item instanceof  Weapon weapon){
            equipment.unequipWeapon();
        }
    }

    public void equipArmor(Armor armor) {
        if (!inventory.contains(armor)) {
            return;
        }
        equipment.equipArmor(armor);
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