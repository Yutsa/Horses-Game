package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import board.BottomStairway;
import board.Square;
import board.StairwaySquare;
import exceptions.PathBlockedException;
import game.HorsesGame;
import piece.Piece;

public class SquareButton extends JButton {
	private Square square;
	private GraphicalHorsesGame graphicalHorsesGame;
	private BoardPanel boardPanel;

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
