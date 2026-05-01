

package domain;


/**
 *
 * @author Hugo Martínez González
 */
public class Lycanthrope extends GameCharacter {
    private int heigth;
    private int weigth;
    private final int rage =0;
    private boolean mode;
    
    public int getHeigth() {
        return heigth;
    }

    public boolean isMode() {
        return mode;
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
    
    public void Transformation(){
        if (!isMode()){
            setHeigth(heigth+75);
            setWeigth(weigth+100); 
        }else{
            setHeigth(heigth-75);
            setWeigth(weigth-100);
        }
    }
}
