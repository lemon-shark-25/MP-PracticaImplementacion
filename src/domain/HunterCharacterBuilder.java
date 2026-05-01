
package domain;

import java.util.HashMap;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCharacterBuilder extends SimilarGameCharacterBuilder{


    public HunterCharacterBuilder(HashMap<String,Ability> ability, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, Minion minion, HashMap<String,Strength> strength, HashMap<String,Weakness> weakness) {
        super(ability,armor,weapon,minion,strength,weakness);
    }
    
    @Override
    public Hunter gameCharacterBuilder(GameCharacter characterr){
        return (Hunter) super.gameCharacterBuilder(characterr);
    }

}
