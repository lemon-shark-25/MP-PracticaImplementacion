
package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public abstract class Character {

	private final String name;	
	private final int health;
	private final int power;
        private HashMap<String,Ability> ability;
        private HashMap<String,Equipment> equipment;
        private Minion minion;
        private LinkedList<Modifier> modifier;
        private Equipment principalEquipment;
        
        

    public Character(String name, int health, int power, HashMap<String, Ability> ability, HashMap<String, Equipment> equipment, Minion minion, LinkedList<Modifier> modifier, Equipment principalEquipment) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.ability = ability;
        this.equipment = equipment;
        this.minion = minion;
        this.modifier = modifier;
        this.principalEquipment = principalEquipment;
    }        



	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getPower() {
		return power;
	}



}
