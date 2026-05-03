
package domain;
/**
 *
 * @author Hugo Martínez González
 */
public class Human implements Minion{
    private String name;
    private int health;
    private String loyalty;
    private GameCharacter owner;
    
    public Human(String name, int health, String loyalty, GameCharacter owner){
        this.name = name;
        this.health = health;
        this.loyalty = loyalty;
        this.owner = owner;
    }
    
    public String getLoyalty(){
        return loyalty;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }
    
    public GameCharacter getOwner() {
        return owner;
    }

	//Prueba
}
