
package domain;

import java.util.HashMap;

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
        private HashMap<String, Strength> strength;
        private HashMap<String, Weakness> weakness;
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
    
    public HashMap<String, Strength> getStrength() {
        return strength;
    }

    public HashMap<String, Weakness> getWeakness() {
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

    public void setStrength(HashMap<String, Strength> strength) {
        this.strength = strength;
    }

    public void setWeakness(HashMap<String, Weakness> weakness) {
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
