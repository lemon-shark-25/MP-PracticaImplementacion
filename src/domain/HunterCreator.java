
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCreator implements GameCharacterCreator {

    @Override
    public Hunter create() {
        return (Hunter) new Hunter();
    }
       
}
