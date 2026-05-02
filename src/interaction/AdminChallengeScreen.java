/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interaction;

import domain.Challenge;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AdminChallengeScreen implements Screen {

	private final Scanner scanner;
	private final Challenge challenge;

	public AdminChallengeScreen(Scanner scanner, Challenge challenge) {
		this.scanner = scanner;
		this.challenge = challenge;
	}

	@Override
	public char showScreen(Set<Character> validOptions) {
		System.out.println("""
[Desafío pendiente de validación]
Desafiante: %s
Desafiado: %s
Oro apostado: %d

a) Validar desafío
b) Rechazar desafío
""".formatted(
				challenge.getDefyingPlayer().getNick(),
				challenge.getDefiedPlayer().getNick(),
				challenge.getBetGold()
		));

		while (true) {
			System.out.print("Opcion:");
			String input = scanner.nextLine().trim().toLowerCase();

			if (!input.isEmpty()) {
				char choice = input.charAt(0);
				if (validOptions.contains(choice)) {
					System.out.println("");
					return choice;
				}
				System.out.println("Opcion invalida.");
				System.out.println("");
			}
		}
	}
}
