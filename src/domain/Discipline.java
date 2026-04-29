
package domain;

/**
 *
 * @author Hugp Martínez González
 */
public class Discipline extends Ability{
    private final int bloodValue;

    public Discipline(String name, String description, int attackValue, int defenseValue, int bloodValue) {
        super(name, description, attackValue,defenseValue);
            this.bloodValue = bloodValue;
    }
    
    public int getBloodValue() {
        return bloodValue;
    }
    
}
