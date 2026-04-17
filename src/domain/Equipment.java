/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public abstract class Equipment {
	private final String name;
	private final int attackModifier;
	private final int defenseModifier;

	public Equipment(String n, int am, int dm){
		name = n;
		attackModifier = am;
		defenseModifier = dm;
	}

	public String getName() {
		return name;
	}

	public int getAttackModifier() {
		return attackModifier;
	}

	public int getDefenseModifier() {
		return defenseModifier;
	}

	
}
