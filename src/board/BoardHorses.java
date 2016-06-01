/*  horses_game
    Copyright (C) 2016  Édouard WILLISSECK

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package board;

import game.HorsesGame;


/**
 * BoardHorses is the class representing the {@link Board} of a Horses game.
 *  
 * @author edouard
 *
 */
public class BoardHorses extends Board {
	/**
	 * @param game The {@link HorsesGame} played on this board.
	 */
	public BoardHorses(HorsesGame game) {
		super(15, 15, game);
		createBasicSquares();
		createHorsePen();
		createBottomStairway();
		createStairwaySquare();
	}

	/**
	 * Creates the {@link BasicSquare} in their right position inside this Board.
	 */
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

	/**
	 * Creates the {@link HorsePen} in their right position inside this Board.
	 */
	public void createHorsePen() {
		Square[][] squares = this.getBoard();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				squares[i][j] = new HorsePen(i, j, this.getGame().getTeam(0), this);
			}
		}
		for (int i = 9; i < 15; i++) {
			for (int j = 0; j < 6; j++) {
				squares[i][j] = new HorsePen(i, j, this.getGame().getTeam(1), this);
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 9; j < 15; j++) {
				squares[i][j] = new HorsePen(i, j, this.getGame().getTeam(2), this);
			}
		}
		for (int i = 9; i < 15; i++) {
			for (int j = 9; j < 15; j++) {
				squares[i][j] = new HorsePen(i, j, this.getGame().getTeam(3), this);
			}
		}
	}

	/**
	 * Creates the {@link BottomStairway} in their right position inside this Board.
	 */
	public void createBottomStairway() {
		Square[][] squares = this.getBoard();
		squares[0][7] = new BottomStairway(0, 7, this.getGame().getTeam(0), this);

		squares[7][0] = new BottomStairway(7, 0, this.getGame().getTeam(1), this);

		squares[14][7] = new BottomStairway(14, 7, this.getGame().getTeam(3), this);

		squares[7][14] = new BottomStairway(7, 14, this.getGame().getTeam(2), this);

	}
	
	/**
	 * Creates the {@link StairwaySquare} in their right position inside this Board.
	 */
	public void createStairwaySquare() {
		Square[][] squares = this.getBoard();
		int j = 1;
		for (int i = 1; i < 7; i++) {
			squares[i][7] = new StairwaySquare(i, 7, this.getGame().getTeam(0), this, i);
		}
		for (int i = 1; i < 7; i++) {
			squares[7][i] = new StairwaySquare(7, i, this.getGame().getTeam(1), this, i);
		}
		for (int i = 13; i > 7; i--) {
			squares[i][7] = new StairwaySquare(i, 7, this.getGame().getTeam(3), this, j);
			j++;
		}
		j = 1;
		for (int i = 13; i > 7; i--) {
			squares[7][i] = new StairwaySquare(7, i, this.getGame().getTeam(2), this, j);
			j++;
		}
		squares[7][7] = new StairwaySquare(7, 7, this.getGame().getTeam(0), this, 1);
	}

	@Override
	public String toString() {
		String board = "";
		Square[][] squares = this.getBoard();
		for (int x = 0; x < this.getHeight(); x++) {
			for (int y = 0; y < this.getWidth(); y++) {
				if (!squares[y][x].isEmpty()) {
					board += "♞";
				}
				else if (squares[y][x] instanceof BasicSquare) {
					board += "◌";
				} else if (squares[y][x] instanceof HorsePen) {
					board += "◉";
				} else if (squares[y][x] instanceof BottomStairway) {
					board += "◍";
				} else if (squares[y][x] instanceof StairwaySquare){
					StairwaySquare s = (StairwaySquare) squares[y][x];
					board += s.getNbStairway();
				}
				else {
					board += "-";
				}
			}
			board += "\n";
		}
		return board;
	}

}
