/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.AuthenticationManager;
import control.AuthenticationMode;
import control.GameContext;
import control.MenuMode;
import control.Mode;
import control.UserManager;
import domain.Administrator;
import domain.Player;
import domain.User;
import interaction.RegisterErrorScreen;
import interaction.RegisterScreen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
	public class RegisterCommand implements Command{
	private final GameContext context;
	private final UserManager userManager;
	private final RegisterScreen registerScreen;
	private final Mode successMode;
	private final Mode failureMode;

	public RegisterCommand(
			GameContext context,
			UserManager userManager,
			AuthenticationManager authManager) {

		this.context = context;
		this.userManager = userManager;
		this.registerScreen
				= new RegisterScreen(context.getScanner());

		this.successMode = new MenuMode();
		this.failureMode = new AuthenticationMode(new RegisterErrorScreen(), context, authManager, userManager);
	}

	@Override
	public void execute() {
		String[] credentials = registerScreen.askCredentials();

        if (userManager.findByNick(credentials[1]) != null) {
            context.setNextMode(failureMode);
            return;
        }

		User newUser = null;
		if (credentials[0].equals("A")){
        	newUser = new Administrator(credentials[1], credentials[2], credentials[3]); 
		}else{
			newUser = new Player(credentials[1], credentials[2], credentials[3]);
		}

        userManager.add(newUser);
		userManager.save();

        context.setCurrentUser(newUser);
        context.setNextMode(successMode);
	}
	
}
