package board;

import team.Team;

/**
 * HorsePen is the class representing a specific {@link Square} in the
 * Horses game.
 * 
 * @author edouard
 *
 */
public class HorsePen extends Square {

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
	public HorsePen(int posX, int posY, Team team, Board board) {
		super(posX, posY, team, board);
	}

}
