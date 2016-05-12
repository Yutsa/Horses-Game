package board;

import team.Team;

public class StairwaySquare extends Square{
	private int nbStairway;
	
	public StairwaySquare(int posX, int posY, Team team, Board board, int nbStairway) {
		super(posX, posY, team, board);
		setNbStairway(nbStairway);
	}

	public int getNbStairway() {
		return nbStairway;
	}

	public void setNbStairway(int nbStairway) {
		if (nbStairway < 1 || nbStairway > 6)
			throw new IllegalArgumentException();
		this.nbStairway = nbStairway;
	}
}
