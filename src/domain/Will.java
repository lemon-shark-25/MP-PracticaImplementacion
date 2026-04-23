
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class Will extends Ability{
    private final int rageValue;

    public Will(String name, int attackValue, int defenseValue, int rageValue) {
        super(name, attackValue, defenseValue);
        this.rageValue = rageValue;
    }
  
    public int getRageValue() {
        return rageValue;
    }
    
}
