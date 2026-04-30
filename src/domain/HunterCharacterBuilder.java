
package domain;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCharacterBuilder {
    
        private HashMap<String,Gift> ability;//ya
        private HashMap<String,Armor> armor; //ya
        private HashMap<String,Weapons> weapon; // ya   
        private Minion minion;//revisar muchisimp
        private HashMap<String,Strength> strength; //ya
        private HashMap<String,Weakness> weakness; //ya

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
        setModifier(hunter,sc,true);
        setModifier(hunter,sc,false);
        hunter.setArmor(armor);
        hunter.setWeapon(weapon);
        setPrincipalEquipment(hunter,sc,true);
        setPrincipalEquipment(hunter,sc,false);
        
        return hunter;
    }
    
    private void setName(Hunter hunter, Scanner sc){
        hunter.setName(requestString("Elige el nombre de tu personaje",sc));
    }
    
    private void setPower(Hunter hunter, Scanner sc) { 
        hunter.setPower(requestNumber("Elige el poder de tu personaje, debe estar entre 1 y 5: ",1,5,sc));
    }
    
    private void setAbility(Hunter hunter, Scanner sc){
        String[] inventary = showOptions(ability,sc,false,"habilidad");
        String name = inventary[requestNumber("Escoge la habilidad de tu personaje pulsando el número", 0, inventary.length-1, sc)];
        hunter.setAbility(ability.get(name)); 
    }
    
    private void setMinion(Hunter hunter, Scanner sc, Demon demon){//revisar la logica muy bien
        String message;
        if (demon== null){
            message = "Elige el esbirro que quiere que tenga tu personaje:\n 0) Ninguno\n1) Demonio \n 2) Ghoul \n 3) Humano";
        }else message = "Elige el esbirro que quiere que tenga tu demonio:\n 0) Ninguno\n1) Demonio \n 2) Ghoul \n 3) Humano";
        switch (requestNumber(message,0,3,sc)) {
            case 0:{
                if (demon==null){
                    hunter.setMinion(null);
                }else
                break;
            }
            case 1: {
                String name = requestString("Elige el nombre del esbirro", sc);
                int health = requestNumber("Elige la salud del esbirro",1,3,sc);
                String pact = requestString("Describe la depndencia del esbirro",sc);
                if (demon==null){
                    Demon demonion = new Demon(name,health,hunter,pact,null);
                    setMinion(hunter,sc,demonion);
                    hunter.setMinion(demonion);
                }else{
                    Demon demonion = new Demon(name,health,hunter,pact,null);
                    setMinion(hunter,sc,demonion);
                    demon.addMinion(demonion);
                }
                break;
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
                String loyal = loyalty[requestNumber("Elige la lealtad del esbirro /n0)ALTA /n1)MEDIA /n2) BAJA", 0,2,sc)];
                if (demon == null){
                    hunter.setMinion(new Human(name,health, loyal ,hunter));
                }else demon.addMinion(new Human(name,health,loyal ,hunter));
                    break;
            }                
        }
    }
    
    private void setModifier(Hunter hunter,Scanner sc, boolean mode){
        int election = 0;
        String[] inventary;
        HashMap<String, Modifier> modifierChoosen= new HashMap<>();
        HashMap<String,Modifier> cop;
        if(mode){
            System.out.println("Elige un conjunto de fortalezas");
            cop = new HashMap<>(strength);
        }else{
            System.out.println("Elige un conjunto de debilidades");
            cop = new HashMap<>(weakness);
        }
        do{
            inventary = showOptions(cop,sc,true,"modificador");
            election = requestNumber("Selecciona:",0,inventary.length,sc);
            if (election == 0){
                if (mode) {
                    HashMap<String, Strength> finalStrengths = new HashMap<>();
                    for (Modifier mod : modifierChoosen.values()) {
                        finalStrengths.put(mod.getName(), (Strength) mod); 
                    }
                hunter.setStrength(finalStrengths);
                } else {
                    HashMap<String, Weakness> finalWeaknesses = new HashMap<>();
                    for (Modifier mod : modifierChoosen.values()) {
                        finalWeaknesses.put(mod.getName(), (Weakness) mod); 
                    }
                    hunter.setWeakness(finalWeaknesses);
                }
            } else{
               String name = inventary[election-1];
               modifierChoosen.put(name, cop.get(name));
               cop.remove(name);
            }
        }while (election!=0);    
    }
    
    public void setPrincipalEquipment(Hunter hunter, Scanner sc, boolean mode){
        String[] inventary;
        HashMap<String, Equipment> equipChosen;
        if (mode){
            System.out.print("Elige una armadura principal");
            equipChosen = new HashMap<>(armor);
        }else{
            System.out.print("Elige un arma principal");
            equipChosen = new HashMap<>(weapon);            
        }    
        inventary = showOptions(equipChosen,sc,false,"equipamiento");
        String name = inventary[requestNumber("Escoge:", 0, inventary.length, sc)];
        if (mode){
            hunter.setPrincipalArmor((Armor) equipChosen.get(name));
        }else{
            Weapons weap = (Weapons) equipChosen.get(name);
            Weapons noOne = new Weapons("Ninguna", "Ninguna,", 0, 0, false);
            if (weap.getHandNumber()){
                hunter.setPrincipalWeaponOne(weap);
                hunter.setPrincipalWeaponTwo(noOne);
            }else{
                hunter.setPrincipalWeaponOne(weap);
                HashMap<String,Weapons> oneHandWeapon = new HashMap<>();
                for (Equipment equip: equipChosen.values()){
                    oneHandWeapon.put(equip.getName(), (Weapons) equip);    
                }  
                HashMap<String,Weapons> ohw = new HashMap<>();
                for (Weapons weaps: oneHandWeapon.values()){
                    if (!weaps.getHandNumber()){
                        ohw.put(weaps.getName(), weaps);
                    }
                }
                inventary = showOptions(ohw,sc,true,"equipamiento");
                int position = requestNumber("Escoge:", 0, inventary.length, sc);
                if (position ==0){
                    hunter.setPrincipalWeaponTwo(noOne);
                }else{    
                    name = inventary[position-1];
                    hunter.setPrincipalWeaponTwo(ohw.get(name));
                }
            }
        }   
    }
        
    private int requestNumber(String message, int min, int max, Scanner sc){
        int number =0;
        boolean proof;
        do {
            proof =false;
            try {
                System.out.println(message + "(" + min + "-" + max + ")");
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
            System.out.println(message);
            name = sc.nextLine();
        }while(name.isBlank());
        return name;
    }
    
    private String[] showOptions(HashMap<String, ? extends Describable> options, Scanner sc, boolean mode, String message){
        String[] inventary = new String[5];
        int number = 0; 
        if (mode){
            System.out.print(number+"Dejar de elegir");
            number ++;
        }
        for (Describable desc: options.values()){
            System.out.println(number + "El" + message + "se llama: " + desc.getName());
            System.out.println("La descripción del "+ message + ": " + desc.getDescription());
            if (mode){
                inventary[number-1] = desc.getName();
            }else inventary[number] = desc.getName();
            number ++;
            if (number-1==inventary.length){
                inventary = java.util.Arrays.copyOf(inventary, inventary.length * 2);
            }
        }
        return inventary;
    }
}
