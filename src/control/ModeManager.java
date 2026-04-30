/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class ModeManager {
	private Mode currentMode;

	public ModeManager(Mode initialMode){
		currentMode = initialMode;	
	}

	void start() {
		while (currentMode != null){
			currentMode = currentMode.showScreen();
		}
	}
	
}
