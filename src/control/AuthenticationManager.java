/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.User;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AuthenticationManager {
	UserManager um;

	public AuthenticationManager(){
		um = new UserManager();
	}

	public boolean login(String nick, String password) {
		User u = um.findByNick(nick);
		if (u == null) {
			return false;
		}
		return u.checkPassword(password);
	}

	public User getUser(String nick){
		return um.findByNick(nick);
	}

	private void initializePasswordMap(){
		
	}

	public void addUser(User u){
		um.add(u);
	}
}
