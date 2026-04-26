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
public class UserScreen implements Screen{

	private final Scanner scanner;
	public UserScreen(Scanner s){
		this.scanner = s;
	}

	@Override
	public char showScreen(Set<Character> validOptions) {
		System.out.println("""
					[Menú Principal]
                    Seleccione una de las siguientes opciones:
                    a) Registrar personaje 
                    b) Dar de baja personaje
                    c) Desafiar usuario
					d) Consultar oro
					e) Consultar ranking global
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
