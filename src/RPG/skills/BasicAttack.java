package RPG.skills;
import RPG.core.Character;

public class BasicAttack extends Skill {


    public BasicAttack() {
        super("Basic Attack", 1.5);
    }

    public void use(Character caster, Character target) {
        super.use(caster, target);
        if(currentCooldown > 0){
            int damage = (int) caster.getDamage();
            target.receiveDamage(damage);
        }
    }

    @Override
    protected boolean accessibilityChecks() {
        return currentCooldown == 0;
    }
}
