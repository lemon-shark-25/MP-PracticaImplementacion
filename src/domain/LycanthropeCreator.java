
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class LycanthropeCreator implements GameCharacterCreator {
    
    @Override
    public Lycanthrope create(){
        return (Lycanthrope) new Lycanthrope();
    }
}
