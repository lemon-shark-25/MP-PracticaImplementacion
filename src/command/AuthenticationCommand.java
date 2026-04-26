/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.GameContext;
import interaction.AuthenticationScreen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AuthenticationCommand implements Command{

	private final GameContext context;
	private final AuthenticationScreen authScreen;

	public AuthenticationCommand(GameContext gc){
		context = gc;	
		authScreen = new AuthenticationScreen();
	}

	@Override
	public void execute() {
		String[] credentials = authScreen.askCredentials();
	}
	
}
