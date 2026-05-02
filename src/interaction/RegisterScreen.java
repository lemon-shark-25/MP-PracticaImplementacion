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
public class RegisterScreen implements Screen{
	private final Scanner scanner;

	public RegisterScreen(Scanner s){
		this.scanner = s;
	}

	public String[] askCredentials() {
		System.out.println("Rellene los campos:");

		String type = String.valueOf(this.askUserType());
		
		System.out.println("Nombre: ");
		String name = scanner.nextLine();

		System.out.println("Nick: ");
		String nick = scanner.nextLine();

		System.out.println("Contrasenya: ");
		String password = scanner.nextLine();
		
		String[] credentials = {type, name, nick, password};

		return credentials;
	}	

	
	private char askUserType() {
   		while (true) {
       		System.out.print("Tipo de cuenta (A = Administrador, J = Jugador): ");
        	String input = scanner.nextLine().trim().toUpperCase();

        	if (input.equals("A") || input.equals("J")) {
				System.out.println("");
            	return input.charAt(0);
        	}
        	System.out.println("Opcion invalida.");
			System.err.println("");
    	}
	}

	@Override
	public char showScreen(Set<Character> validOptions) {
		return 0;
	}
}
