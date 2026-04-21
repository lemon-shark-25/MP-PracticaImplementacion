
package domain;

/**
 *
 * @author Hugp Martínez González
 */
public class Discipline implements Ability{
    private String name;
    private int attackValue;
    private int defenseValue;
    private int bloodValue;

    public Discipline(String name, int attackValue, int defenseValue, int bloodValue) {
        this.name = name;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
        this.bloodValue = bloodValue;
    }
   
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackValue() {
        return  attackValue;
    }

    @Override
    public int getDefenseValue() {
        return defenseValue;
    }

    public int getBloodValue() {
        return bloodValue;
    }
    
}
