package RPG.core;

public abstract class Enemy extends Character {

    public Enemy(String name){
        super(name, 3,300);
    }

    @Override
    protected void onDeath() {

    }
}
