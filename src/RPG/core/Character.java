package RPG.core;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int mana;
    protected int defense;
    protected int evasion;
    protected int damage;
    protected double critChance;
    protected double critDamage;
    protected boolean alive = true;


    public Character(String name, int damage, int hp) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
    }

    public void receiveDamage(int incomingDamage) { // Получение входящего урона (РЕЗУЛЬТАТА)
        hp -= incomingDamage;
        if (hp <= 0) {
            hp = 0;
            die();
        }
    }

    public boolean isAlive() {  // Проверка состояния
        return alive;
    }

    protected void die() { // Базовая смерть (одинакова для всех)
        alive = false;
        onDeath();
    }

    protected abstract void onDeath(); // Точка расширения: последствия смерти

    public void increaseDamage(int value) { //Добавляем урон из айтема
        setDamage(getDamage() + value);
    }

    public void decreaseDamage(int value) { // удаление урон из айтема
        if (value <= 0) {
            return;
        }
        int newDamage = damage - value;
        setDamage(newDamage < 0 ? 0 : newDamage);
    }

    public void increaseDefense(int value) { //добавление статов армора из айтема
        setDefense(getDefense() + value);
    }

    public void decreaseDefense(int value) { // удаление брони из айтема
        if (value <= 0) {
            return;
        }
        int newDefense = defense - value;
        setDefense(newDefense < 0 ? 0 : newDefense);
    }

    public void increaseHp(int value) { // добавление ХП из айтема
        setHp(getHp() + value);
    }

    public void decreaseHp(int value) { // удаление ХП из айтема
        if (value <= 0) {
            return;
        }
        int newHp = hp - value;
        setHp(newHp < 0 ? 0 : newHp);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public double getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                " | hp=" + hp +
                " | mana=" + mana +
                " | defense=" + defense +
                " | evasion=" + evasion +
                " | damage=" + damage +
                " | critChance=" + critChance +
                " | critDamage=" + critDamage +
                " | alive=" + alive +
                '}';
    }
}
