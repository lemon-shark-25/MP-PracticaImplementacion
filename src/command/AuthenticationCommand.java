/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.AuthenticationManager;
import control.GameContext;
import domain.User;
import interaction.AuthenticationScreen;
import interaction.Screen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AuthenticationCommand implements Command{

	private final GameContext context;
	private final AuthenticationScreen authScreen;
	private final AuthenticationManager authManager;
	private final Screen successScreen;
	private final Screen failureScreen;

	public AuthenticationCommand(
			GameContext context,
			AuthenticationScreen authScreen,
			AuthenticationManager authService,
			Screen successScreen,
			Screen failureScreen) {

		this.context = context;
		this.authScreen = authScreen;
		this.authManager = authService;
		this.successScreen = successScreen;
		this.failureScreen = failureScreen;
	}


	@Override
	public void execute() {
		String[] credentials = authScreen.askCredentials();

		User user = authManager.authenticate(credentials[0], credentials[1]);

		if (user != null) {
            context.setCurrentUser(user);
            context.setNextScreen(successScreen);
        } else {
            context.setNextScreen(failureScreen);
        }
	}
	
}
