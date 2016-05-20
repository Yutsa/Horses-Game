package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import board.BasicSquare;
import board.BottomStairway;
import board.Square;
import board.StairwaySquare;
import exceptions.PathBlockedException;
import game.Game;
import game.HorsesGame;
import piece.Piece;

public class GraphicalHorsesGame extends JFrame {
	private HorsesGame game = new HorsesGame(4, 1);
	private BoardPanel boardPanel;
	private MenuPanel menuPanel;

	public GraphicalHorsesGame() {
		game.getTeam(0).getPiece(0).setSquare(game.getBoard().getSquare(6, 7));
		boardPanel = new BoardPanel(this);
		menuPanel = new MenuPanel(this);

		this.setLayout(new BorderLayout());
		this.add(boardPanel, BorderLayout.EAST);
		this.add(menuPanel, BorderLayout.WEST);

		this.setTitle("Jeu des Petits Chevaux");
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public HorsesGame getGame() {
		return game;
	}

	public void setGame(HorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void play(Piece piece) {
		try {
			if (piece.getSquare() instanceof BottomStairway && game.isPiecesStairway(piece)
					|| piece.getSquare() instanceof StairwaySquare)
				game.moveToStairway(piece, game.getDiceResult());
			else {
				game.moveForward(piece, game.getDiceResult());
			}
		} catch (PathBlockedException e) {
			System.out.println("Mouvement impossible");
		}
		
		if (piece.getTeam().getNbPieces() == 0) {
			boardPanel.displayBoard();
			displayWonDialog(piece);
		}
		
		if (game.getDiceResult() != 6) {
			game.nextTeam();
		}
		game.setDiceResult(0);
		boardPanel.displayBoard();
		piece.getTeam().setCanPlay(false);
	}

	public void displayWonDialog(Piece piece) {
		JOptionPane wonDialog = new JOptionPane();
		switch (JOptionPane.showConfirmDialog(this,
				"L'équipe " + piece.getTeam().getColor() + " a gagné ! Rejouer ?", "GAGNÉ", JOptionPane.YES_NO_OPTION)) {
		case JOptionPane.YES_OPTION:
			this.dispose();
			GraphicalHorsesGame game = new GraphicalHorsesGame();
			break;
		case JOptionPane.NO_OPTION:
			this.dispose();
			break;
		}
	}
}
