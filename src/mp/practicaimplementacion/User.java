/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp.practicaimplementacion;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public abstract class User {
	private String name;
	private String nick;
	private String password;

	public User(String n, String nck, String p){
		name = n;
		nick = nck;
		password = p;
	}
}
