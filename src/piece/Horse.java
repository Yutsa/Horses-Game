package piece;

import java.util.ArrayList;

import board.Square;
import exceptions.PathBlockedException;
import team.Team;

//TODO: Implement Horse.
public class Horse extends Piece {

	public Horse(boolean alive, Team team, Square square) {
		super(0, 0, alive, team);
	}
	
	@Override
	public void move() throws PathBlockedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void killPiece() {
		// TODO Auto-generated method stub

	}
}
