/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.AuthenticationManager;
import control.AuthenticationMode;
import control.GameContext;
import control.UserManager;
import domain.User;
import interaction.WelcomeScreen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class UnregisterCommand implements Command {

	
	private final GameContext context;
    private final UserManager userManager;
    private final AuthenticationManager authManager;

    public UnregisterCommand(GameContext context,
                             UserManager userManager,
                             AuthenticationManager authManager) {
        this.context = context;
        this.userManager = userManager;
        this.authManager = authManager;
    }

	@Override
	public void execute() {

		User currentUser = context.getCurrentUser();

		// Seguridad defensiva (no debería ocurrir)
		if (currentUser == null) {
			return;
		}
		userManager.remove(currentUser.getNick());
		userManager.save();
		context.setCurrentUser(null);

		context.setNextMode(
				new AuthenticationMode(
						new WelcomeScreen(context.getScanner()),
						context,
						authManager,
						userManager
				)
		);
	}
}
