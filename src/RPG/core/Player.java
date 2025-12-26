package RPG.core;

public class Player extends Character {
    private int exp;
    private int lvl = 1;
    private int deadPenalty = 1;


    public Player(String name,int damage,int hp) {
        super(name,damage,hp);

    }


    protected void fineDeath() {
        deadPenalty = Math.max(0, Math.min(deadPenalty, 9));// ограничиваем диапазон от 0 до 9
        double multiplier = 1.0 - (deadPenalty * 0.1); // считаем множитель: 1.0 - (penalty * 10%)

        this.damage = (int) (this.damage * multiplier);
        this.critDamage = this.critDamage * multiplier;
        this.critChance = this.critChance * multiplier;
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
}