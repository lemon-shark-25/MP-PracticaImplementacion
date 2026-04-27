package domain;

/**
 * Clase que representa a la raza Vampiro dentro del juego.
 * @author Miguel Pradillo Bartolomé
 */
public class Vampire extends GameCharacter {

    private final int bloodPoints;
    private int age;

    /**
     * Constructor completo del Vampiro.
     * (Será llamado internamente por el VampireBuilder en su método build())
     */
    public Vampire() {
        bloodPoints = 0;
    }

    // --- Getters ---

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