/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import command.ApproveChallengeCommand;
import command.Command;
import command.DenyChallengeCommand;
import command.ExitCommand;
import control.AuthenticationManager;
import domain.Challenge;
import domain.ChallengeMediator;
import interaction.Screen;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AdminChallengeValidationMode implements Mode{
	

	private final Screen screen;
	private final GameContext context;
	private final UserManager userManager;
	private final ChallengeMediator mediator;
	private final Challenge challenge;
	private final AuthenticationManager authManager;

	private final Map<Character, Command> commands = new HashMap<>();

	public AdminChallengeValidationMode(Screen screen,
				GameContext context,
				UserManager userManager,
				ChallengeMediator mediator,
				Challenge challenge,
				AuthenticationManager authManager) {
			this.screen = screen;
			this.context = context;
			this.userManager = userManager;
			this.mediator = mediator;
			this.challenge = challenge;
			this.authManager = authManager;

			initCommands();
		}

	private void initCommands() {
        commands.put('a', new ApproveChallengeCommand(context, userManager, mediator, challenge, authManager));
        commands.put('b', new DenyChallengeCommand(context, userManager, mediator, challenge, authManager));
        commands.put('c', new ExitCommand(context)); // opcional aquí también
    }

    @Override
    public Mode showScreen() {
        char option = screen.showScreen(commands.keySet());
        return doAction(option);
    }

	@Override
    public Mode doAction(char option) {
        Command cmd = commands.get(option);
        if (cmd == null) throw new IllegalStateException("Opcion sin comando: " + option);
        cmd.execute();
        return context.getNextMode();
    }
}
