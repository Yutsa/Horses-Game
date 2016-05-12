package piece;

import java.util.ArrayList;

import board.Square;
import exceptions.PathBlockedException;
import team.Team;

public class Horse extends Piece {

	public Horse(int x, int y, boolean alive, Team team) {
		super(x, y, alive, team);
	}
}
