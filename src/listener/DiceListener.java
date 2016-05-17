package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import board.BottomStairway;
import dice.Dice;
import exceptions.PathBlockedException;
import game.Game;
import game.HorsesGame;
import piece.Piece;
import view.BoardPanel;

public class DiceListener implements ActionListener {
	Dice dice;
	JLabel label;
	HorsesGame game;
	BoardPanel boardPanel;

	public DiceListener(JLabel label, HorsesGame game, BoardPanel boardPanel) {
		// TODO Auto-generated constructor stub
		setGame(game);
		setDice(this.game.getDice());
		setLabel(label);
		setBoardPanel(boardPanel);
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void setBoardPanel(BoardPanel boardPanel) {
		if (boardPanel == null)
			throw new IllegalArgumentException();
		this.boardPanel = boardPanel;
	}

	public void setGame(HorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		if (dice == null)
			throw new IllegalArgumentException();
		this.dice = dice;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		if (label == null)
			throw new IllegalArgumentException();
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Piece p = game.getTeam(0).getPiece(2);
		this.label.setText("" + dice.roll());
		try {
			if (p.getSquare() instanceof BottomStairway && game.isPiecesStairway(p))
				game.moveToStairway(p, 1);
			else {
				game.moveForward(p, 6);
			}
		} catch (PathBlockedException e) {
			System.out.println("Mouvement impossible");
		}
		boardPanel.displayBoard();
	}
}
