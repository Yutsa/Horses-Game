package piece;

import board.HorsePen;
import board.Square;
import board.StairwaySquare;
import exceptions.PathBlockedException;
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

	
	public Piece(int x, int y, boolean alive, Team team) {
		setSquare(square);
		setAlive(alive);
		setTeam(team);
	}
	
	/**
	 * Moves the piece.
	 * 
	 * @throws PathBlockedException
	 *             Exception indicating that another piece is blocking the way.
	 */
	public abstract void move() throws PathBlockedException;

	/**
	 * Method to kill another piece.
	 */
	public abstract void killPiece();

	/**
	 * Get the square the piece is on.
	 * 
	 * @return The Square the piece is on.
	 */
	public Square getSquare() {
		return square;
	}

	/**
	 * Set the square the piece is on.
	 * 
	 * @param square
	 *            The Square the piece is on.
	 */
	public void setSquare(Square square) {
		if (square == null) {
			throw new IllegalArgumentException("Paramètre null.");
		}
		if ((square instanceof HorsePen || square instanceof StairwaySquare) && !square.getTeam().equals(this.team)) {
			throw new IllegalArgumentException("Case d'une autre équipe.");
		}
		this.square = square;
	}

	/**
	 * Get the living status of the piece.
	 * 
	 * @return A boolean showing whether the piece is alive or not.
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Set the living status of the Piece.
	 * 
	 * @param alive A boolean representing whether or not the cell is alive.
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Get the team of the Piece.
	 * 
	 * @return The Team of the Piece.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Set the team of the Piece
	 * 
	 * @param team the Team of the Piece.
	 */
	public void setTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException("Paramètre null.");
		this.team = team;
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

	// WARNING: Careful when implementing Square's toString method to avoid a
	// infinte
	// recursive call to each toString method.
	@Override
	public String toString() {
		return "Piece [square=" + square + ", alive=" + alive + ", team=" + team + "]";
	}

}
