/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import interaction.Screen;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public interface Mode {
	public Mode showScreen();
	public Mode doAction(char option);
}
