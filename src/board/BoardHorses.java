package board;

import game.HorsesGame;

//TODO: Implement BoardHorses.
public class BoardHorses extends Board {
	public BoardHorses (HorsesGame game) {
		super(15, 15, game);
	}
	
	public void createBasicSquares() {
		Square[][] squares = this.getBoard();
		for (int i = 0; i < 6; i++) {
			squares[6][i] = new BasicSquare(6, i, this.getGame().getTeam(0), this);
		}
		for (int x = 0; x < 5; x++) {
			squares[x][6] = new BasicSquare(x, 6, this.getGame().getTeam(0), this);
		}
		for (int x = 8; x < 14; x++) {
			squares[x][6] = new BasicSquare(x, 6, this.getGame().getTeam(1), this);
		}
		for (int y = 0; y < 5; y++) {
			squares[8][y] = new BasicSquare(8, y, this.getGame().getTeam(1), this);
		}
		for (int x = 0; x < 6; x++) {
			squares[x][8] = new BasicSquare(x, 8, this.getGame().getTeam(2), this);
		}
		for (int y = 9; y < 14; y++) {
			squares[6][y] = new BasicSquare(6, y, this.getGame().getTeam(2), this);
		}
		for (int x = 8; x < 14; x++) {
			squares[x][8] = new BasicSquare(x, 8, this.getGame().getTeam(3), this);
		}
		
	}
}
