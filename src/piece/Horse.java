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
package piece;

import board.BasicSquare;
import board.BottomStairway;
import board.HorsePen;
import board.StairwaySquare;
import team.Team;

/**
 * The Horse class represents a Horses in the Horses game.
 * @author edouard
 *
 */
public class Horse extends Piece {

	/**
	 * @param x The x-axis position of the Horse.
	 * @param y The y-axis position of the Horse.
	 * @param alive A boolean to check if the Horse is alive or not.
	 * @param team The team of this Horse.
	 */
	public Horse(int x, int y, boolean alive, Team team) {
		super(x, y, alive, team);
	}

	/**
	 * Checks if this horse can move or not.
	 * @param diceNumber The number gotten from the dice roll.
	 * @return true if this horse can move, false otherwise.
	 */
	public boolean canMove(int diceNumber) {
		if (this.getSquare() instanceof BasicSquare)
			return true;

		if (this.getSquare() instanceof HorsePen) {
			if (diceNumber == 6)
				return true;
			else
				return false;
		}

		if (this.getSquare() instanceof BottomStairway && this.getTeam().equals(this.getSquare().getTeam())) {
			if (diceNumber == 1)
				return true;
			else
				return false;
		}
		
		if (this.getSquare() instanceof StairwaySquare) {
			StairwaySquare square = (StairwaySquare) this.getSquare();
			if (square.getNbStairway() == 6 && diceNumber == 6)
				return true;
			else if (diceNumber == square.getNbStairway() + 1)
				return true;
			else
				return false;
		}
		
		return true;
	}
}
