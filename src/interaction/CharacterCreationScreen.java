package interaction;

import control.GameContext;
import java.util.Set;

public class CharacterCreationScreen implements Screen {

    private final GameContext context;

    public CharacterCreationScreen(GameContext context) {
        this.context = context;
    }

    @Override
    public char showScreen(Set<Character> validOptions) {
        System.out.println("[Creación de Personaje]");
        System.out.println("Seleccione una opción:");
        System.out.println("a) Crear nuevo personaje");
        System.out.println("b) Volver al menú");

        while (true) {
            System.out.print("Opción: ");
            String input = context.getScanner().nextLine().trim().toLowerCase();
            if (!input.isEmpty()) {
                char choice = input.charAt(0);
                if (validOptions.contains(choice)) {
                    return choice;
                }
            }
            System.out.println("Opción inválida. Intente de nuevo.");
        }
    }
}
