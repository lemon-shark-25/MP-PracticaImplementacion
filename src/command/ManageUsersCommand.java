package command;

import control.GameContext;
import control.UserManager;

/**
 * Placeholder command to allow compilation when user management functionality is not implemented.
 */
public class ManageUsersCommand implements Command {

    public ManageUsersCommand(GameContext context, UserManager userManager) {
        // Placeholder for user management
    }

    @Override
    public void execute() {
        System.out.println("ManageUsersCommand no implementado.");
    }
}
