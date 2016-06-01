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
