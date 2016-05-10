package piece;

import board.Square;
import exceptions.PathBlockedException;
import team.Team;

//TODO: Implement Horse.
public class Horse extends Piece {
	public Horse(boolean alive, Team team, Square square)
	{
		setAlive(alive);
		setTeam(team);
		setSquare(square);
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
