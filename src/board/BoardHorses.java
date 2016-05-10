package board;

import game.HorsesGame;

//TODO: Implement BoardHorses.
public class BoardHorses extends Board {
	public BoardHorses (HorsesGame game) {
		super(15, 15, game);
		createBasicSquares();
	}
	
	public void createBasicSquares() {
		Square[][] squares = this.getBoard();
		for (int i = 0; i < 7; i++) {
			squares[6][i] = new BasicSquare(6, i, this.getGame().getTeam(0), this);
		}
		for (int x = 0; x < 6; x++) {
			squares[x][6] = new BasicSquare(x, 6, this.getGame().getTeam(0), this);
		}
		for (int x = 8; x < 15; x++) {
			squares[x][6] = new BasicSquare(x, 6, this.getGame().getTeam(1), this);
		}
		for (int y = 0; y < 6; y++) {
			squares[8][y] = new BasicSquare(8, y, this.getGame().getTeam(1), this);
		}
		for (int x = 0; x < 7; x++) {
			squares[x][8] = new BasicSquare(x, 8, this.getGame().getTeam(2), this);
		}
		for (int y = 9; y < 15; y++) {
			squares[6][y] = new BasicSquare(6, y, this.getGame().getTeam(2), this);
		}
		for (int x = 8; x < 15; x++) {
			squares[x][8] = new BasicSquare(x, 8, this.getGame().getTeam(3), this);
		}
		for (int y = 9; y < 15; y++) {
			squares[8][y] = new BasicSquare(8, y, this.getGame().getTeam(3), this);
		}
	}
	
	@Override
	public String toString() {
		String board = "";
		Square[][] squares = this.getBoard();
		for (int x = 0; x < this.getHeight(); x++) {
			for (int y = 0; y < this.getWidth(); y++) {
				if (squares[y][x] instanceof BasicSquare) {
					board += "b";
				}
				else {
					board += "-";
				}
				/*else if (squares[i][j] instanceof HorsePen) {
					board += "p";
				}
				else if (squares[i][j] instanceof BottomStairway) {
					board += "bo";
				}
				else if (squares[i][j] instanceof StairwaySquare) {
					board += "s";
				}*/
			}
			board += "\n";
		}
		return board;
	}
}
