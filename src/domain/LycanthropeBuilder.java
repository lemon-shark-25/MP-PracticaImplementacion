package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Constructor específico (Builder) para la raza Licántropo.
 * Adaptado a la implementación actual de la clase Lycanthrope.
 * @author Miguel Pradillo Bartolomé
 */
public class LycanthropeBuilder implements CharacterBuilder {

    // --- Variables temporales para almacenar el estado ---
    private String name;
    private int health;
    private int power;
    private Will will;
    
    // Inicializamos colecciones por defecto
    private HashMap<String, Armor> armor = new HashMap<>();
    private HashMap<String, Weapons> weapon = new HashMap<>();
    private LinkedList<Strength> strength = new LinkedList<>();
    private LinkedList<Weakness> weakness = new LinkedList<>();
    
    private Minion minion;
    private Equipment principalArmor;
    private Equipment principalWeapon;

    // Atributos exclusivos del Licántropo
    private int heigth;
    private int weigth;
    private int rage;

    // --- Métodos de la interfaz genérica CharacterBuilder ---

    @Override
    public CharacterBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CharacterBuilder withBaseStats(int health, int power) {
        this.health = health;
        this.power = power;
        return this;
    }

    @Override
    public CharacterBuilder withAbility(Ability ability) {
        //
        if (ability instanceof Will) {
            this.will = (Will) ability;
        } else {
            throw new IllegalArgumentException("Error: La clase Lycanthrope actual exige una habilidad de tipo Will.");
        }
        return this;
    }

    @Override
    public CharacterBuilder withArmor(HashMap<String, Armor> armor) {
        this.armor = armor;
        return this;
    }

    @Override
    public CharacterBuilder withWeapons(HashMap<String, Weapons> weapons) {
        this.weapon = weapons;
        return this;
    }

    @Override
    public CharacterBuilder withMinion(Minion minion) {
        this.minion = minion;
        return this;
    }

    @Override
    public CharacterBuilder withStrengths(LinkedList<Strength> strengths) {
        this.strength = strengths;
        return this;
    }

    @Override
    public CharacterBuilder withWeaknesses(LinkedList<Weakness> weaknesses) {
        this.weakness = weaknesses;
        return this;
    }

    @Override
    public CharacterBuilder withPrincipalEquipment(Equipment principalArmor, Equipment principalWeapon) {
        this.principalArmor = principalArmor;
        this.principalWeapon = principalWeapon;
        return this;
    }

    // --- Métodos específicos del Licántropo ---

    public LycanthropeBuilder withHeigth(int heigth) {
        this.heigth = heigth;
        return this;
    }

    public LycanthropeBuilder withWeigth(int weigth) {
        this.weigth = weigth;
        return this;
    }

    public LycanthropeBuilder withRage(int rage) {
        this.rage = rage;
        return this;
    }

    // --- Método Final de Construcción ---

    @Override
    public Character build() {
        // Validaciones de seguridad básicas
        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalStateException("Error: No se puede crear un personaje sin nombre.");
        }
        if (this.will == null) {
            throw new IllegalStateException("Error: No se ha asignado la habilidad (Will) al Licántropo.");
        }

        // Ensamblaje final llamando al constructor de Lycanthrope
        return new Lycanthrope(
            heigth, weigth, rage, name, health, power, will, 
            armor, weapon, minion, strength, weakness, 
            principalArmor, principalWeapon
        );
    }
}