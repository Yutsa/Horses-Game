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
package piece;

import board.Board;
import board.HorsePen;
import board.Square;
import board.StairwaySquare;
import team.Team;

/**
 * Abstract class for the pieces.
 * 
 * @author Édouard WILLISSECK
 */

public abstract class Piece {
	private Square square;
	private boolean alive;
	private Team team;
	private int startingSquareX;
	private int startingSquareY;

	/**
	 * @param x The x-axis position of the Horse.
	 * @param y The y-axis position of the Horse.
	 * @param alive A boolean to check if the Horse is alive or not.
	 * @param team The team of this Horse.
	 */
	public Piece(int x, int y, boolean alive, Team team) {
		setStartingSquareX(x);
		setStartingSquareY(y);
		setAlive(alive);
		setTeam(team);
		setSquare(team.getGame().getBoard().getSquare(x, y));
	}

	/**
	 * Gets the square this piece is on.
	 * 
	 * @return The Square this piece is on.
	 */
	public Square getSquare() {
		return square;
	}

	/**
	 * Sets the square this piece is on.
	 * 
	 * @param square
	 *            The Square this piece is on.
	 */
	public void setSquare(Square square) {
		if (square == null) {
			throw new IllegalArgumentException("Paramètre null.");
		}
		if ((square instanceof HorsePen || square instanceof StairwaySquare) && !square.getTeam().equals(this.team)) {
			throw new IllegalArgumentException("Case d'une autre équipe.");
		}
		this.square = square;
		square.setPieceOnSquare(this);
	}

	/**
	 * Gets the living status of this piece.
	 * 
	 * @return A boolean showing whether this piece is alive or not.
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Sets the living status of this Piece.
	 * 
	 * @param alive
	 *            A boolean representing whether or not this piece is alive.
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Gets the team of this Piece.
	 * 
	 * @return The Team of this Piece.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Sets the team of this Piece
	 * 
	 * @param team
	 *            the Team of this Piece.
	 */
	public void setTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException("Paramètre null.");
		this.team = team;
		team.addPiece(this);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Piece))
			return false;
		Piece p = (Piece) o;
		return p.getSquare().equals(this.square) && p.getTeam().equals(this.team) && p.isAlive() == this.alive;
	}

	@Override
	public String toString() {
		return "Piece [square=" + square + ", alive=" + alive + ", team=" + team + "]";
	}

	/**
	 * Gets the x-axis position of this piece's starting square on the board.
	 * @return The x-axis position of this piece's starting square.
	 * @see Board
	 */
	public int getStartingSquareX() {
		return startingSquareX;
	}

	/**
	 * Sets the x-axis position of this piece's starting square on the board.
	 * @return The x-axis position of this piece's starting square.
	 * @see Board
	 */
	public void setStartingSquareX(int startingSquareX) {
		if (startingSquareX < 0 || startingSquareX > 14)
			throw new IllegalArgumentException();
		this.startingSquareX = startingSquareX;
	}

	/**
	 * Gets the y-axis position of this piece's starting square on the board.
	 * @return The y-axis position of this piece's starting square.
	 * @see Board
	 */
	public int getStartingSquareY() {
		return startingSquareY;
	}

	/**
	 * Sets the y-axis position of this piece's starting square on the board.
	 * @return The y-axis position of this piece's starting square.
	 * @see Board
	 */
	public void setStartingSquareY(int startingSquareY) {
		if (startingSquareY < 0 || startingSquareY > 14)
			throw new IllegalArgumentException();
		this.startingSquareY = startingSquareY;
	}
}
