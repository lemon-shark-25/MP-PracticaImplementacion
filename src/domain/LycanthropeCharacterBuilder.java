package domain;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Constructor específico (Builder) para la raza Licántropo.
 * Adaptado a la implementación actual de la clase Lycanthrope.
 * @author Miguel Pradillo Bartolomé
 */
public class LycanthropeCharacterBuilder extends SimilarGameCharacterBuilder {

    private int heigth;
    private int weigth;

    public LycanthropeCharacterBuilder(HashMap<String, ? extends Ability> ability, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, HashMap<String, Strength> strength, HashMap<String, Weakness> weakness) {
        super(ability, armor, weapon, strength, weakness);
    }
 
    @Override
    public Lycanthrope gameCharacterBuilder(GameCharacter characterr){
        Lycanthrope lycan =(Lycanthrope) super.gameCharacterBuilder(characterr);
        Scanner sc = new Scanner(System.in);
        int h = requestNumber("Introduce la altura", 100, 210, sc);
        int w = requestNumber("Introduce el peso", 50, 150, sc);
        lycan.setHeight(h); 
        lycan.setWeight(w);
        return lycan;
  
    }
    
    @Override
    protected void setAbility(GameCharacter characterr, Scanner sc){
        System.out.println("Escoge la habilidad especial de tu personaje:");
        String[] inventary = showOptions(ability,sc,false,"habilidad");
        String name = inventary[requestNumber("Escoge la habilidad de tu personaje pulsando el número", 0, inventary.length-1, sc)];
        Gift gif = (Gift) ability.get(name);
        characterr.setAbility(gif); 
    }
}