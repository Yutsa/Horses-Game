package board;

import team.Team;

/**
 * BasicSquare is the class representing a basic square in the horses game.
 * 
 * @author Édouard WILLISSECK and Rémy LADIESSE
 *
 */
public class BasicSquare extends Square {
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
	public BasicSquare(int posX, int posY, Team team, Board board) {
		super(posX, posY, team, board);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof BasicSquare))
			return false;
		BasicSquare other = (BasicSquare) o;
		return other.getPosX() == this.getPosX() && other.getPosY() == this.getPosY();
	}
}
