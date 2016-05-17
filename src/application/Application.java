package application;

import game.HorsesGame;
import tests.Tester;

public class Application {

	public static void main(String[] args) {
		HorsesGame game = new HorsesGame(4, 4);
		game.runGame();
	}

}
