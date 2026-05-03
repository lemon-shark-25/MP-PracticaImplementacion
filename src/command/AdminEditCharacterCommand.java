package command;

import control.GameContext;
import control.UserManager;

/**
 * Placeholder command to allow compilation when admin edit character functionality is not implemented.
 */
public class AdminEditCharacterCommand implements Command {

    public AdminEditCharacterCommand(GameContext context, UserManager userManager) {
        // Placeholder for admin character editing
    }

    @Override
    public void execute() {
        System.out.println("AdminEditCharacterCommand no implementado.");
    }
}
