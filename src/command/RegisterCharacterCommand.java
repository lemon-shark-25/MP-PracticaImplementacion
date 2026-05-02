/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.GameContext;
import domain.Ability;
import domain.Armor;
import domain.Discipline;
import domain.Gift;
import domain.Hunter;
import domain.HunterCharacterBuilder;
import domain.HunterCreator;
import domain.Lycanthrope;
import domain.LycanthropeCharacterBuilder;
import domain.LycanthropeCreator;
import domain.Player;
import domain.Strength;
import domain.User;
import domain.Vampire;
import domain.VampireCreator;
import domain.VampireCharacterBuilder;
import domain.Weakness;
import domain.Weapons;
import domain.Will;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class RegisterCharacterCommand implements Command{

    private final GameContext context;
    private HashMap<String,Discipline> discipline;
    private HashMap<String,Gift> gift;
    private HashMap<String,Will> will;
    private HashMap<String,Armor> armor; 
    private HashMap<String,Weapons> weapon; 
    private HashMap<String,Strength> strength; 
    private HashMap<String,Weakness> weakness; 

    public RegisterCharacterCommand(GameContext context, HashMap<String, Discipline> discipline, HashMap<String, Gift> gift, HashMap<String, Will> will , HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, HashMap<String, Strength> strength, HashMap<String, Weakness> weakness) {
        this.context = context;
        this.discipline = discipline;
        this.gift = gift;
        this.will = will;
        this.armor = armor;
        this.weapon = weapon;
        this.strength = strength;
        this.weakness = weakness;
    }


      
	@Override
	public void execute() {
            Scanner sc = new Scanner(System.in);
            menu();
            int chose = requestNumber("Escoge:",0,2,sc);
            MenuMode mode = new MenuMode();
            switch (chose){
                case 0:{
                   VampireCreator vampCreator = new VampireCreator();
                   Vampire vampir = vampCreator.create();
                   VampireCharacterBuilder vampBuilder = new VampireCharacterBuilder(discipline,armor,weapon,strength,weakness);
                   Player play = (Player) context.getCurrentUser();
                   play.setGameCharacter(vampBuilder.gameCharacterBuilder(vampir));
                   context.setNextMode(mode);
                   break;
                }
                case 1:{
                    LycanthropeCreator lycanCreator = new LycanthropeCreator();
                    Lycanthrope lycan = lycanCreator.create();
                    LycanthropeCharacterBuilder lycanBuilder = new LycanthropeCharacterBuilder(discipline,armor,weapon,strength,weakness);
                    Player play = (Player) context.getCurrentUser();
                    play.setGameCharacter(lycanBuilder.gameCharacterBuilder(lycan));
                    context.setNextMode(mode);
                    break; 
                }
                case 2:{    
                    HunterCreator huntCreator = new HunterCreator();
                    Hunter hunt = huntCreator.create();
                    HunterCharacterBuilder huntBuilder = new HunterCharacterBuilder(discipline,armor,weapon,strength,weakness);
                    Player play = (Player) context.getCurrentUser();
                    play.setGameCharacter(huntBuilder.gameCharacterBuilder(hunt));
                    context.setNextMode(mode);
                    break; 
                }
                
            }
        }
        
        private void menu(){
            System.out.println("Selecciona de que tipo quieres que sea tu personaje:");
            System.out.println("0) Tipo Vampiro");
            System.out.println("1) Tipo Licantropo");
            System.out.println("2) Tipo Cazador");
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
}
