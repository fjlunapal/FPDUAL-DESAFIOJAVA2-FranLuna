package operators;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que contiene los métodos necesarios para el juego.
 * 
 * @author Fran Luna
 *
 */
public class Pinball {
	/** Scanner */
	private Scanner sc = new Scanner(System.in);
	/** Contador de puntuación */
	private int score = 0;
	/** Contador de partidas */
	private int gamesCont = 0;
	/** Mapa que almacena las partidas y su respectiva puntuación */
	private HashMap<Integer, Integer> gamesPlayed = new HashMap<Integer, Integer>();

	/** Generar puntuacion aleatoria y mostrarla por pantalla */
	public int launchBall() {
		Random r = new Random();
		int points = r.nextInt(300) + 1;
		this.score = this.score + points;
		System.out.println("The ball gave you " + points + " points! Now you have " + this.score + " points.");

		return this.score;
	}

	/**
	 * Preguntar al usuario el nivel de dificultad, donde puede elegir el modo
	 * facil(20 tiradas), medio(15 tiradas) o dificil(10 tiradas)
	 */
	public int chooseDifficulty() {
		int difficulty = 0;
		do {
			System.out.println("Choose game difficulty! (1.Easy, 2.Medium, 3.Hard)");
			try {
				difficulty = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println(e.toString());
				difficulty = 0;
			}
			if (difficulty < 1 || difficulty > 3)
				System.out.println("Please, select a valid option");
		} while (difficulty < 1 || difficulty > 3);
		return difficulty;
	}

	/**
	 * Método que contiene el menú del juego y va llamando a los métodos anteriores
	 * para empezar el programa
	 * 
	 * @throws InterruptedException
	 */
	public void gameMenu() throws InterruptedException {
		boolean salir = false;
		int option = 0;

		/* Estructura do while que hace de menu */
		do {
			System.out.println("Welcome to Space Pinball! Please, select an option\n1.Play\n2.Check games\n3.Exit");
			try {
				option = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println(e.toString());
				option = 0;
			}
			switch (option) {
			case 1:
				/*
				 * Switch Case en el que se elige la dificultad de la partida llamando al método
				 * chooseDifficulty()
				 */
				switchChooseDifficulty();
				break;
			case 2:
				/*
				 * If en el que se comprueba si se ha jugado alguna partida, en el caso de que
				 * sí, muestra las partidas
				 */
				if (gamesCont > 0) {
					System.out.println("Here you have the games that you have played");
					showGamesPlayed();
				} else if (gamesCont == 0 || gamesCont < 0)
					System.out.println("You haven't played any games yet!");
				break;

			case 3:
				System.out.println("Goodbye!");
				salir = true;
				break;
			default:
				System.out.println("Please, select a valid option");
			}
		} while (salir == false);

	}

	/**
	 * Método que contiene un switch para elegir la dificultad, donde llama a su vez
	 * al método getFinalScore(), el cual está descrito en el siguiente comentario.
	 * 
	 * @throws InterruptedException
	 */
	private void switchChooseDifficulty() throws InterruptedException {
		switch (chooseDifficulty()) {
		case 1:
			System.out.println("You choosed the easy mode");
			getFinalScore(20);
			break;
		case 2:
			System.out.println("You choosed the medium mode");
			getFinalScore(15);
			break;
		case 3:
			System.out.println("You choosed the hard mode");
			getFinalScore(10);
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	/**
	 * Método que realiza las tiradas según la variable it que se le pase como
	 * parámetro, usandola como iterador para el buclque que mencionado
	 * anteriormente, realiza las tiradas gracias al método launchBall()
	 * 
	 * @throws InterruptedException
	 */
	private void getFinalScore(int it) throws InterruptedException {
		for (int i = 0; i <= it; i++) {
			Thread.sleep(1000);
			launchBall();
		}
		gamesPlayed();
		System.out.println("You ended with " + this.score + " points!");
		this.score = 0;
	}

	/**
	 * Metodo que almacena las partidas que se han jugado y los puntos que se han
	 * obtenido en cada una de ellas
	 */
	public void gamesPlayed() {
		this.gamesCont++;
		gamesPlayed.put(this.gamesCont, this.score);
	}

	/** Mostrar las partidas jugadas y su respectiva puntuacion */
	public void showGamesPlayed() {
		gamesPlayed.forEach((k, v) -> System.out.println("Game: " + k + ": Points: " + v));

	}

}
