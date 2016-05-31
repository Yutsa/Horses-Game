package board;

import piece.Piece;
import team.Team;

/**
 * Square is the class representing a Square in a board game.
 * 
 * @author edouard
 *
 */
public abstract class Square {
	private int posX;
	private int posY;
	private Team team;
	private Piece pieceOnSquare;
	private Board board;

	/**
	 * @param posX
	 *            The x-axis position of the square.
	 * @param posY
	 *            The y-axis position of the square.
	 * @param team
	 *            The {@link Team} of the square
	 * @param board
	 *            The {@link Board} the square is on.
	 */
	public Square(int posX, int posY, Team team, Board board) {
		setBoard(board);
		setPosX(posX);
		setPosY(posY);
		setTeam(team);
	}

	/**
	 * Gets the board this Square is linked to.
	 * 
	 * @return The Board this Square is linked to.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Sets the board this Square is linked to.
	 * 
	 * @param board
	 *            The {@link Board} this Square is linked to.
	 * 
	 * @see Board
	 */
	public void setBoard(Board board) {
		if (board == null)
			throw new IllegalArgumentException();
		this.board = board;
	}

	/**
	 * Puts a Piece on this Square.
	 * 
	 * @param piece
	 *            The Piece to put on this Square.
	 * @see Piece
	 */
	public void setPieceOnSquare(Piece piece) {
		pieceOnSquare = piece;
	}

	/**
	 * Gets the Piece that is on this Square.
	 * 
	 * @return The Piece that is on this Square or null if there aren't any.
	 */
	public Piece getPieceOnSquare() {
		return pieceOnSquare;
	}

	/**
	 * Gets the x-axis position of this Square on the Board.
	 * 
	 * @return An integer representing the x-axis position of this Square on the
	 *         Board.
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Sets the x-axis position of this Square on the Board.
	 * 
	 * @param posX
	 *            An integer representing the x-axis position of this Square on
	 *            the Board.
	 */
	public void setPosX(int posX) {
		if (posX < 0 || posX > board.getWidth())
			throw new IllegalArgumentException();
		this.posX = posX;
	}

	/**
	 * Gets the y-axis position of this Square.
	 * 
	 * @return An integer representing the y-axis position of this Square.
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Sets the y-axis position of this Square.
	 * 
	 * @return An integer representing the y-axis position of this Square.
	 */
	public void setPosY(int posY) {
		if (posY < 0 || posY > board.getHeight())
			throw new IllegalArgumentException();
		this.posY = posY;
	}

	/**
	 * Gets the Square's {@link Team}.
	 * 
	 * @return The Square's {@link Team}.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Set the Square's Team.
	 * 
	 * @param team
	 *            The Square's Team.
	 * @see Team
	 */
	public void setTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException("Paramètre null.");
		this.team = team;
	}

	@Override
	public String toString() {
		return "Square [posX=" + posX + ", poxY=" + posY + ", team=" + team + "isEmpty=" + this.isEmpty() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

	/**
	 * Check if this Square is empty. That is if he doesn't have a piece on it.
	 * 
	 * @return True if the Square is empty, False otherwise.
	 */
	public boolean isEmpty() {
		return this.pieceOnSquare == null;
	}

}
