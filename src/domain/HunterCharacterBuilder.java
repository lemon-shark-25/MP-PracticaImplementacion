
package domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCharacterBuilder {
    
        private HashMap<String,Gift> ability;//ya
        private HashMap<String,Armor> armor;
        private HashMap<String,Weapons> weapon;       
        private Minion minion;//ya
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
        setMinion(hunter,sc,null);
        return hunter;
    }
    
    private void setName(Hunter hunter, Scanner sc){
        hunter.setName(requestString("Elige el nombre de tu personaje",sc));
    }
    
    private void setPower(Hunter hunter, Scanner sc) { 
        hunter.setPower(requestNumber("Elige el poder de tu personaje, debe estar entre 1 y 5: ",1,5,sc));
    }
    
    private void setAbility(Hunter hunter, Scanner sc){
        int number =0;
        String[] inventary = new String[5];
        System.out.print("Elige una habilidad");
        for (Ability ab: ability.values()){
           System.out.print(number + "La habilidad se llama: " + ab.getName());
           System.out.print("La descripción de las habilidades: " + ab.getDescription());
           inventary[number] = ab.getName();
           number ++;
           if (number==inventary.length){
               inventary = java.util.Arrays.copyOf(inventary, inventary.length * 2);
           }
        }
        String name = inventary[requestNumber("Escoge la habilidad de tu personaje pulsando el número", 0, number-1, sc)];
        hunter.setAbility(ability.get(name)); 
    }
    
    private void setMinion(Hunter hunter, Scanner sc, Demon demon){
        String message;
        if (demon== null){
            message = "Elige el esbirro que quiere que tenga tu personaje:/n 0) Ninguno/n1) Demonio /n 2) Ghoul /n 3) Humano";
        }else message = "Elige el esbirro que quiere que tenga tu demonio:/n 0) Ninguno/n1) Demonio /n 2) Ghoul /n 3) Humano";
        switch (requestNumber(message,0,3,sc)) {
            case 0:{
                hunter.setMinion(null);
                break;
            }
            case 1: {
                String name = requestString("Elige el nombre del esbirro", sc);
                int health = requestNumber("Elige la salud del esbirro",1,3,sc);
                String pact = requestString("Describe la depndencia del esbirro",sc);
                Demon demonion = new Demon(name,health,hunter,pact,new LinkedList<Minion>());
                setMinion(hunter,sc,demonion);
                hunter.setMinion(demonion);
            }    
            case 2:{
                String name = requestString("Elige el nombre del esbirro", sc);
                int health = requestNumber("Elige la salud del esbirro",1,3,sc);
                int dependence = requestNumber("Elige la dependencia del esbirro", 1,5,sc);
                if (demon == null){
                    hunter.setMinion(new Ghoul(name,health, hunter,dependence));
                }else demon.addMinion(new Ghoul(name,health, hunter,dependence));
                break;
            }
            case 3:{
                String name = requestString("Elige el nombre del esbirro", sc);
                int health = requestNumber("Elige la salud del esbirro",1,3,sc);
                String[] loyalty = {"ALTA", "MEDIA", "BAJA"};
                if (demon == null){
                    hunter.setMinion(new Human(name,health, loyalty[requestNumber("Elige la lealtad del esbirro /n0)ALTA /n1)MEDIA /n2) BAJA", 0,2,sc)] ,hunter));
                }else demon.addMinion(new Human(name,health,loyalty[requestNumber("Elige la lealtad del esbirro /n0)ALTA /n1)MEDIA /n2) BAJA", 0,2,sc)] ,hunter));
                    break;
            }                
        }
    }
    
    private HashMap<String,Strength> setStrength(Hunter hunter,Scanner sc){
        System.out.print("Elige un conjunto de fortalezas");
        do{
            
            for (Strength stre: strength.values()){
           System.out.print(number + "La habilidad se llama: " + ab.getName());
           System.out.print("La descripción de las habilidades: " + ab.getDescription());
           inventary[number] = ab.getName();
           number ++;
           if (number==inventary.length){
               inventary = java.util.Arrays.copyOf(inventary, inventary.length * 2);
           }
        }

        }while
    }
    private int requestNumber(String message, int min, int max, Scanner sc){
        int number =0;
        boolean proof;
        do {
            proof =false;
            try {
                System.out.print(message + "(" + min + "-" + max + ")");
                number = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número válido.");
                proof = true;
            }
        } while (number < min || number > max || proof); 
        return number;               
    }
        
    private String requestString(String message, Scanner sc){
        String name;
        do{
            System.out.print(message);
            name = sc.nextLine();
        }while(name.isBlank());
        return name;
    }
   
}
