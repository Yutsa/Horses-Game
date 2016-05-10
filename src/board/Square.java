package board;

import piece.Piece;
import team.Team;

public abstract class Square {
	private int posX;
	private int posY;
	private Team team;
	private Piece pieceOnSquare;
	private Board board;

	
	public Square(int posX, int posY, Team team, Board board) {
		setPosX(posX);
		setPosY(posY);
		setTeam(team);
		setBoard(board);
		
	}
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
	 * Get the x-axis position of the Square on the Board.
	 * 
	 * @return An integer representing the x-axis position of the Square on the
	 *         Board.
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Set the x-axis position of the Square on the Board.
	 * 
	 * @param posX
	 *            An integer representing the x-axis position of the Square on
	 *            the Board.
	 */
	public void setPosX(int posX) {
		if (posX < 0 || posX > board.getWidth())
			throw new IllegalArgumentException();
		this.posX = posX;
	}

	/**
	 * Get the y-axis position of the Square.
	 * 
	 * @return An integer representing the y-axis position of the Square.
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Set the y-axis position of the Square.
	 * 
	 * @return An integer representing the y-axis position of the Square.
	 */
	public void setPosY(int posY) {
		if (posY < 0 || posY > board.getHeight())
			throw new IllegalArgumentException();
		this.posY = posY;
	}

	/**
	 * Get the Square's Team.
	 * 
	 * @return The Square's Team.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Set the Square's Team.
	 * 
	 * @param team
	 *            The Square's Team.
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
	 * Check if the Square is empty.
	 * 
	 * @return True if the Square is empty, False otherwise.
	 */
	public boolean isEmpty() {
		return this.pieceOnSquare == null;
	}

}
