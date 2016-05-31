package board;

import team.Team;

/**
 * StairaySquare is the class representing a specific {@link Square} in a game of horses.
 * @author edouard
 *
 */
public class StairwaySquare extends Square{
	private int nbStairway;
	
	
	/**
	 * @param posX An integer representing the x-axis of this square.
	 * @param posY An integer representing the y-axis of this square.
	 * @param team This square's {@link Team}
	 * @param board This square's {@link Board}
	 * @param nbStairway The number of this StairwaySquare.
	 * @see Team
	 * @see Board
	 */
	public StairwaySquare(int posX, int posY, Team team, Board board, int nbStairway) {
		super(posX, posY, team, board);
		setNbStairway(nbStairway);
	}

	/**
	 * Gets the number of this stairway. It is needed for the movement of the Horses.
	 * @return The number of this stairway.
	 */
	public int getNbStairway() {
		return nbStairway;
	}

	/**
	 * Sets the number of this stairway.
	 * @param nbStairway An integer between 1 and 6 that will be this stairway's number.
	 */
	public void setNbStairway(int nbStairway) {
		if (nbStairway < 1 || nbStairway > 6)
			throw new IllegalArgumentException();
		this.nbStairway = nbStairway;
	}
}
