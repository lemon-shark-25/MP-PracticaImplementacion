/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.AuthenticationManager;
import control.GameContext;
import control.UserManager;
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
	private final UserManager userManager;
	private final AuthenticationManager authManager;
	private final Screen successScreen;
	private final Screen failureScreen;

	public AuthenticationCommand(
			GameContext context,
			AuthenticationScreen authScreen,
			UserManager userManager,
			AuthenticationManager authManager,
			Screen successScreen,
			Screen failureScreen) {

		this.context = context;
		this.authScreen = authScreen;
		this.userManager = userManager;
		this.authManager = authManager;
		this.successScreen = successScreen;
		this.failureScreen = failureScreen;
	}


	@Override
	public void execute() {
		String[] credentials = authScreen.askCredentials();

		if (authManager.login(credentials[0], credentials[1])){
			User user = userManager.findByNick(credentials[0]);
			if (user != null) {
	            context.setCurrentUser(user);
	            context.setNextMode(successScreen);
	        } else {
	            context.setNextMode(failureScreen);
	        }
		}
	}
	
}
