
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class Gift implements Ability{
    private String name;
    private int attackValue;
    private int defenseValue;

    public Gift(String name, int attackValue, int defenseValue) {
        this.name = name;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
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
