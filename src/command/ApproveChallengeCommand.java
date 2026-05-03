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
import interaction.MenuScreen;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class ApproveChallengeCommand implements Command{

	private final GameContext context;
	private final UserManager userManager;
	private final ChallengeMediator mediator;
	private final Challenge challenge;
	private final AuthenticationManager authManager; 

	public ApproveChallengeCommand(GameContext context,
			UserManager userManager,
			ChallengeMediator mediator,
			Challenge challenge,
			AuthenticationManager authManager) {
		this.context = context;
		this.userManager = userManager;
		this.mediator = mediator;
		this.challenge = challenge;
		this.authManager = authManager;
	}

	@Override
	public void execute() {

		if (!(context.getCurrentUser() instanceof Administrator admin)) {
			System.out.println("Solo un operador puede validar.\n");
			return;
		}

		// --- Configurar fortalezas/debilidades presentes ---
		// Si ya tienes clases Strength/Weakness, cámbialo por tus tipos reales.
		// Aquí uso Strings para no asumir tu modelo exacto.
		List<String> strengths = new ArrayList<>();
		List<String> weaknesses = new ArrayList<>();

		System.out.println("Configurar fortalezas/debilidades para este desafío.");
		System.out.println("Introduce fortalezas (una por línea). ENTER en blanco para terminar:");
		while (true) {
			String line = context.getScanner().nextLine().trim();
			if (line.isEmpty()) {
				break;
			}
			strengths.add(line);
		}

		System.out.println("Introduce debilidades (una por línea). ENTER en blanco para terminar:");
		while (true) {
			String line = context.getScanner().nextLine().trim();
			if (line.isEmpty()) {
				break;
			}
			weaknesses.add(line);
		}

// Necesitas guardar esto dentro del Challenge.
		// Recomendado: añade al Challenge dos listas:
		//   - activeStrengths
		//   - activeWeaknesses
		// y un setter:
		// challenge.setActiveModifiers(strengths, weaknesses);
		// Aprobar en el mediator (cambia estado a PENDING_PLAYER_RESPONSE y persiste)
		mediator.passChallenge(challenge, admin);

		System.out.println("Desafío validado. Notificación enviada al jugador desafiado.\n");

		// Volver al menú de admin
		context.setNextMode(new MenuMode(new MenuScreen(context),
				context, authManager, userManager, mediator));
	}
	
}
