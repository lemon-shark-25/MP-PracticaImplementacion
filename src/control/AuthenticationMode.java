/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import command.Command;
import interaction.Screen;
import java.util.Map;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AuthenticationMode implements Mode{
	private final Screen screen;
    private final GameContext context;
	
	public AuthenticationMode(Screen screen, GameContext context) {
    	this.screen = screen;
	    this.context = context;
	}

	@Override
	public Mode showScreen() {
		char option = screen.showScreen(commands.keySet());
		return doAction(option);
	}

	@Override
	public Mode doAction(char option) {
		Command command = commands.get(option);

		if (command == null) {
			throw new IllegalStateException(
					"Ningún comando asociado con esta opción: " + option
			);
		}

		command.execute();
		return context.getNextMode();
	}
	
}
