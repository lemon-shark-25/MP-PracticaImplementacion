/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class Player extends User{
	private String registerNumber;	
	private int gold;
	
	public Player(String n, String nck, String p){
		super(n, nck, p);
		registerNumber = newRegisterNumber();
		gold = 0;
	}

	public int getGold(){
		return this.gold;
	}
	
}
