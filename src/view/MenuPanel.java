package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.HorsesGame;
import listener.DiceListener;

public class MenuPanel extends JPanel {
	private Game game;
	private BoardPanel boardPanel;
	
	public MenuPanel(Game game, BoardPanel boardPanel) {
		super();
		setGame(game);
		setBoardPanel(boardPanel);
		
		
		HorsesGame hGame = (HorsesGame) game;
		JLabel label = new JLabel("MENU");
		JButton diceButton = new JButton("Lancer Dédé");
		JLabel diceResult = new JLabel();
		DiceListener diceListener = new DiceListener(diceResult, hGame, boardPanel);
		
		diceButton.addActionListener(diceListener);
		this.setLayout(new GridLayout(3, 1));
		
		this.add(label);
		this.add(diceButton);
		this.add(diceResult);
		
		
	}
	
	
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}


	public void setBoardPanel(BoardPanel boardPanel) {
		if (boardPanel == null)
			throw new IllegalArgumentException();
		this.boardPanel = boardPanel;
	}


	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}
	
	
}
