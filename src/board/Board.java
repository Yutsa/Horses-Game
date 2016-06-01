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

import game.Game;

/**
 * Board is the class representing a simple Board composed of {@link Square}s.
 * 
 * @author edouard
 *
 */
public abstract class Board {
	private int width;
	private int height;
	private Square[][] squares;
	private Game game;

	/**
	 * @param width
	 *            The width of this board
	 * @param height
	 *            The height of this board
	 * @param game
	 *            The {@link Game} of this board.
	 */
	public Board(int width, int height, Game game) {
		setWidth(width);
		setHeight(height);
		setGame(game);
		squares = new Square[width][height];
	}

	/**
	 * Sets the game for this board. It can be a HorsesGame a ChessGame for
	 * instance.
	 * 
	 * @param game
	 *            The game to be played on this board.
	 */
	public void setGame(Game game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	/**
	 * Gets the {@link Game} played on this board.
	 * 
	 * @return The {@link Game} played on this board.
	 */
	public Game getGame() {
		return this.game;
	}

	/**
	 * Gets the two-dimensional array containing all the {@link Square}s
	 * composing this Board.
	 * 
	 * @return The two-dimensional array reprensenting this board.
	 */
	public Square[][] getBoard() {
		return this.squares;
	}

	/**
	 * Gets the width of this Board.
	 * 
	 * @return The width of this Board.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of this Board.
	 * 
	 * @param width
	 *            The width of this Board, it will be the number of
	 *            {@link Square}s in a row.
	 */
	public void setWidth(int width) {
		if (width <= 0)
			throw new IllegalArgumentException();
		this.width = width;
	}

	/**
	 * Gets the height of this Board.
	 * 
	 * @return The height of this Board.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of this Board.
	 * 
	 * @param height
	 *            The height of this Board. It will be the number of
	 *            {@link Square}s in a column.
	 */
	public void setHeight(int height) {
		if (height <= 0)
			throw new IllegalArgumentException();
		this.height = height;
	}

	/**
	 * Gets the Square at the (x, y) position in this Board.
	 * 
	 * @param x
	 *            The x-axis position of the Square.
	 * @param y
	 *            The y-axis position of the Square.
	 * @return The Square at the (x, y) position in this Board.
	 */
	public Square getSquare(int x, int y) {
		return squares[x][y];
	}

	/**
	 * Sets the {@link Square} at the (x, y) position in this Board.
	 * 
	 * @param square
	 *            The instance of a {@link Square} to put in this Board.
	 * @param x
	 *            The x-axis position of the {@link Square}.
	 * @param y
	 *            The y-axis position of the {@link Square}.
	 */
	public void setSquare(Square square, int x, int y) {
		if (square == null)
			throw new IllegalArgumentException();
		this.squares[x][y] = square;
	}

	@Override
	public String toString() {
		return "Board [width=" + width + ", height=" + height + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Board))
			return false;
		Board other = (Board) o;
		if (other.getHeight() != this.height || other.getWidth() != this.width)
			return false;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!(this.squares[height][width].equals(other.getSquare(height, width))))
					return false;
			}
		}
		return true;

	}
}
