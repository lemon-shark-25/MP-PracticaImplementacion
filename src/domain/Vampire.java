package domain;

/**
 * Clase que representa a la raza Vampiro dentro del juego.
 * @author Miguel Pradillo Bartolomé
 */
public class Vampire extends GameCharacter {

    private final int bloodPoints =0;
    private int age;

    public int getBloodPoints() {
        return bloodPoints;
    }

    public int getAge() {
        return age;
    }

    // --- Setter único ---
    
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sobrescribimos el getter de Ability para que devuelva directamente 
     * una Discipline y evitar conversiones manuales en el combate.
     */
    
    @Override
    public Discipline getAbility() {
        return (Discipline) super.getAbility();
    }
}