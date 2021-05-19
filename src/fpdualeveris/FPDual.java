package fpdualeveris;

import operators.Pinball;

/**
 * Clase Principal del Desafío 2 de Java.
 * 
 * @author Fran Luna
 *
 */
public class FPDual {
	
	/**
	 * Método Principal
	 * 
	 * @param args
	 * @author Fran Luna
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		Pinball p = new Pinball();
		
		if (p instanceof Pinball)
		     System.out.println("Game instanced susuccessfully, starting the game...");
			p.gameMenu();
	}

}
