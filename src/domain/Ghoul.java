
package domain;

/**
 *
 * @author Usuario
 */
public class Ghoul implements Minion{
    
    private String name;
    private int health;
    private Character owner;
    private int dependence;
    
        public Ghoul(String name, int health, Character owner, int dependence) {
        this.name = name;
        this.health = health;
        this.owner = owner;
        this.dependence = dependence;
    }
    
    public Character getOwner() {
        return owner;
    }

    public int getDependence() {
        return dependence;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }
    
    
}
