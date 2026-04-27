
package domain;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCharacterBuilder {
    
        private HashMap<String,Gift> ability;
        private HashMap<String,Armor> armor;
        private HashMap<String,Weapons> weapon;       
        private Minion minion;
        private HashMap<String,Strength> strength;
        private HashMap<String,Weakness> weakness;

    public HunterCharacterBuilder(HashMap<String,Gift> ability, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, Minion minion, HashMap<String,Strength> strength, HashMap<String,Weakness> weakness) {
        this.ability = ability;
        this.armor = armor;
        this.weapon = weapon;
        this.minion = minion;
        this.strength = strength;
        this.weakness = weakness;
    }
    
    public Hunter hunterBuilder(){
        HunterCreator hunterCreator = new HunterCreator();
        Hunter hunter = hunterCreator.create();
        Scanner sc = new Scanner(System.in);
        setName(hunter,sc);
        setPower(hunter,sc);
        hunter.setHealth(5);
        setAbility(hunter,sc);
        
        
        
        
        
        return hunter;
    }
    
    private void setName(Hunter hunter, Scanner sc){
        String name;
        do{
            System.out.print("Elige el nombre de tu personaje");
            name = sc.nextLine();
        }while(name.isBlank());
        hunter.setName(name);
    }
    
    private void setPower(Hunter hunter, Scanner sc) { 
        int power; 
        do {
            try {
                System.out.print("Elige el poder de tu personaje, debe estar entre 1 y 5: ");
                power = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número válido.");
                power = 0; 
            }
        } while (power < 1 || power > 5); 
        hunter.setPower(power);
    }
    
    private void setAbility(Hunter hunter, Scanner sc){
        int number =0;
        String[] inventary = new String[5];
        for (Ability ab: ability.values()){
           System.out.print(number + "La habilidad se llama: " + ab.getName());
           System.out.print("La descripción de las habilidades: " + ab.getDescription());
           inventary[number] = ab.getName();
           number ++;
           if (number==inventary.length){
               inventary = java.util.Arrays.copyOf(inventary, inventary.length * 2);
           }
        }
        int abilityNumber;
        do {
            try {
                System.out.print("Escoge la habilidad de tu personaje pulsando el número");
                abilityNumber = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número válido.");
                abilityNumber = 0; 
            }
        } while (abilityNumber < 0 || abilityNumber > number-1);
        String name = inventary[abilityNumber];
        hunter.setAbility(ability.get(name)); 
    }
    
}
