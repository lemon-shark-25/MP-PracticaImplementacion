/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import control.GameContext;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class ExitCommand implements Command{
	private final GameContext context;

	public ExitCommand(GameContext context){
		this.context = context;
	}

	@Override
	public void execute() {
		System.out.println("Cerrando programa.");
		context.setNextMode(null);
	}
	
}
