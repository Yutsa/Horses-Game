package game;

import board.Board;
import board.BoardHorses;
import board.BottomStairway;
import board.HorsePen;
import board.Square;
import exceptions.PathBlockedException;
import piece.Piece;
import sun.reflect.generics.tree.BottomSignature;

public class HorsesGame extends Game {
	public HorsesGame(int nbTeam, int nbPiece) {
		super(4, 4);
		setBoard(new BoardHorses(this));
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	/**
	 * Return the next Square, excluding the horsepen.
	 * @param A
	 * @return
	 */
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
	 * Returns the previous Square not including the horspen.
	 * @param A
	 * @return
	 */
	public Square getPreviousSquare(Square A) {
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

	//TODO: Implement moveForward
	public void moveForward(Piece piece, int nbDeplacement, boolean moveStairway) throws PathBlockedException {
		if (nbDeplacement <= 0)
			return;
		Square pieceSquare = piece.getSquare();
		int posX = pieceSquare.getPosX();
		int posY = pieceSquare.getPosY();
		Board board = piece.getSquare().getBoard();
		if (pieceSquare instanceof HorsePen) {
			switch (piece.getTeam().getColor()) {
			case 1:
				piece.setSquare(board.getSquare(0, 6));
				nbDeplacement--;
				moveForward(piece, nbDeplacement, false);
				break;
			case 2:
				piece.setSquare(board.getSquare(8, 0));
				nbDeplacement--;
				moveForward(piece, nbDeplacement, false);
				break;
			case 3:
				piece.setSquare(board.getSquare(6, 14));
				nbDeplacement--;
				moveForward(piece, nbDeplacement, false);
				break;
			case 4:
				piece.setSquare(board.getSquare(14, 8));
				nbDeplacement--;
				moveForward(piece, nbDeplacement, false);
				break;
			}
		}
		
		if (pieceSquare instanceof BottomStairway && nbDeplacement > 0 && !moveStairway) {
			piece.setSquare(getPreviousSquare(pieceSquare));
			moveBackward(piece, nbDeplacement--);
		}
		
		
	}
	
	//TODO: Implement moveBackward
	public void moveBackward(Piece piece, int nbDeplacement) {
		
	}

	public void killPiece() {
		// TODO Implement killPiece
	}

	//TODO: Implement runGame()
	@Override
	public void runGame() {
		
	}
}
