
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class Weakness implements Modifier{
    private String name;
    private int weaknessValue;

    public Weakness(String name, int weaknessValue) {
        this.name = name;
        this.weaknessValue = weaknessValue;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return weaknessValue;
    }
    
    
}
