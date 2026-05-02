package control;

import domain.*;
import interaction.CharacterCreationScreen;
import interaction.Screen;

import java.util.Scanner;

/**
 * Controlador encargado de gestionar el flujo de creación de un nuevo personaje.
 * Interactúa con la vista y utiliza los Builders para asegurar la correcta
 * instanciación de Vampiros, Licántropos o Cazadores.
 * @author Miguel Pradillo Bartolomé
 */
public class CharacterCreationMode implements Mode {

    private SaveAdministrator saveAdmin;
    private Player activePlayer;
    private Scanner scanner;

    /**
     * Constructor del modo de creación.
     * @param activePlayer El jugador que está conectado actualmente y al que se le asignará el personaje.
     */
    public CharacterCreationMode(Player activePlayer) {
        this.saveAdmin = new SaveAdministrator();
        this.activePlayer = activePlayer;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método principal que orquesta el flujo de creación.
     */
    public void startCreationFlow() {
        // 1. Mostramos la pantalla de creación de personaje
        CharacterCreationScreen screen = new CharacterCreationScreen();
        showScreen(screen);

        System.out.println("Introduce el nombre de tu nuevo personaje:");
        String name = scanner.nextLine();

        System.out.println("Selecciona la raza (1: Vampiro, 2: Licántropo, 3: Cazador):");
        int raceChoice = Integer.parseInt(scanner.nextLine());

        Character newCharacter = null;

        // 2. Bifurcación lógica dependiendo de la raza seleccionada
        try {
            switch (raceChoice) {
                case 1:
                    newCharacter = createVampire(name);
                    break;
                case 2:
                    newCharacter = createLycanthrope(name);
                    break;
                case 3:
                    newCharacter = createHunter(name);
                    break;
                default:
                    System.out.println("Opción no válida. Abortando creación.");
                    return;
            }

            // 3. Asignación y Persistencia
            if (newCharacter != null) {
                activePlayer.setCharacter(newCharacter);
                saveAdmin.saveState(); // Guardamos los datos actualizados en persistencia
                System.out.println("¡Enhorabuena! El personaje " + name + " ha sido creado y vinculado a tu cuenta.");
            }

        } catch (Exception e) {
            System.out.println("Error durante la creación del personaje: " + e.getMessage());
        }
    }

    // --- Métodos privados de apoyo (Delegación a los Builders) ---

    private Character createVampire(String name) {
        System.out.println("Introduce la edad del Vampiro:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce los Puntos de Sangre iniciales:");
        int blood = Integer.parseInt(scanner.nextLine());

        // Instanciamos una habilidad por defecto o pedimos al usuario que elija una del catálogo
        Discipline defaultDiscipline = new Discipline("Murciélago", 2, 2, 5);

        // Usamos el Builder
        return new VampireBuilder()
                .withName(name)
                .withBaseStats(5, 3) // Salud y Poder base
                .withAbility(defaultDiscipline)
                .withAge(age)
                .withBloodPoints(blood)
                .build();
    }

    private Character createLycanthrope(String name) {
        System.out.println("Introduce la altura del Licántropo:");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el peso del Licántropo:");
        int weight = Integer.parseInt(scanner.nextLine());

        Will defaultWill = new Will("Furia Ciega", 3, 1, 4);

        return new LycanthropeBuilder()
                .withName(name)
                .withBaseStats(6, 4)
                .withAbility(defaultWill)
                .withHeigth(height)
                .withWeigth(weight)
                .withRage(0) // Empiezan con 0 de Rabia por defecto
                .build();
    }

    private Character createHunter(String name) {
        System.out.println("Introduce la Voluntad inicial del Cazador:");
        int willpower = Integer.parseInt(scanner.nextLine());

        // Suponiendo que el Cazador usa un 'Talent' o habilidad genérica
        Ability defaultTalent = new Ability("Puntería", 2, 3) {}; // Instancia anónima temporal

        // Asume la existencia del HunterBuilder siguiendo el mismo patrón
        return new HunterBuilder()
                .withName(name)
                .withBaseStats(4, 5)
                .withAbility(defaultTalent)
                .withWillpower(willpower)
                .build();
    }

    // --- Métodos obligatorios de la interfaz Mode ---

    @Override
    public char showScreen(Screen screen) {
        screen.show();
        return '0';
    }

    @Override
    public Screen doAction(char action) {
        // Lógica de enrutamiento de pantallas según la arquitectura del menú
        return null;
    }
}