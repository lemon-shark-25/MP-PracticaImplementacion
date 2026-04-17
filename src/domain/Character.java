/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public abstract class Character {
	private final String name;	
	private final int health;
	private final int power;

	public Character(String name, int health, int power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getPower() {
		return power;
	}



}
