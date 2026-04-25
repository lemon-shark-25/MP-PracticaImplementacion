package domain;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Constructor específico (Builder) para la raza Vampiro.
 * Recopila la información paso a paso y ensambla el objeto final.
 * * @author Miguel Pradillo Bartolomé
 */
public class VampireBuilder implements CharacterBuilder {

    // --- Variables temporales para almacenar el estado antes de construir ---
    private String name;
    private int health;
    private int power;
    private Discipline discipline; // Específico de vampiro
    
    // Inicializamos las colecciones por defecto para evitar NullPointerExceptions
    private HashMap<String, Armor> armor = new HashMap<>();
    private HashMap<String, Weapons> weapon = new HashMap<>();
    private LinkedList<Strength> strength = new LinkedList<>();
    private LinkedList<Weakness> weakness = new LinkedList<>();
    
    private Minion minion;
    private Equipment principalArmor;
    private Equipment principalWeapon;

    // Atributos exclusivos del Vampiro
    private int bloodPoints;
    private int age;

    // --- Métodos de la interfaz CharacterBuilder ---

    @Override
    public CharacterBuilder withName(String name) {
        this.name = name;
        return this; // Devolvemos 'this' para permitir el encadenamiento (Fluent Interface)
    }

    @Override
    public CharacterBuilder withBaseStats(int health, int power) {
        this.health = health;
        this.power = power;
        return this;
    }

    @Override
    public CharacterBuilder withAbility(Ability ability) {
        // Validación de regla de negocio: Un vampiro SOLO puede tener una Disciplina
        if (ability instanceof Discipline) {
            this.discipline = (Discipline) ability;
        } else {
            throw new IllegalArgumentException("Error: La habilidad de un Vampiro debe ser obligatoriamente una Disciplina.");
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

    // --- Métodos ESPECÍFICOS del Vampiro (No están en la interfaz padre) ---

    public VampireBuilder withBloodPoints(int bloodPoints) {
        this.bloodPoints = bloodPoints;
        return this;
    }

    public VampireBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    // --- Método Final de Construcción ---

    @Override
    public GameCharacter build() {
        // Validaciones finales antes de crear (Opcional, pero muy recomendado)
        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalStateException("No se puede crear un personaje sin nombre.");
        }
        if (this.discipline == null) {
            throw new IllegalStateException("No se puede crear un Vampiro sin su Disciplina asignada.");
        }

        // Aquí es donde llamamos al constructor de Vampire que creamos antes
        return new Vampire(
            name, health, power, discipline, 
            armor, weapon, minion, 
            strength, weakness, 
            principalArmor, principalWeapon, 
            bloodPoints, age
        );
    }
}