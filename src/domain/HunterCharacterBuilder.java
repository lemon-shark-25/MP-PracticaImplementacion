
package domain;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCharacterBuilder extends SimilarGameCharacterBuilder{
    
    public HunterCharacterBuilder(HashMap<String, ? extends Ability> ability, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, HashMap<String, Strength> strength, HashMap<String, Weakness> weakness) {
        super(ability, armor, weapon, strength, weakness);
    }
 
    @Override
    public Hunter gameCharacterBuilder(GameCharacter characterr){
        Hunter hunterr =(Hunter) super.gameCharacterBuilder(characterr);
        return hunterr;
  
    }
    
    @Override
    protected void setAbility(GameCharacter characterr, Scanner sc){
        System.out.println("Escoge la habilidad especial de tu personaje:");
        String[] inventary = showOptions(ability,sc,false,"habilidad");
        String name = inventary[requestNumber("Escoge la habilidad de tu personaje pulsando el número", 0, inventary.length-1, sc)];
        Will wil = (Will) ability.get(name);
        characterr.setAbility(wil); 
    }

}