/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.User;
import java.util.Map;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class UserManager {

	private Map<String, User> usuarios;

	public UserManager(){
		load();	
	}

	public void load() {
	

	}

    public void save() {
	

	}

    public User findByNick(String nick) {
		return usuarios.get(nick);
	}

	public void add(User u) {
		usuarios.put(u.getNick(), u);
	}
	
}
