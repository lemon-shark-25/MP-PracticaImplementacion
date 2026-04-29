/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public abstract class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private final String name;
	private final String nick;
	private final String password;

	public User(String n, String nck, String p){
		name = n;
		nick = nck;
		password = p;
	}

	public String getName() {
		return name;
	}

	public String getNick() {
		return nick;
	}

	public boolean checkPassword(String pass) {
		return this.password.equals(pass);
	}

		
}
