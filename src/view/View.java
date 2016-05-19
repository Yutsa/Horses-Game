package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import board.BasicSquare;
import board.Square;
import game.Game;
import game.HorsesGame;

public class View extends JFrame{
	private HorsesGame game;
	private BoardPanel boardPanel;
	private MenuPanel menuPanel;
	
	public View(HorsesGame game) {
		setGame(game);
		boardPanel = new BoardPanel(game);
		menuPanel = new MenuPanel(game, boardPanel);
		
		this.setLayout(new BorderLayout());
		this.add(boardPanel, BorderLayout.EAST);
		this.add(menuPanel, BorderLayout.WEST);
		
		this.setTitle("Jeu des Petits Chevaux");
		this.setVisible(true);
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
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
	
	
}
