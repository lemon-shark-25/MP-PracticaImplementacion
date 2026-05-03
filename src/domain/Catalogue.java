/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 2) {
                    continue;
                }

                String name = parts[0].trim();
                String description = parts[1].trim();

                if (file.contains("discipline")) {
                    if (parts.length >= 5) {
                        int attack = Integer.parseInt(parts[2].trim());
                        int defense = Integer.parseInt(parts[3].trim());
                        int blood = Integer.parseInt(parts[4].trim());
                        disciplineMap.put(name, new Discipline(name, description, attack, defense, blood));
                    }
                } else if (file.contains("gift")) {
                    if (parts.length >= 4) {
                        int attack = Integer.parseInt(parts[2].trim());
                        int defense = Integer.parseInt(parts[3].trim());
                        giftMap.put(name, new Gift(name, description, attack, defense));
                    }
                } else if (file.contains("will")) {
                    if (parts.length >= 5) {
                        int attack = Integer.parseInt(parts[2].trim());
                        int defense = Integer.parseInt(parts[3].trim());
                        int rage = Integer.parseInt(parts[4].trim());
                        willMap.put(name, new Will(name, description, attack, defense, rage));
                    }
                } else if (file.contains("armor")) {
                    if (parts.length >= 4) {
                        int attackMod = Integer.parseInt(parts[2].trim());
                        int defenseMod = Integer.parseInt(parts[3].trim());
                        armorMap.put(name, new Armor(name, description, attackMod, defenseMod));
                    }
                } else if (file.contains("weapon")) {
                    if (parts.length >= 5) {
                        int attackMod = Integer.parseInt(parts[2].trim());
                        int defenseMod = Integer.parseInt(parts[3].trim());
                        boolean handNumber = Boolean.parseBoolean(parts[4].trim());
                        weaponMap.put(name, new Weapons(name, description, attackMod, defenseMod, handNumber));
                    }
                } else if (file.contains("strength")) {
                    if (parts.length >= 4) {
                        int value = Integer.parseInt(parts[2].trim());
                        int type = Integer.parseInt(parts[3].trim());
                        strengthMap.put(name, new Strength(name, description, value, type));
                    }
                } else if (file.contains("weakness")) {
                    if (parts.length >= 4) {
                        int value = Integer.parseInt(parts[2].trim());
                        int type = Integer.parseInt(parts[3].trim());
                        weaknessMap.put(name, new Weakness(name, description, value, type));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading file: " + file + " - " + e.getMessage());
        }
    }

}
