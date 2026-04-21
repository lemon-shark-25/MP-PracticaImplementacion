
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class Strength implements Modifier {
    private String name;
    private int StrengthValue;

    public Strength(String name, int StrengthValue) {
        this.name = name;
        this.StrengthValue = StrengthValue;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return StrengthValue;
    }
    
}
