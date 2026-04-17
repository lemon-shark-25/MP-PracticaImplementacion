package domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ignacio Jerónimo Martín    i.jeronimo.2024@alumnos.urjc.es
 */
public class Weapons extends Equipment{
	private final boolean handNumber;	// False una mano, True dos manos
	
	public Weapons(String n, int am, int dm, boolean hn) {
		super(n, am, dm);
		handNumber = hn;
	}

	public boolean isHandNumber() {
		return handNumber;
	}
	
}
