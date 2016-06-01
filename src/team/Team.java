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
package team;

import java.util.ArrayList;

import game.Game;
import piece.Horse;
import piece.Piece;

/**
 * A class representing a team for a board game.
 * 
 * @author Édouard WILLISSECK
 *
 */
public class Team {
	private int color;
	private Game game;
	private ArrayList<Piece> pieces;
	private boolean canPlay;

	/**
	 * Basic constructor.
	 * 
	 * @param color
	 *            An integer representing the color of this team. It must be
	 *            between 1 and the number of Teams for the game.
	 * @param game2
	 *            The Game being played by this Team.
	 */
	public Team(int color, Game game2) {
		setGame(game2);
		setColor(color);
		setCanPlay(false);
		pieces = new ArrayList<Piece>();
	}

	public Piece createPieces(int x, int y, boolean alive, Team team) {
		return new Horse(x, y, alive, team);
	}

	/**
	 * Gets the game being played by this team.
	 * 
	 * @return The game being played by this Team.
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Sets the game being played.
	 * 
	 * @param game
	 *            The game being played.
	 */
	public void setGame(Game game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	/**
	 * Gets the color of this team.
	 * 
	 * @return The color of this team.
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Sets the color of this team.
	 * 
	 * @param color
	 *            The color of this team.
	 */
	public void setColor(int color) {
		if (color < 1 || color > game.getNbTeam()) {
			throw new IllegalArgumentException("Couleur invalide.");
		}
		this.color = color;
	}

	/**
	 * Gets the Team's i piece.
	 * 
	 * @param i
	 *            The index of the piece to get.
	 * @return The piece at index i
	 */
	public Piece getPiece(int i) {
		if (i < 0 || i > pieces.size())
			throw new IllegalArgumentException();
		return pieces.get(i);
	}

	/**
	 * Adds a piece to this Team's pieces.
	 * 
	 * @param p
	 *            The Piece to add.
	 */
	public void addPiece(Piece p) {
		if (p == null)
			throw new IllegalArgumentException();
		pieces.add(p);
	}

	/**
	 * Removes a Piece from this Team's pieces.
	 * 
	 * @param p
	 *            The Piece to remove.
	 */
	public void removePiece(Piece p) {
		if (p == null)
			throw new IllegalArgumentException();
		if (!pieces.contains(p))
			throw new IllegalArgumentException();
		pieces.remove(p);
	}

	/**
	 * Gets the number of pieces from this team.
	 * 
	 * @return The number of pieces from this team.
	 */
	public int getNbPieces() {
		return pieces.size();
	}

	/**
	 * Says if this Team still has pieces left or not.
	 * 
	 * @return A boolean, true if this Team still has pieces, false otherwise.
	 */
	public boolean hasPiecesLeft() {
		return getNbPieces() != 0;
	}

	// TODO: Check if a piece is playable bot blocked by another piece.
	/**
	 * Says if this team can play or not.
	 * 
	 * @return True is this team can play, false otherwise.
	 */
	public boolean canPlay() {
		return this.canPlay;
	}

	/**
	 * Checks if one of this team's piece can move.
	 * 
	 * @param diceNumber
	 *            The result of the dice roll
	 * @return true if a piece can move, false otherwise
	 * @see Dice
	 */
	public boolean canMove(int diceNumber) {
		for (Piece piece : pieces) {
			Horse horse = (Horse) piece;
			if (horse.canMove(diceNumber))
				return true;
		}
		return false;
	}

	/**
	 * Sets the canPlay boolean
	 * 
	 * @param b
	 *            A boolean to say if this team can play or not.
	 */
	public void setCanPlay(boolean b) {
		this.canPlay = b;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Team))
			return false;
		Team t = (Team) o;
		return t.getColor() == this.getColor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Team [color=" + color + "]";
	}

}
