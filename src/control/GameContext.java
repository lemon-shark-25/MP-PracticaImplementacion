/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.User;
import interaction.Screen;
import java.util.Scanner;

/**
 * Implementa el patrón Decorator
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class GameContext {
	private User currentUser;
	private Mode nextMode;
	private final Scanner scanner;

	public GameContext(Scanner s){
		scanner = s;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Mode getNextMode() {
		return nextMode;
	}

	public void setNextMode(Mode mode) {
		nextMode = mode;	
	}

	public void setNextScreen(Screen successScreen) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	public Scanner getScanner() {
		return scanner;
	}

}
