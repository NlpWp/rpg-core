//стартанул писать проект 23/12/2025
package RPG.game;

import RPG.Equipment.Equipment;
import RPG.core.Player;
import RPG.enemy.Boss;
import RPG.enemy.Mob;
import RPG.item.armor.*;
import RPG.item.armor.leatherSet.LeatherBoots;
import RPG.item.armor.leatherSet.LeatherChest;
import RPG.item.armor.leatherSet.LeatherGloves;
import RPG.item.armor.leatherSet.LeatherHelmet;
import RPG.item.weapon.IronSword;
import RPG.skills.BasicAttack;
import RPG.skills.Skill;

public class Game {
    public static void main(String[] args){
        Player voin = new Player("vovasik", 5,300);

        Equipment equipment = new Equipment(voin);


        System.out.println("НАЧАЛО ПРОВЕРКИ ОРУЖИЯ \uD83D\uDDE1\uFE0F  ");
        System.out.println("\uD83D\uDDE1\uFE0F \uD83D\uDDE1\uFE0F \uD83D\uDDE1\uFE0F \uD83D\uDDE1\uFE0F ");
        equipment.equipWeapon(new IronSword());
        System.out.println(voin);
        equipment.unequipWeapon();
        System.out.println(voin);
        equipment.equipWeapon(new IronSword());
        System.out.println(voin);
        equipment.unequipWeapon();
        System.out.println(voin);
        System.out.println("☝✍\uFE0F✍\uFE0F✍\uFE0F✍\uFE0F✍\uFE0F✍\uFE0F");
        System.out.println("ПРОВЕРКА ОРУЖИЯ ЗАКОНЧИНА" + "\n");

        System.out.println("НАЧАЛО ПРОВЕРКИ ШМОТА");
        System.out.println("ШЛЕМ \uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96 ");
        equipment.equipArmor(new LeatherHelmet());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.HELMET);
        System.out.println(voin);
        equipment.equipArmor(new LeatherHelmet());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.HELMET);
        System.out.println(voin);
        System.out.println("\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96\uD83E\uDE96");
        System.out.println();

        System.out.println("ТУШКА\uD83E\uDDE5 ");
        equipment.equipArmor(new LeatherChest());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.CHEST);
        System.out.println(voin);
        equipment.equipArmor(new LeatherChest());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.CHEST);
        System.out.println(voin);
        System.out.println("\uD83E\uDDE5 \uD83E\uDDE5 \uD83E\uDDE5 \uD83E\uDDE5 \uD83E\uDDE5 \uD83E\uDDE5 ");
        System.out.println();

        System.out.println("ПЕРЧАТКИ \uD83E\uDDE4");
        equipment.equipArmor(new LeatherGloves());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.GLOVES);
        System.out.println(voin);
        equipment.equipArmor(new LeatherGloves());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.GLOVES);
        System.out.println(voin);
        System.out.println("\uD83E\uDDE4\uD83E\uDDE4\uD83E\uDDE4\uD83E\uDDE4\uD83E\uDDE4\uD83E\uDDE4\uD83E\uDDE4");
        System.out.println();

        System.out.println("БОТИНКИ \uD83D\uDC62\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62");
        equipment.equipArmor(new LeatherBoots());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.BOOTS);
        System.out.println(voin);
        equipment.equipArmor(new LeatherBoots());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.BOOTS);
        System.out.println(voin);
        System.out.println("\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62\uD83D\uDC62");
        System.out.println();

        System.out.println("ПРОВЕРКА ДАБЛ ОДЕВАНИЯ");
        equipment.equipArmor(new LeatherChest());
        System.out.println(voin);
        equipment.equipArmor(new LeatherChest());
        System.out.println(voin);
        equipment.equipArmor(new LeatherHelmet());
        System.out.println(voin);
        equipment.equipArmor(new LeatherHelmet());
        System.out.println(voin);
        equipment.equipArmor(new LeatherBoots());
        System.out.println(voin);
        equipment.equipArmor(new LeatherBoots());
        System.out.println(voin);
        equipment.equipArmor(new LeatherGloves());
        System.out.println(voin);
        equipment.equipArmor(new LeatherGloves());
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.CHEST);
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.HELMET);
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.BOOTS);
        System.out.println(voin);
        equipment.unequipArmor(ArmorSlot.GLOVES);
        System.out.println(voin);
        System.out.println("ТЕСТ ДАБЛ ОДЕВАНИЯ END" + "\n");
        System.out.println("ОДЕВАЕМ ВЕСЬ ШМОТ \uD83D\uDEE1\uFE0F ");
        equipment.equipWeapon(new IronSword());
        equipment.equipArmor(new LeatherBoots());
        equipment.equipArmor(new LeatherHelmet());
        equipment.equipArmor(new LeatherGloves());
        equipment.equipArmor(new LeatherChest());
        System.out.println(voin);
        System.out.println("ВЕСЬ ШМОТ ОДЕТ СТАТЫ КОРЕКТНЫЕ");

        System.out.println("НАЧАЛО ПРОВЕРКИ ДОБАВЛЕНИЕ ЕНЕМИ");
        Boss boss = new Boss("Попуск-младший");
        Mob mob = new Mob("Моб - попуск");
        System.out.println(boss);
        System.out.println(mob);
        System.out.println("ПРОВЕРКА СОЗДАНИЯ БОССА ЗАВЕРШЕНА И МОБА" + "\n");

        System.out.println("ПРОВЕРКА СОЗДАНИЕ СКИЛА");
        Skill basicAttack = new BasicAttack();
        System.out.println("HP босса на данный момент: " + boss.getHp());
        basicAttack.use(voin,boss);
        System.out.println("HP босса после удара: " + boss.getHp());
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ОБЩАЯ ПРОВЕРКА ЗАКОНЧИЛАСЬ" + "\n");
    }
}
