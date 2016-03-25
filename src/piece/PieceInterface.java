package piece;

/**
 * Interface for the piece.
 * @author Édouard WILLISSECK
 */
public interface PieceInterface {
	/**
	 * Gives the x-axis position of the piece.
	 * @return An integer corresponding to the x-axis position of the piece.
	 */
	int getPosX();
	
	/**
	 * Gives the y-axis position of the piece.
	 * @return An integer corresponding to the y-axis position of the piece.
	 */
	int getPosY();
	
	/**
	 * Gives the position of the piece.
	 * @return An array containing the x-axis and the y-axis position of the piece.
	 */
	int getPos();
	
	/**
	 * Moves the piece.
	 */
	void move();
}
