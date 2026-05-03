package interaction;

import control.GameContext;
import java.util.Set;

public class BattleScreen implements Screen {

    private final GameContext context;

    public BattleScreen(GameContext context) {
        this.context = context;
    }

    @Override
    public char showScreen(Set<Character> validOptions) {
        System.out.println("[Batalla]");
        System.out.println("Seleccione una acción:");
        System.out.println("a) Atacar");
        System.out.println("b) Defender");
        System.out.println("c) Huir");

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
