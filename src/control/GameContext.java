/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.User;
import interaction.Screen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class GameContext {
	private User currentUser;
	private Screen nextScreen;

	public User getCurrentUser() {
		return currentUser;
	}

	public Screen getNextScreen() {
		return nextScreen;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void setNextScreen(Screen nextScreen) {
		this.nextScreen = nextScreen;
	}

}
