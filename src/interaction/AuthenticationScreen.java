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
public class AuthenticationScreen implements Screen{

	private final Scanner scanner;
	public AuthenticationScreen(Scanner s){
		this.scanner = s;
	}
	
	@Override
	public char showScreen(Set<Character> validOptions) {
		System.out.println("""
                     ¡Bienvenido a Simulador de Combate Fantástico!
                     Seleccione una de las siguientes opciones:
                     a) Iniciar sesión
                     b) Crear cuenta
                     c) Salir del juego
		""");

		while(true){
		System.out.print("Opción:");
		String input = scanner.nextLine().trim().toLowerCase();

			if (!input.isEmpty()){
				char choice = input.charAt(0);
				if (validOptions.contains(choice)){
					return choice;
				}
				System.out.println("Opción inválida.");
			}
		}
	}	
}
