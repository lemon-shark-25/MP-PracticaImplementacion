/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import command.AuthenticationCommand;
import command.Command;
import interaction.Screen;
import interaction.WelcomeScreen;
import java.util.HashMap;
import java.util.Map;
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
		
		Scanner s = new Scanner(System.in);

	    UserManager userManager = new UserManager();
	    AuthenticationManager authManager = new AuthenticationManager(userManager);
	
	    GameContext context = new GameContext(s);
	    Screen screen = new WelcomeScreen(s);

	    Mode initialMode = new AuthenticationMode(screen, context, authManager, userManager);
	    new ModeManager(initialMode).start();
	
    	userManager.save(); // guardar al salir
	}
	
}
