/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import command.AcceptChallengeCommand;
import command.AuthenticationCommand;
import command.CheckRankingCommand;
import command.Command;
import command.EditCharacterCommand;
import command.ExitCommand;
import command.RegisterCharacterCommand;
import command.RegisterCommand;
import command.SendChallengeCommand;
import command.UnregisterCommand;
import interaction.AuthenticationScreen;
import interaction.Screen;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class MenuMode implements Mode{
	private final Screen screen;
	private final GameContext context;
	private Map<Character, Command> commands;

	public MenuMode(Screen screen, GameContext context){
		this.screen = screen;
		this.context = context; 
		initCommands();
	}
	
	private void initCommands() {
		commands = new HashMap<>();

		commands.put('a', new SendChallengeCommand());
		commands.put('b', new AcceptChallengeCommand());
		commands.put('c', new RegisterCharacterCommand());
		commands.put('d', new EditCharacterCommand());
		commands.put('e', new CheckRankingCommand());
		commands.put('f', new UnregisterCommand());
		commands.put('g', new ExitCommand(context));
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
					"Ningun comando asociado con esta opcion: " + option
			);
		}

		command.execute();
		return context.getNextMode();
	}
	
}
