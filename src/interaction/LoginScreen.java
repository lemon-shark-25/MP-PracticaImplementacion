/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interaction;

import java.util.Scanner;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class LoginScreen {
	private final Scanner scanner;

	public LoginScreen(Scanner s){
		this.scanner = s;
	}

	public String[] askCredentials() {
		System.out.println("Introduzca sus credenciales");
		
		System.out.print("Nick: ");
		String nick = scanner.nextLine();

		System.out.print("Contrasenya: ");
		String password = scanner.nextLine();
		
		String[] credentials = {nick, password};

		return credentials;
	}	
}
