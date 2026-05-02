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
public class Catalogue {
	private final HashMap<String,Discipline> disciplineMap;
	private final HashMap<String,Gift> giftMap;
	private final HashMap<String,Will> willMap;
	private final HashMap<String,Armor> armorMap; 
	private final HashMap<String,Weapons> weaponMap; 
	private final HashMap<String,Strength> strengthMap; 
	private final HashMap<String,Weakness> weaknessMap; 

	public Catalogue(){
		load();
	}

	private void load(){
		String[] routes = {"./data/discipline.csv", "./data/gift.csv", 
			"./data/will.csv", "./data/armor.csv", "./data/weapon.csv",
			"./data/strength.csv", "./data/weakness.csv"};
		//Bucle de carga de los HashMap
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
