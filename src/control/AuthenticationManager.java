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
	private final UserManager um;

	public AuthenticationManager(UserManager um){
		this.um = um;
	}

	public boolean login(String nick, String password) {
		User u = um.findByNick(nick);
		if (u == null) return false;
		return u.checkPassword(password);
	}
}
