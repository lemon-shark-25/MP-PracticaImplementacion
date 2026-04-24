
package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
<<<<<<< HEAD:src/domain/GameCharacter.java
public abstract class GameCharacter {
=======
public abstract class Character {

>>>>>>> bd9ec13bc19f0b9527264748f02b0a8461db13fa:src/domain/Character.java
	private final String name;	
	private final int health;
	private final int power;
        private Ability ability;
        private HashMap<String,Armor> armor;
        private HashMap<String,Weapons> weapon;       
        private Minion minion;
        private LinkedList<Strength> strength;
        private LinkedList<Weakness> weakness;
        private Equipment principalArmor;
        private Equipment principalWeapon;
        //Tal vez hay que crear una segunda variable de weapon si son dos armas de una mano o un array de 2 y comprobar si el pruimero y dependiendo de eso miras el segundo

<<<<<<< HEAD:src/domain/GameCharacter.java
	public GameCharacter(String name, int health, int power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}

=======
    public Character(String name, int health, int power, Ability ability, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, Minion minion, LinkedList<Strength> strength, LinkedList<Weakness> weakness, Equipment principalArmor, Equipment principalWeapon) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.ability = ability;
        this.armor = armor;
        this.weapon = weapon;
        this.minion = minion;
        this.strength = strength;
        this.weakness = weakness;
        this.principalArmor = principalArmor;
        this.principalWeapon = principalWeapon;
    }
        
>>>>>>> bd9ec13bc19f0b9527264748f02b0a8461db13fa:src/domain/Character.java
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
}
