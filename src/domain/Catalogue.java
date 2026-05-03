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
	private final HashMap<String,Discipline> disciplineMap = new HashMap<>();
	private final HashMap<String,Gift> giftMap = new HashMap<>();
	private final HashMap<String,Will> willMap = new HashMap<>();
	private final HashMap<String,Armor> armorMap = new HashMap<>(); 
	private final HashMap<String,Weapons> weaponMap = new HashMap<>(); 
	private final HashMap<String,Strength> strengthMap = new HashMap<>(); 
	private final HashMap<String,Weakness> weaknessMap = new HashMap<>(); 

	public Catalogue(){
		load();
	}

	private void load(){
		String[] routes = {"./data/discipline.csv", "./data/gift.csv", 
			"./data/will.csv", "./data/armor.csv", "./data/weapon.csv",
			"./data/strength.csv", "./data/weakness.csv"};
		//Bucle de carga de los HashMap
		for (String file: routes){
			loadFile(file);
		}
	}
	
    public HashMap<String, Discipline> getDiscipline() {
        return disciplineMap;
    }

    public HashMap<String, Gift> getGift() {
        return giftMap;
    }

    public HashMap<String, Will> getWill() {
        return willMap;
    }

    public HashMap<String, Armor> getArmor() {
        return armorMap;
    }

    public HashMap<String, Weapons> getWeapon() {
        return weaponMap;
    }

    public HashMap<String, Strength> getStrength() {
        return strengthMap;
    }

    public HashMap<String, Weakness> getWeakness() {
        return weaknessMap;
    }

    private void loadFile(String file) {
        
        String[] variable = new String[5];
        




    }

}
