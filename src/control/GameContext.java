/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.User;

/**
 * Implementa el patrón Decorator
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class GameContext {
	private User currentUser;
	private Mode nextMode;

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

}
