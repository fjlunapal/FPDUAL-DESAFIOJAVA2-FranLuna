package fpdualeveris;

import operators.Pinball;

/**
 * Clase Principal del Desaf�o 2 de Java.
 * 
 * @author Fran Luna
 *
 */
public class FPDual {
	
	/**
	 * M�todo Principal
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
