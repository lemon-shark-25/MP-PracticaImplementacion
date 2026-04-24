
package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Hugo Martínez González
 */
public class Lycanthrope extends Character {
    private int heigth;
    private int weigth;
    private int rage;

    public Lycanthrope(int heigth, int weigth, int rage, String name, 
            int health, int power, Will will, HashMap<String, Armor> armor, HashMap<String, Weapons> weapon, 
            Minion minion, LinkedList<Strength> strength, LinkedList<Weakness> weakness, 
            Equipment principalArmor, Equipment principalWeapon) {
        super(name, health, power, will, armor, weapon, minion, strength, weakness, principalArmor, principalWeapon);
        this.heigth = heigth;
        this.weigth = weigth;
        this.rage = rage;
    }

    public int getHeigth() {
        return heigth;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getRage() {
        return rage;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }
    
    @Override
    public Will getAbility() {
        return (Will) super.getAbility();
    }
    
}
