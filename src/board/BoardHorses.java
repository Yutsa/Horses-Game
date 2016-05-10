package board;

import game.Game;

//TODO: Implement BoardHorses.
public class BoardHorses extends Board {
	public BoardHorses (Game game) {
		super(15, 15, game);
	}
	
	public void createBasicSquares() {
		Square[][] squares = this.getBoard();
		for (int i = 0; i < 6; i++) {
			squares[6][i] = new BasicSquare()
		}
	}
}
