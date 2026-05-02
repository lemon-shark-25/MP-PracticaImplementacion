
package domain;

import java.util.HashMap;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCharacterBuilder extends SimilarGameCharacterBuilder{
    
    public HunterCharacterBuilder(HashMap<String, Ability> ability, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, HashMap<String, Strength> strength, HashMap<String, Weakness> weakness) {
        super(ability, armor, weapon, strength, weakness);
    }
 
    @Override
    public Hunter gameCharacterBuilder(GameCharacter characterr){
        Hunter hunterr =(Hunter) super.gameCharacterBuilder(characterr);
        return hunterr;
  
    }

}