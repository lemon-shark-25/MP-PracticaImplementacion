/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intereaction;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class AuthenticationScreen implements Screen{

	@Override
	public char showScreen() {
		System.out.println("""
                     ¡Bienvenido a Simulador de Combate Fantástico!
                     Seleccione una de las siguientes opciones:
                     a) Iniciar sesión
                     b) Crear cuenta
                     c) Salir del juego
		""");
		
	}
		
}
