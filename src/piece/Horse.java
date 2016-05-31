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
