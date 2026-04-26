
package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Hugo Martínez González
 */
public class VampireCreator implements GameCharacterCreator{

   
    private final String name;	
    private final int health;
    private final int power;
    private Discipline discipline;
    private HashMap<String,Armor> armor;
    private HashMap<String,Weapons> weapon;       
    private Minion minion;
    private LinkedList<Strength> strength;
    private LinkedList<Weakness> weakness;
    private Equipment principalArmor;
    private Equipment principalWeapon;
    private int bloodPoints;
    private int age;

    public VampireCreator(String name, int health, int power, Discipline discipline, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, Minion minion, LinkedList<Strength> strength, LinkedList<Weakness> weakness, Equipment principalArmor, Equipment principalWeapon, int bloodPoints, int age) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.discipline = discipline;
        this.armor = armor;
        this.weapon = weapon;
        this.minion = minion;
        this.strength = strength;
        this.weakness = weakness;
        this.principalArmor = principalArmor;
        this.principalWeapon = principalWeapon;
        this.bloodPoints = bloodPoints;
        this.age = age;
    }
        
    @Override
    public Vampire create() {
        return (Vampire) new Vampire(name, health, power, discipline, armor, weapon, minion, strength, weakness, principalArmor, principalWeapon, bloodPoints, age);
    }
    
}
