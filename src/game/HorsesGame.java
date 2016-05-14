package game;

import board.BasicSquare;
import board.Board;
import board.BoardHorses;
import board.BottomStairway;
import board.HorsePen;
import board.Square;
import board.StairwaySquare;
import exceptions.PathBlockedException;
import piece.Horse;
import piece.Piece;
import team.Team;

public class HorsesGame extends Game {
	public HorsesGame(int nbTeam, int nbPiece) {
		super(4, 4);
		setBoard(new BoardHorses(this));
		addPiecesToTeams();
	}

	public void addPiecesToTeams() {
		for (Team t : getTeams()) {
			if (t.getColor() == 1) {
				for (int i = 0; i < getNbPieces(); i++) {
					t.addPiece(createPieces(i, 0, true, t));
				}
			} else if (t.getColor() == 2) {
				for (int i = 9; i < 9 + getNbPieces(); i++) {
					t.addPiece(createPieces(i, 0, true, t));
				}
			} else if (t.getColor() == 3) {
				for (int i = 0; i < getNbPieces(); i++) {
					t.addPiece(createPieces(i, 14, true, t));
				}
			} else {
				for (int i = 9; i < 9 + getNbPieces(); i++) {
					t.addPiece(createPieces(i, 14, true, t));
				}
			}
		}
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
	 * Move a {@link Piece}forward. If the piece is in a HorsePen move the Piece
	 * using {@link moveFromHorsePen}.
	 * 
	 * @param piece
	 * @param nbDeplacement
	 * @param moveStairway
	 * @throws PathBlockedException
	 */
	public void moveForward(Piece piece, int nbDeplacement) throws PathBlockedException {
		if (nbDeplacement <= 0)
			return;

		Square pieceSquare = piece.getSquare();
		Board board = piece.getSquare().getBoard();

		if (pieceSquare instanceof HorsePen && nbDeplacement == 6) {
			switch (piece.getTeam().getColor()) {
			case 1:
				moveFromHorsePen(piece, pieceSquare, board.getSquare(0, 6));
				break;
			case 2:
				moveFromHorsePen(piece, pieceSquare, board.getSquare(8, 0));
				break;
			case 3:
				moveFromHorsePen(piece, pieceSquare, board.getSquare(6, 14));
				break;
			case 4:
				moveFromHorsePen(piece, pieceSquare, board.getSquare(14, 8));
				break;
			}
		}

		else if (pieceSquare instanceof BottomStairway && nbDeplacement > 0
				&& pieceSquare.getTeam().equals(piece.getTeam())) {
			piece.setSquare(getPreviousSquare(pieceSquare));
			pieceSquare.setPieceOnSquare(null);
			moveBackward(piece, --nbDeplacement);
		}

		else if (pieceSquare instanceof BasicSquare
				|| (pieceSquare instanceof BottomStairway && !pieceSquare.getTeam().equals(piece.getTeam()))) {
			Square nextSquare = getNextSquare(pieceSquare);
			if (!nextSquare.isEmpty()) {
				if (nbDeplacement == 1)
					killPiece(piece, nextSquare.getPieceOnSquare());
				else
					throw new PathBlockedException();
			} else {
				pieceSquare.setPieceOnSquare(null);
				piece.setSquare(nextSquare);
				moveForward(piece, --nbDeplacement);
			}
		}

	}

	/**
	 * Move a {@link Piece} from its {@link HorsePen}. If a enemy {@link Piece}
	 * is on the startSquare it kills it. If one of your Team's Piece is on the
	 * startSquare it throws a {@link PathBlockedException}.
	 *
	 * @param piece
	 * @param pieceSquare
	 * @param startSquare
	 * @throws PathBlockedException
	 */
	public void moveFromHorsePen(Piece piece, Square pieceSquare, Square startSquare) throws PathBlockedException {
		Piece pieceBlocking = startSquare.getPieceOnSquare();

		if (!startSquare.isEmpty()) {

			if (pieceBlocking.getTeam().equals(piece.getTeam()))
				throw new PathBlockedException();
			else {
				killPiece(piece, startSquare.getPieceOnSquare());
			}
		} else {
			piece.getSquare().setPieceOnSquare(null);
			piece.setSquare(startSquare);

		}
	}

	// TODO: Implement moveBackward
	public void moveBackward(Piece piece, int nbDeplacement) throws PathBlockedException {
		if (nbDeplacement <= 0)
			return;

		Square pieceSquare = piece.getSquare();
		Board board = piece.getSquare().getBoard();
		Square previousSquare = getPreviousSquare(pieceSquare);

		if (!previousSquare.isEmpty()) {
			if (nbDeplacement == 1) {
				killPiece(piece, previousSquare.getPieceOnSquare());
			}
			else {
				throw new PathBlockedException();
			}
		} else {
			pieceSquare.setPieceOnSquare(null);
			piece.setSquare(previousSquare);
			moveBackward(piece, --nbDeplacement);
		}
		
	}

	/**
	 * Move the {@link Piece} to the {@link StairwaySquare}. Checks if the
	 * movement is authorized.
	 * 
	 * @param piece
	 * @param nbDeplacement
	 */
	public void moveToStairway(Piece piece, int nbDeplacement) {

	}

	/**
	 * Kills a {@link Piece}. The killer Piece takes it place and the killed
	 * Piece goes back to its startingSquare.
	 * 
	 * @param killer
	 * @param killed
	 */
	public void killPiece(Piece killer, Piece killed) {
		// TODO Implement killPiece
	}

	public Horse createPieces(int x, int y, boolean alive, Team team) {
		return new Horse(x, y, alive, team);
	}

	// TODO: Implement runGame()
	@Override
	public void runGame() {

	}

	public static void test() {
		HorsesGame game = new HorsesGame(4, 4);
		System.out.println(game.getBoard().toString());
		Piece p = game.getTeam(0).getPiece(1);
		for (int i = 0; i < 10; i++) {

			try {
				game.moveForward(p, 6);
			} catch (PathBlockedException e) {
				System.out.println("Mouvement impossible");
			}
			System.out.println(game.getBoard().toString());
		}
		try {
			game.moveForward(p, 3);
		} catch (PathBlockedException e) {
			System.out.println("Mouvement impossible");
		}
		System.out.println(game.getBoard().toString());
	}
}
