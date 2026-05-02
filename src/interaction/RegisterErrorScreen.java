/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interaction;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class RegisterErrorScreen implements Screen{

	private final Scanner scanner;

	public RegisterErrorScreen(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public char showScreen(Set<Character> validOptions) {
		System.out.println("Error en el registro del nuevo usuario.");
		System.out.println("Pulse ENTER para volver.");

		scanner.nextLine();

		return 0;
	}
}
