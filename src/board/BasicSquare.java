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
