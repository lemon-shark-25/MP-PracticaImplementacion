package control;

import interaction.Screen;
import java.util.Set;

public class CharacterCreationMode implements Mode {

    private final Screen screen;
    private final GameContext context;

    public CharacterCreationMode(Screen screen, GameContext context) {
        this.screen = screen;
        this.context = context;
    }

    @Override
    public Mode showScreen() {
        char option = screen.showScreen(Set.of('a', 'b'));
        return doAction(option);
    }

    @Override
    public Mode doAction(char option) {
        System.out.println("CharacterCreationMode: opción seleccionada -> " + option);
        return context.getNextMode();
    }
}
