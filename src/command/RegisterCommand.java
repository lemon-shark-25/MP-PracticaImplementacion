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
import interaction.MenuScreen;
import interaction.RegisterErrorScreen;
import interaction.RegisterScreen;
import interaction.WelcomeScreen;
import java.util.Set;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
	public class RegisterCommand implements Command{
	private final GameContext context;
	private final UserManager userManager;
	private final RegisterScreen registerScreen;
	private final Mode successMode;
	private final AuthenticationManager authManager;

	public RegisterCommand(
			GameContext context,
			UserManager userManager,
			AuthenticationManager authManager) {

		this.context = context;
		this.userManager = userManager;
		this.registerScreen
				= new RegisterScreen(context.getScanner());
		this.authManager = authManager;
		this.successMode = new MenuMode(new MenuScreen(context), context);
	}

	@Override
	public void execute() {
		
		String[] credentials = registerScreen.askCredentials();

        String tipo = credentials[0].trim().toUpperCase(); // "A" o "J"
        String name = credentials[1].trim();
        String nick = credentials[2].trim();
        String password = credentials[3];

        // Validación mínima del tipo
        if (!tipo.equals("A") && !tipo.equals("J")) {
            goToRegisterError();
            return;
        }

        // Nick repetido
        if (userManager.findByNick(nick) != null) {
            goToRegisterError();
            return;
        }

		User newUser;
        if (tipo.equals("A")) {
            newUser = new Administrator(name, nick, password);
        } else {
            newUser = new Player(name, nick, password);
        }

        userManager.add(newUser);
        userManager.save(); 

        context.setCurrentUser(newUser);
        context.setNextMode(successMode);
	}
	
	private void goToRegisterError() {
		// Muestras la pantalla de error
    	new RegisterErrorScreen(context.getScanner()).showScreen(Set.of());

    	// Vuelves al menú de selección (AuthenticationMode)
    	context.setNextMode(new AuthenticationMode(
            new WelcomeScreen(context.getScanner()),
            context,
            authManager,
            userManager
    ));
    }
}
