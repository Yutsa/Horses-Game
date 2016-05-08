package board;

import piece.Piece;
import team.Team;

//TODO: Finish the javadoc.
//TODO: Check the paramater when setting the pos (must be within board height and width)
public abstract class Square {
	private int posX;
	private int poxY;
	private Team team;
	private Piece pieceOnSquare;
	private Board board;

	/**
	 * Get the board the Square is linked to.
	 * 
	 * @return The Board the Square is linked to.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set the board the Square is linked to.
	 * 
	 * @param board
	 *            The Board the Square is linked to.
	 */
	public void setBoard(Board board) {
		if (board == null)
			throw new IllegalArgumentException();
		this.board = board;
	}

	/**
	 * Set a Piece on the Square.
	 * 
	 * @param piece
	 *            The Piece to put on the Square.
	 */
	public void setPieceOnSquare(Piece piece) {
		if (piece == null)
			throw new IllegalArgumentException();
		pieceOnSquare = piece;
	}

	/**
	 * Get the Piece that is on the Square.
	 * 
	 * @return The Piece that is on the Square.
	 */
	public Piece getPieceOnSquare() {
		return pieceOnSquare;
	}

	/**
	 *
	 * @return
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return
	 */
	public int getPoxY() {
		return poxY;
	}

	/**
	 * @param poxY
	 */
	public void setPoxY(int poxY) {
		this.poxY = poxY;
	}

	/**
	 * @return
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team
	 */
	public void setTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException("Paramètre null.");
		this.team = team;
	}

	@Override
	public String toString() {
		return "Square [posX=" + posX + ", poxY=" + poxY + ", team=" + team + "isEmpty=" + this.isEmpty() + "]";
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
		if (poxY != other.poxY)
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return this.pieceOnSquare == null;
	}

}
