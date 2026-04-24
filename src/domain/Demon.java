
package domain;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Hugo Martínez González
 */
public class Demon implements Minion{
    private String name;
    private int health;
    private Character owner;
    private String pact;
    private LinkedList<Minion> minions;

    public Demon(String name, int health, Character owner, String pact, LinkedList<Minion> minions) {
        this.name = name;
        this.health = health;
        this.owner = owner;
        this.pact = pact;
        this.minions = minions;
    }

    public Character getOwner() {
        return owner;
    }
    public String getPact() {
        return pact;
    }

    public LinkedList<Minion> getMinions() {
        return minions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        int x = 0;
        Iterator<Minion> it = minions.iterator();
        while (it.hasNext()) {
            Minion m = it.next(); 
            x += m.getHealth(); 
        }
        x = x + this.health;
        return x;
    }
    
    public void addMinion(Minion minion){
        minions.add(minion);
    }
    
    public void removeMinion(Minion minion){
        minions.remove(minion);
    }
}
