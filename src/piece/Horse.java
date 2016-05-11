package piece;

import java.util.ArrayList;

import board.Square;
import exceptions.PathBlockedException;
import team.Team;

//TODO: Implement Horse.
public class Horse extends Piece {
	private ArrayList<int[]> pathTeam1;

	public Horse(boolean alive, Team team, Square square) {
		super(square, alive, team);
	}

	public void createPath() {
		int[] coord = new int[2];
	}
	
	// If a horse has to go back to the horsepen, use getEmptyHorsePenCoord(Team
	// team).


}
