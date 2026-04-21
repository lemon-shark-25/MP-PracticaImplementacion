
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class Strength implements Modifier {
    private String name;
    private int StrengthValue;
    private int type;

    public Strength(String name, int StrengthValue, int type) {
        this.name = name;
        this.StrengthValue = StrengthValue;
        this.type = type;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return StrengthValue;
    }

    @Override
    public int getType() {
        return type;
    }
    
}
