
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class Will implements Ability{
    private String name;
    private int attackValue;
    private int defenseValue;
    private int rageValue;

    public Will(String name, int attackValue, int defenseValue, int rageValue) {
        this.name = name;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
        this.rageValue = rageValue;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackValue() {
        return attackValue;
    }

    @Override
    public int getDefenseValue() {
        return defenseValue;
    }

    public int getRageValue() {
        return rageValue;
    }
    
}
