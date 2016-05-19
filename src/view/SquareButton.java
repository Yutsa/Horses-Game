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

public class SquareButton extends JButton implements ActionListener {
	private Square square;
	private HorsesGame game;
	private BoardPanel boardPanel;

	public SquareButton(Square square, ImageIcon img, HorsesGame game2, BoardPanel boardPanel) {
		super(img);
		setBoardPanel(boardPanel);
		setSquare(square);
		setGame(game2);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.addActionListener(this);
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

	public HorsesGame getGame() {
		return game;
	}

	public void setGame(HorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!square.isEmpty() && game.getDiceResult() != 0 && square.getPieceOnSquare().getTeam().equals(game.getCurrentTeam())) {
			Piece p = square.getPieceOnSquare();
			game.play(p);
		}
	}
}
