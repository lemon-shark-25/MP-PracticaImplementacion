
package domain;


/**
 *
 * @author Hugo Martínez González
 */
public class Hunter extends GameCharacter {
    private final int attitude = 3;

    public int getAttitude() {
        return attitude;
    }
    
    @Override
    public Gift getAbility() {
        return (Gift) super.getAbility();
    }
    
}
