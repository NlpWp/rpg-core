//стартанул писать проект 23/12/2025
package RPG.game;

import RPG.Equipment.Equipment;
import RPG.Equipment.EquipmentSlot;
import RPG.core.Player;
import RPG.enemy.Boss;
import RPG.enemy.Mob;
import RPG.item.armor.leatherSet.LeatherBoots;
import RPG.item.armor.leatherSet.LeatherChest;
import RPG.item.armor.leatherSet.LeatherGloves;
import RPG.item.armor.leatherSet.LeatherHelmet;
import RPG.item.weapon.IronSword;
import RPG.skills.BasicAttack;
import RPG.skills.Skill;

public class Game {
    public static void main(String[] args){
        Player voin = new Player("vovasik", 5, 300);

        voin.pickUp(new IronSword());
        voin.pickUp(new LeatherBoots());
        voin.pickUp(new LeatherHelmet());

        System.out.println("ИНВЕНТАРЬ:");
        voin.getInventory().print();

        System.out.println("\nОДЕВАЕМ 1:");
        voin.equipByIndex(1);

        voin.getEquipment().printEquipped();
        voin.getInventory().print();

        System.out.println("\nОДЕВАЕМ 2:");
        voin.equipByIndex(2);

        voin.getEquipment().printEquipped();
        voin.getInventory().print();

    }
}
