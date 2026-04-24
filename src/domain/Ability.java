
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public abstract class Ability {
	private final String name;
	private final int attackValue;
        private final int defenseValue;

	public Ability(String name, int attack, int defense){
		this.name = name;
		attackValue = attack;
                defenseValue = defense;
	}

	public String getName() {
		return name;
	}

	public int getAttackValue() {
		return attackValue;
	}	
        
        public int getDefenseValue() {
		return defenseValue;
	}
}
