/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.HashMap;

/**
 *
 * @author Hugo Martínez González
 */
public class Catalog {
        private HashMap<String,Discipline> discipline;
        private HashMap<String,Gift> gift;
        private HashMap<String,Will> will;
        private HashMap<String,Armor> armor; 
        private HashMap<String,Weapons> weapon; 
        private HashMap<String,Strength> strength; 
        private HashMap<String,Weakness> weakness; 

    public Catalog(HashMap<String, Discipline> discipline, HashMap<String, Gift> gift, HashMap<String, Will> will, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, HashMap<String, Strength> strength, HashMap<String, Weakness> weakness) {
        this.discipline = discipline;
        this.gift = gift;
        this.will = will;
        this.armor = armor;
        this.weapon = weapon;
        this.strength = strength;
        this.weakness = weakness;
    }

    public HashMap<String, Discipline> getDiscipline() {
        return discipline;
    }

    public HashMap<String, Gift> getGift() {
        return gift;
    }

    public HashMap<String, Will> getWill() {
        return will;
    }

    public HashMap<String, Armor> getArmor() {
        return armor;
    }

    public HashMap<String, Weapons> getWeapon() {
        return weapon;
    }

    public HashMap<String, Strength> getStrength() {
        return strength;
    }

    public HashMap<String, Weakness> getWeakness() {
        return weakness;
    }

}
