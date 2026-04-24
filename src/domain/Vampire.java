package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clase que representa a la raza Vampiro dentro del juego.
 * * @author Miguel Pradillo Bartolomé
 */
public class Vampire extends Character {

    // Atributos específicos del Vampiro según el enunciado
    private int bloodPoints;
    private int age;

    /**
     * Constructor completo del Vampiro.
     * Pedimos explícitamente un objeto 'Discipline' en lugar de un 'Ability' genérico.
     */
    public Vampire(String name, int health, int power, Discipline discipline, 
                   HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, 
                   Minion minion, LinkedList<Strength> strength, LinkedList<Weakness> weakness, 
                   Equipment principalArmor, Equipment principalWeapon, 
                   int bloodPoints, int age) {
        
        // Invocamos al constructor de la clase padre (Character)
        // Pasamos 'discipline' al parámetro 'ability' del padre
        super(name, health, power, discipline, armor, weapon, minion, strength, weakness, principalArmor, principalWeapon);
        
        this.bloodPoints = bloodPoints;
        this.age = age;
    }

    // --- Getters y Setters específicos ---

    public int getBloodPoints() {
        return bloodPoints;
    }

    public void setBloodPoints(int bloodPoints) {
        this.bloodPoints = bloodPoints;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sobrescribimos el getter de Ability para que devuelva directamente 
     * una Discipline y no haya que hacer casteos manuales en el combate.
     */
    @Override
    public Discipline getAbility() {
        return (Discipline) super.getAbility();
    }
}