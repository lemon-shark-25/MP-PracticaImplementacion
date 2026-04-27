
package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public abstract class GameCharacter {

	private String name;	
	private int health;
	private int power;
        private Ability ability;
        private HashMap<String,Armor> armor;
        private HashMap<String,Weapons> weapon;       
        private Minion minion;
        private LinkedList<Strength> strength;
        private LinkedList<Weakness> weakness;
        private Equipment principalArmor;
        private Equipment principalWeapon;
        //Tal vez hay que crear una segunda variable de weapon si son dos armas de una mano o un array de 2 y comprobar si el pruimero y dependiendo de eso miras el segundo

        public GameCharacter() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHealth(int health) {
            this.health = health;
        }
        
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health + minion.getHealth();
	}

	public int getPower() {
		return power;
	}

    public Ability getAbility() {
        return ability;
    }

    public Equipment getPrincipalArmor() {
        return principalArmor;
    }

    public Equipment getPrincipalWeapon() {
        return principalWeapon;
    }
    
    public LinkedList<Strength> getStrength() {
        return strength;
    }

    public LinkedList<Weakness> getWeakness() {
        return weakness;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public void setArmor(HashMap<String, Armor> armor) {
        this.armor = armor;
    }

    public void setWeapon(HashMap<String, Weapons> weapon) {
        this.weapon = weapon;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }

    public void setStrength(LinkedList<Strength> strength) {
        this.strength = strength;
    }

    public void setWeakness(LinkedList<Weakness> weakness) {
        this.weakness = weakness;
    }

    public void setPrincipalArmor(Equipment principalArmor) {
        this.principalArmor = principalArmor;
    }

    public void setPrincipalWeapon(Equipment principalWeapon) {
        this.principalWeapon = principalWeapon;
    }
    
    public void setPower(int power){
        this.power = power;
    }
    
}
