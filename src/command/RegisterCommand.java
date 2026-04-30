/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.GameContext;
import control.UserManager;
import domain.Administrator;
import domain.Player;
import domain.User;
import interaction.MenuScreen;
import interaction.RegisterErrorScreen;
import interaction.RegisterScreen;
import interaction.Screen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class RegisterCommand implements Command{
	private final GameContext context;
	private final UserManager userManager;
	private final RegisterScreen registerScreen;
	private final Screen successScreen;
	private final Screen failureScreen;

	public RegisterCommand(
			GameContext context,
			UserManager userManager) {

		this.context = context;
		this.userManager = userManager;
		this.registerScreen
				= new RegisterScreen(context.getScanner());

		this.successScreen = new MenuScreen();
		this.failureScreen = new RegisterErrorScreen();
	}

	@Override
	public void execute() {
		
		String[] credentials = registerScreen.askCredentials();
        String nick = credentials[0];
        String password = credentials[1];

        if (userManager.findByNick(nick) != null) {
            context.setNextMode(failureScreen);
            return;
        }

		User newUser = null;
		if (credentials[0].equals("A")){
        	newUser = new Administrator(credentials[1], credentials[2], credentials[3]); 
		}else{
			newUser = new Player(credentials[1], credentials[2], credentials[3]);
		}

        userManager.add(newUser);

        context.setCurrentUser(newUser);
        context.setNextMode(successScreen);
	}
	
}
