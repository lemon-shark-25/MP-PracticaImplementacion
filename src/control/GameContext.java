/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.Catalogue;
import domain.User;
import java.util.Scanner;

/**
 * Implementa el patrón Decorator
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class GameContext {
	private User currentUser;
	private Mode nextMode;
	private final Scanner scanner;
        private final Catalogue catalog;

	public GameContext(Scanner s, Catalogue cat){
		scanner = s;
                catalog = cat;
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

	public Scanner getScanner() {
		return scanner;
	}

        public Catalogue getCatalog() {
            return catalog;
        }

}
