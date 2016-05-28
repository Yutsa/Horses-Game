package piece;

import board.BasicSquare;
import board.BottomStairway;
import board.HorsePen;
import board.StairwaySquare;
import team.Team;

public class Horse extends Piece {

	public Horse(int x, int y, boolean alive, Team team) {
		super(x, y, alive, team);
	}

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
		
		return false;
	}
}
