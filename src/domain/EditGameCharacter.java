
package domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public abstract class EditGameCharacter {
        
    private HashMap<String,Ability> ability;
    private HashMap<String,Armor> armor; 
    private HashMap<String,Weapons> weapon; 
    private HashMap<String,Strength> strength; 
    private HashMap<String,Weakness> weakness; 

    public EditGameCharacter(HashMap<String, ? extends Ability> ability, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, HashMap<String, Strength> strength, HashMap<String, Weakness> weakness) {
        this.ability = (HashMap<String, Ability>) ability;
        this.armor = armor;
        this.weapon = weapon;
        this.strength = strength;
        this.weakness = weakness;
    }

    protected void menu(){
        System.out.println("0) Dejar de editar");
        System.out.println("1) Editar el nombre");
        System.out.println("2) Editar el poder");
        System.out.println("3) Editar la habilidad");
        System.out.println("4) Editar las fortalezas");
        System.out.println("5) Editar las debilidades");
        System.out.println("6) Editar la armadura principal");
        System.out.println("7) Editar la arma o armas principal");
    }
   
    public void changeName(GameCharacter characterr, Scanner sc){
        characterr.setName(requestString("Escribe el nuevo nombre de tu personaje", sc));
    }
        
    public void changePower(GameCharacter characterr, Scanner sc){
        characterr.setPower(requestNumber("Escribe el nuevo poder de ataque de tu personaje",1,5,sc));
    }
    
    public void changeAbility(GameCharacter characterr, Scanner sc){
        System.out.println("Escoge la nueva habilidad especial de tu personaje:");
        String[] inventary = showOptions(ability,sc,false,"habilidad");
        String name = inventary[requestNumber("Escoge la habilidad de tu personaje pulsando el número", 0, inventary.length-1, sc)];
        characterr.setAbility(ability.get(name)); 
    }
    
    public void changeMinion(GameCharacter characterr, Scanner sc){
        
    }
    
    public void changeModifier(GameCharacter characterr, Scanner sc, boolean mode){      
        int election = 0;
        String[] inventary;
        HashMap<String, Modifier> modifierChoosen= new HashMap<>();
        HashMap<String,Modifier> cop;
        String messagee;
        System.out.println("0) No cambiar nada");
        if(mode){
            System.out.println("1) Añadir fortalezas");
            System.out.println("2) Eliminar fortalezas");
            cop = new HashMap<>(strength);
        }else{
            System.out.println("1) Añadir debilidades");
            System.out.println("2) Eliminar debilidades");
            cop = new HashMap<>(weakness);
        }
    }
    
    protected void eliminate(GameCharacter characterr, Scanner sc, boolean mode){
        String[] total;
        if (mode){            
            total = showOptions(characterr.getStrength(), sc, true, "modificador");
        } else{
            total = showOptions(characterr.getWeakness(), sc, true, "modificador");
        }
        int election = requestNumber("Selecciona:",0,total.length,sc);
        if (election!=0){
            if(mode){
                characterr.getStrength().remove(total[election-1]);
            }else{
                characterr.getWeakness().remove(total[election-1]);
            }
        }   
    }
    
    public void changePrincipalEquipment(GameCharacter characterr, Scanner sc, boolean mode){
        String[] inventary;
        HashMap<String, Equipment> equipChosen;
        if (mode){
            System.out.println("Elige una nueva armadura principal");
            equipChosen = new HashMap<>(armor);
        }else{
            System.out.println("Elige una nueva arma principal");
            equipChosen = new HashMap<>(weapon);            
        }    
        inventary = showOptions(equipChosen,sc,false,"equipamiento");
        String name = inventary[requestNumber("Escoge:", 0, inventary.length-1, sc)];
        if (mode){
            characterr.setPrincipalArmor((Armor) equipChosen.get(name));
        }else{
            Weapons weap = (Weapons) equipChosen.get(name);
            Weapons noOne = new Weapons("Ninguna", "Ninguna,", 0, 0, false);
            if (weap.getHandNumber()){
                characterr.setPrincipalWeaponOne(weap);
                characterr.setPrincipalWeaponTwo(noOne);
            }else{
                characterr.setPrincipalWeaponOne(weap);
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
                int position = requestNumber("Escoge si quieres que tu personaje tenga otro arma de un brazo:", 0, inventary.length, sc);
                if (position ==0){
                    characterr.setPrincipalWeaponTwo(noOne);
                }else{    
                    name = inventary[position-1];
                    characterr.setPrincipalWeaponTwo(ohw.get(name));
                }
            }
        }   
    }
    
    protected int requestNumber(String message, int min, int max, Scanner sc){
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
        
    protected String requestString(String message, Scanner sc){
        String name;
        do{
            System.out.println(message);
            name = sc.nextLine();
        }while(name.isBlank());
        return name;
    }
    
    protected String[] showOptions(HashMap<String, ? extends Describable> options, Scanner sc, boolean mode, String message){
        LinkedList<String> inventary = new LinkedList<>();
        int number = 0; 
        if (mode){
            System.out.println(number+") Dejar de elegir");
            number ++;
        }
        for (Describable desc: options.values()){
            System.out.println(number + ") Se llama: " + desc.getName());
            System.out.println("La descripción del "+ message + ": " + desc.getDescription());
            inventary.add(desc.getName());
            number ++;
        }
        
        return inventary.toArray(new String[0]);
    }
}

