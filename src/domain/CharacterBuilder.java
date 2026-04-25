package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Interfaz para el patrón Builder aplicado a la creación de personajes.
 * * * @author Miguel Pradillo Bartolomé
 */
public interface CharacterBuilder {
    
    // Todos estos métodos devuelven el propio Builder para permitir el encadenamiento
    CharacterBuilder withName(String name);
    
    CharacterBuilder withBaseStats(int health, int power);
    
    CharacterBuilder withAbility(Ability ability);
    
    CharacterBuilder withArmor(HashMap<String, Armor> armor);
    
    CharacterBuilder withWeapons(HashMap<String, Weapons> weapons);
    
    CharacterBuilder withMinion(Minion minion);
    
    CharacterBuilder withStrengths(LinkedList<Strength> strengths);
    
    CharacterBuilder withWeaknesses(LinkedList<Weakness> weaknesses);
    
    CharacterBuilder withPrincipalEquipment(Equipment principalArmor, Equipment principalWeapon);
    
    /**
     * Método final que ensambla y devuelve el objeto Character construido.
     * @return Instancia final del personaje (Vampire, Lycanthrope o Hunter)
     */
    GameCharacter build();
}