/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.AuthenticationManager;
import control.GameContext;
import control.MenuMode;
import control.UserManager;
import domain.Administrator;
import domain.Challenge;
import domain.ChallengeMediator;
import interaction.AdminChallengeScreen;
import interaction.MenuScreen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class ValidateChallengeCommand implements Command{
	
	private final GameContext context;
	private final UserManager userManager;
	private final ChallengeMediator mediator;
	private final AuthenticationManager authManager;
	
	public ValidateChallengeCommand(GameContext context, UserManager userManager, ChallengeMediator mediator, AuthenticationManager authManager) {
	    this.context = context;
	    this.userManager = userManager;
	    this.mediator = mediator;
		this.authManager = authManager;
    }

	@Override
	public void execute() {

		if (!(context.getCurrentUser() instanceof Administrator)) {
			System.out.println("Solo un operador puede validar desafíos.\n");
			return;
		}

		Challenge pending = mediator.nextChallengeForAdmin(); 
		if (pending == null) {
			System.out.println("No hay desafíos pendientes de validación.\n");
			// Vuelve al menú admin
			context.setNextMode(new MenuMode(new MenuScreen(context), context, this.authManager, userManager, mediator));
			return;
		}

		context.setNextMode(new AdminChallengeValidationMode(
                new AdminChallengeScreen(context.getScanner(), pending),
                context,
                userManager,
                mediator,
                pending
        ));
    }

}
