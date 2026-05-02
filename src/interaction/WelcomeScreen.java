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
public class WelcomeScreen implements Screen{

	private final Scanner scanner;
	public WelcomeScreen(Scanner s){
		this.scanner = s;
	}
	
	@Override
	public char showScreen(Set<Character> validOptions) {
		System.out.println("""
Bienvenido a Simulador de Combate Fantastico!
Seleccione una de las siguientes opciones:
a) Iniciar sesion
b) Crear cuenta
c) Salir del juego
		""");

		while(true){
		System.out.print("Opcion:");
		String input = scanner.nextLine().trim().toLowerCase();

			if (!input.isEmpty()){
				char choice = input.charAt(0);
				if (validOptions.contains(choice)){
					System.out.println("");
					return choice;
				}
				System.out.println("Opcion invalida.");
				System.out.println("");
			}
		}
	}	
}
