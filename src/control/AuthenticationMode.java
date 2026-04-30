/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import command.AuthenticationCommand;
import command.Command;
import command.ExitCommand;
import command.RegisterCommand;
import interaction.AuthenticationScreen;
import interaction.Screen;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AuthenticationMode implements Mode{
	private final Screen screen;
    private final GameContext context;
    private final AuthenticationManager authManager;
    private final UserManager userManager;
    private Map<Character, Command> commands;

    public AuthenticationMode(Screen screen, GameContext context,
                              AuthenticationManager authManager,
                              UserManager userManager) {
        this.screen = screen;
        this.context = context;
        this.authManager = authManager;
        this.userManager = userManager;
        initCommands();
    }

	private void initCommands() {
		commands = new HashMap<>();

		commands.put('a', new AuthenticationCommand(
				context,
				new AuthenticationScreen(context.getScanner()),
				userManager,
				authManager
		));

		commands.put('b', new RegisterCommand(context, userManager, authManager)); 
		commands.put('c', new ExitCommand(context));
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
