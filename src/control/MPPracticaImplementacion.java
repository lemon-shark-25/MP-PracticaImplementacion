/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import interaction.AuthenticationScreen;
import interaction.Screen;
import java.util.Scanner;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class MPPracticaImplementacion {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner();
		Screen screen = new AuthenticationScreen(s);
		Mode initialMode = new AuthenticationMode(screen, context);
		ModeManager mm = new ModeManager(initialMode);

		mm.start();
	}
	
}
