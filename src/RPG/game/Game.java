//стартанул писать проект 23/12/2025
package RPG.game;

import RPG.Equipment.Equipment;
import RPG.core.Character;
import RPG.core.Enemy;
import RPG.core.Player;
import RPG.enemy.Boss;
import RPG.item.armor.*;
import RPG.item.weapon.IronSword;
import RPG.skills.BasicAttack;
import RPG.skills.Skill;

public class Game {
    public static void main(String[] args){
        Player voin = new Player("vovasik", 5,300);

        Equipment equipment = new Equipment(voin);
        IronSword ironSword = new IronSword();
        System.out.println("ПРОВЕРКА ОДИВАНИЯ ОРУЖИЯ ");
        System.out.println("⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F");
        System.out.println(voin);
        equipment.equipWeapon(ironSword);
        System.out.println(voin);
        equipment.unequipWeapon();
        System.out.println(voin);
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ПРОВЕРКА ОРУЖИЯ ЗАКОНЧИНА" + "\n");

        System.out.println("НАЧАЛО ПРОВЕРКИ ШЛЕМА");
        System.out.println("⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F");
        Armor helmer = new LeatherHelmet();
        equipment.equipHelmet(helmer);
        System.out.println(voin);
        equipment.unequipHelmet();
        System.out.println(voin);
        equipment.equipHelmet(helmer);
        System.out.println(voin);
        equipment.unequipHelmet();
        System.out.println(voin);
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ПРОВЕРКА ЩЛЕМА ЗАКОНЧИНА" + "\n");

        System.out.println("НАЧАЛО ПРОВЕРКИ БОТИНОК");
        System.out.println("⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F");
        Armor boots = new LeatherBoots();
        equipment.equipBoots(boots);
        System.out.println(voin);
        equipment.unequipBoots();
        System.out.println(voin);
        equipment.equipBoots(boots);
        System.out.println(voin);
        equipment.unequipBoots();
        System.out.println(voin);
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ПРОВЕРКА БОТИНОК ЗАКОНЧИНА" + "\n");

        System.out.println("НАЧАЛО ПРОВЕРКИ ПЕРЧАТОК");
        System.out.println("⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F");
        Armor gloves = new LeatherGloves();
        equipment.equipGloves(gloves);
        System.out.println(voin);
        equipment.unequipGloves();
        System.out.println(voin);
        equipment.equipGloves(gloves);
        System.out.println(voin);
        equipment.unequipGloves();
        System.out.println(voin);
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ПРОВЕРКА ПЕРЧАТОК ЗАКОНЧИНА" + "\n");

        System.out.println("НАЧАЛО ПРОВЕРКИ ГРУДИ-брони");
        System.out.println("⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F");
        Armor chest = new LeatherChest();
        equipment.equipChest(chest);
        System.out.println(voin);
        equipment.unequipChest();
        System.out.println(voin);
        equipment.equipChest(chest);
        System.out.println(voin);
        equipment.unequipChest();
        System.out.println(voin);
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ПРОВЕРКА ГРУДИ-брони ЗАКОНЧИНА" + "\n");

        System.out.println("НАЧАЛО ПРОВЕРКИ ДОБАВЛЕНИЕ ВСЕХ ЭЛЕМЕНТОВ БРОНИ");
        System.out.println("⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F⬇\uFE0F");
        equipment.equipWeapon(ironSword);
        System.out.println(voin);
        equipment.equipHelmet(helmer);
        System.out.println(voin);
        equipment.equipBoots(boots);
        System.out.println(voin);
        equipment.equipGloves(gloves);
        System.out.println(voin);
        equipment.equipChest(chest);
        System.out.println(voin);
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ОБЩАЯ ПРОВЕРКА ПРЕДМЕТОВ ПРОШЛА РЕЗУЛЬТАТ ДОЛЖЕН СУМИРОВАТЬСЯ" + "\n");

        System.out.println("НАЧАЛО ПРОВЕРКИ ДОБАВЛЕНИЕ ЕНЕМИ");
        Boss boss = new Boss("Попуск-младший");
        System.out.println(boss);
        System.out.println("ПРОВЕРКА СОЗДАНИЯ БОССА ЗАВЕРШЕНА" + "\n");

        System.out.println("ПРОВЕРКА СОЗДАНИЕ СКИЛА");
        Skill basicAttack = new BasicAttack();
        System.out.println("HP босса на данный момент: " + boss.getHp());
        basicAttack.use(voin,boss);
        System.out.println("HP босса после удара: " + boss.getHp());
        System.out.println("☝️☝️☝️☝️☝️☝️");
        System.out.println("ОБЩАЯ ПРОВЕРКА ЗАКОНЧИЛАСЬ" + "\n");

    }
}
