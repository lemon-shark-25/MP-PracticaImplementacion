
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class Weakness implements Modifier{
    private String name;
    private int weaknessValue;
    private int type;

    public Weakness(String name, int weaknessValue, int type) {
        this.name = name;
        this.weaknessValue = weaknessValue;
        this.type = type;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return weaknessValue;
    }

    @Override
    public int getType() {
        return type;
    }
    
    
}
