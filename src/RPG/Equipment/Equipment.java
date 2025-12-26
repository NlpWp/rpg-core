package RPG.Equipment;

import RPG.core.Character;
import RPG.item.armor.Armor;
import RPG.item.weapon.Weapon;

public class Equipment {
    private Character character;
    private Weapon weapon;
    private Armor helmet;
    private Armor chest;
	private Armor gloves;
	private Armor boots;

    public Equipment(Character character) {
        this.character = character;
    }

    public void equipWeapon(Weapon newWeapon){
        if(weapon != null){
            weapon.removeFrom(character);
        }
            weapon = newWeapon;
            weapon.applyTo(character);
    }
	public void unequipWeapon(){
        if(weapon == null){
            return;
        }
        weapon.removeFrom(character);
        weapon = null;
    }
    public void equipHelmet(Armor newHelmet){
        if(helmet != null){
            helmet.removeFrom(character);
        }
            helmet = newHelmet;
            helmet.applyTo(character);
    }
    public void equipChest(Armor newChest){
        if(chest != null){
            chest.removeFrom(character);
        }
        chest = newChest;
        chest.applyTo(character);
    }
    public void equipGloves(Armor newGloves){
        if(gloves != null){
            gloves.removeFrom(character);
        }
        gloves = newGloves;
        gloves.applyTo(character);
    }
    public void equipBoots(Armor newBoots){
        if(boots != null){
            boots.removeFrom(character);
        }
        boots = newBoots;
        boots.applyTo(character);
    }

    public void unequipChest(){
        if(chest == null){
            return;
        }
        chest.removeFrom(character);
        chest = null;
    }
    public void unequipHelmet(){
        if(helmet == null){
            return;
        }
        helmet.removeFrom(character);
        helmet = null;
    }
    public void unequipGloves(){
        if(gloves == null){
            return;
        }
        gloves.removeFrom(character);
        gloves = null;
    }
    public void unequipBoots(){
        if(boots == null){
            return;
        }
        boots.removeFrom(character);
        boots = null;
    }
}
