package RPG.skills;
import RPG.core.Character;

public abstract class Skill {
    protected String name;
    protected double baseCooldown; // базовый кулдаун скила
    protected double currentCooldown; // измененый кулдаун скила

    public Skill(String name, double baseCooldown) {
        this.name = name;
        this.baseCooldown = baseCooldown;
    }


    public void use(Character caster, Character target) {
        if (accessibilityChecks() == false){
            return;
        }else{
            currentCooldown = baseCooldown;
        }
        System.out.println(caster.getName() + " атакует " + target.getName() + " и наносит " + caster.getDamage() + " урона!");
        System.out.println();
    }

    protected abstract boolean accessibilityChecks(); //метод проверки доступности

    protected void cooldownReduction(double seconds) { // метод уменьшения кулдауна (тик)
        if (currentCooldown > 0) {
            currentCooldown -= seconds;        }
    }
}
