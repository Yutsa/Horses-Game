package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import board.Square;
import piece.Piece;

/**
 * The SquareButton class is the representation of the squares in a graphical window.
 * @author edouard
 *
 */
public class SquareButton extends JButton {
	private static final long serialVersionUID = 7337170632597842160L;
	private Square square;
	private GraphicalHorsesGame graphicalHorsesGame;
	private BoardPanel boardPanel;

	/**
	 * @param square The square represented by this SquareButton
	 * @param img The image to display on this SquareButton
	 * @param game The game owning this SquareButton
	 * @param boardPanel The BoardPanel of the game.
	 */
	public SquareButton(Square square, ImageIcon img, GraphicalHorsesGame game, BoardPanel boardPanel) {
		super(img);
		setBoardPanel(boardPanel);
		setSquare(square);
		setGraphicalHorsesGame(game);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.addActionListener(new GraphicalSquareListener());
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void setBoardPanel(BoardPanel boardPanel) {
		if (boardPanel == null)
			throw new IllegalArgumentException();
		this.boardPanel = boardPanel;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		if (square == null)
			throw new IllegalArgumentException();
		this.square = square;
	}

	public GraphicalHorsesGame getGraphicalHorsesGame() {
		return graphicalHorsesGame;
	}

	public void setGraphicalHorsesGame(GraphicalHorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.graphicalHorsesGame = game;
	}

	public class GraphicalSquareListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!square.isEmpty() && graphicalHorsesGame.getGame().getDiceResult() != 0
					&& square.getPieceOnSquare().getTeam().equals(graphicalHorsesGame.getGame().getCurrentTeam())) {
				Piece p = square.getPieceOnSquare();
				graphicalHorsesGame.play(p);
			}
		}
	}
}
