package game;

import board.Square;

//TODO: Implement Game
//TODO: Implement the Movement System.
public class HorsesGame extends Game {
	public HorsesGame(int nbTeam, int nbPiece) {
		super(4, 4);
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	public Square getNextSquare(Square A) {
		int coordX = A.getPosX(), coordY = A.getPosY();
		if (coordX == 6) {
			if (coordY == 0) {
				coordX++;
			} else if (coordY == 8) {
				coordX--;
			} else {
				coordY--;
			}
		} else if (coordX == 8) {
			if (coordY == 6) {
				coordX++;
			} else if (coordY == 14) {
				coordX--;
			} else {
				coordY++;
			}
		} else if (coordY == 6) {
			if (coordX == 6) {
				coordY--;
			} else if (coordX == 14) {
				coordY++;
			} else {
				coordX++;
			}
		} else if (coordY == 8) {
			if (coordX == 0) {
				coordY--;
			} else if (coordX == 8) {
				coordY++;
			} else {
				coordX--;
			}
		} else {
			if (coordY == 0)
				coordX++;
			if (coordY == 14)
				coordX--;
			if (coordX == 0)
				coordY--;
			if (coordX == 14)
				coordY++;
		}
		return getBoard().getSquare(coordX, coordY);
	}

	/**
	 * @param A
	 * @return
	 */
	Square getPreviousSquare(Square A) {
		int coordX = A.getPosX(), coordY = A.getPosY();
		if (coordX == 6) {
			if (coordY == 6) {
				coordX--;
			} else if (coordY == 14) {
				coordX++;
			} else {
				coordY++;
			}
		} else if (coordX == 8) {
			if (coordY == 0) {
				coordX--;
			} else if (coordY == 8) {
				coordX++;
			} else {
				coordY--;
			}
		} else if (coordY == 6) {
			if (coordX == 0) {
				coordY++;
			} else if (coordX == 8) {
				coordY--;
			} else {
				coordX--;
			}
		} else if (coordY == 8) {
			if (coordX == 6) {
				coordY++;
			} else if (coordX == 14) {
				coordY--;
			} else {
				coordX++;
			}
		} else {
			if (coordY == 0)
				coordX--;
			if (coordY == 14)
				coordX++;
			if (coordX == 0)
				coordY++;
			if (coordX == 14)
				coordY--;
		}
		return getBoard().getSquare(coordX, coordY);
	}
}
