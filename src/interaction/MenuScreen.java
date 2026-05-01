/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interaction;

import control.GameContext;
import domain.Player;
import domain.User;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class MenuScreen implements Screen {

	private final GameContext context;
	public MenuScreen(GameContext c){
		this.context = c;
	}

	@Override
	public char showScreen(Set<Character> validOptions) {
		System.out.println("[Menu Principal]");
		if (context.getCurrentUser() != null){
			System.out.println("Usuario: " + context.getCurrentUser().getNick());
			if (context.getCurrentUser() instanceof Player player) System.out.println("Oro: " + player.getGold());
		}
        System.out.println("""
                     Seleccione una de las siguientes opciones:
                     a) Lanzar desafio
                     b) Aceptar desafio
                     c) Registrar personaje
                     d) Editar personaje
                     e) Consultar clasificacion
                     f) Darse de baja
                     g) Salir
		""");

		while (true) {
			System.out.print("Opcion:");
			String input = context.getScanner().nextLine().trim().toLowerCase();

			if (!input.isEmpty()) {
				char choice = input.charAt(0);
				if (validOptions.contains(choice)) {
					return choice;
				}
				System.out.println("Opcion invalida.");
			}
		}
	}
	
}
