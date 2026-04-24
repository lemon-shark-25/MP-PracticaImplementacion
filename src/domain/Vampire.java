package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clase que representa a la raza Vampiro dentro del juego.
 * @author Miguel Pradillo Bartolomé
 */
public class Vampire extends Character {

    private int bloodPoints;
    private int age;

    /**
     * Constructor completo del Vampiro.
     * (Será llamado internamente por el VampireBuilder en su método build())
     */
    public Vampire(String name, int health, int power, Discipline discipline, 
                   HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, 
                   Minion minion, LinkedList<Strength> strength, LinkedList<Weakness> weakness, 
                   Equipment principalArmor, Equipment principalWeapon, 
                   int bloodPoints, int age) {
        
        super(name, health, power, discipline, armor, weapon, minion, strength, weakness, principalArmor, principalWeapon);
        this.bloodPoints = bloodPoints;
        this.age = age;
    }

    // --- Getters ---

    public int getBloodPoints() {
        return bloodPoints;
    }

    public int getAge() {
        return age;
    }

    // --- Setter único ---
    
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sobrescribimos el getter de Ability para que devuelva directamente 
     * una Discipline y evitar conversiones manuales en el combate.
     */
    @Override
    public Discipline getAbility() {
        return (Discipline) super.getAbility();
    }
}