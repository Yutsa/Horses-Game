package game;

import board.Board;
import board.BoardHorses;
import board.BottomStairway;
import board.HorsePen;
import board.Square;
import exceptions.PathBlockedException;
import piece.Piece;
import sun.reflect.generics.tree.BottomSignature;
import team.Team;

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
	 * 
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
	 * 
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

	// TODO: Implement moveForward
	/**
	 * Move a {@link Piece}forward. If the piece is in a HorsePen move the Piece to its starting Square.
	 * If another Piece is already on it, check its team and either kill him if it's from another Team
	 * or throw a {@link PathBlockedException} if it's from the Piece's {@link Team}
	 * @param piece
	 * @param nbDeplacement
	 * @param moveStairway
	 * @throws PathBlockedException
	 */
	public void moveForward(Piece piece, int nbDeplacement, boolean moveStairway) throws PathBlockedException {
		if (nbDeplacement <= 0)
			return;

		Square pieceSquare = piece.getSquare();
		Board board = piece.getSquare().getBoard();
		Square startSquare = null;
		Piece pieceBlocking = null;

		if (pieceSquare instanceof HorsePen) {
			switch (piece.getTeam().getColor()) {
			case 1:
				startSquare = board.getSquare(0, 6);
				pieceBlocking = startSquare.getPieceOnSquare();
				
				if (!startSquare.isEmpty()) {
					if (pieceBlocking.getTeam().equals(piece.getTeam()))
						throw new PathBlockedException();
					else {
						killPiece(piece, startSquare.getPieceOnSquare());
					}
				}
				piece.setSquare(startSquare);
				pieceSquare.setPieceOnSquare(null);
				moveForward(piece, nbDeplacement--, false);
				break;
			case 2:
				startSquare = board.getSquare(8, 0);
				pieceBlocking = startSquare.getPieceOnSquare();
				
				if (!startSquare.isEmpty()) {
					if (pieceBlocking.getTeam().equals(piece.getTeam()))
						throw new PathBlockedException();
					else {
						killPiece(piece, startSquare.getPieceOnSquare());
					}
				}
				piece.setSquare(board.getSquare(8, 0));
				pieceSquare.setPieceOnSquare(null);
				moveForward(piece, nbDeplacement--, false);
				break;
			case 3:
				startSquare = board.getSquare(6, 14);
				pieceBlocking = startSquare.getPieceOnSquare();
				
				if (!startSquare.isEmpty()) {
					if (pieceBlocking.getTeam().equals(piece.getTeam()))
						throw new PathBlockedException();
					else {
						killPiece(piece, startSquare.getPieceOnSquare());
					}
				}
				piece.setSquare(board.getSquare(6, 14));
				pieceSquare.setPieceOnSquare(null);
				moveForward(piece, nbDeplacement--, false);
				break;
			case 4:
				startSquare = board.getSquare(14, 8);
				pieceBlocking = startSquare.getPieceOnSquare();
				
				if (!startSquare.isEmpty()) {
					if (pieceBlocking.getTeam().equals(piece.getTeam()))
						throw new PathBlockedException();
					else {
						killPiece(piece, startSquare.getPieceOnSquare());
					}
				}
				
				piece.setSquare(board.getSquare(14, 8));
				pieceSquare.setPieceOnSquare(null);
				moveForward(piece, nbDeplacement--, false);
				break;
			}
		}

		if (pieceSquare instanceof BottomStairway && nbDeplacement > 0 && !moveStairway) {
			piece.setSquare(getPreviousSquare(pieceSquare));
			pieceSquare.setPieceOnSquare(null);
			moveBackward(piece, nbDeplacement--);
		}

	}

	// TODO: Implement moveBackward
	public void moveBackward(Piece piece, int nbDeplacement) {

	}

	public void killPiece(Piece killer, Piece killed) {
		// TODO Implement killPiece
	}

	// TODO: Implement runGame()
	@Override
	public void runGame() {

	}
}
