
package domain;


/**
 *
 * @author Hugo Martínez González
 */
public class Lycanthrope extends GameCharacter {
    private int heigth;
    private int weigth;
    private final int rage;

    public Lycanthrope(){
        this.rage = 0;
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
