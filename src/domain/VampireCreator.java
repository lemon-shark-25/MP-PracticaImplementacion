
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class VampireCreator implements GameCharacterCreator{
        
    @Override
    public Vampire create() {
        return (Vampire) new Vampire();
    }
    
}
