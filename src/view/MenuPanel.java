package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.BottomStairway;
import board.StairwaySquare;
import dice.Dice;
import exceptions.PathBlockedException;
import game.HorsesGame;
import piece.Piece;

public class MenuPanel extends JPanel {
	private HorsesGame game;
	private BoardPanel boardPanel;
	Dice dice = new Dice(1, 6);
	private JLabel diceResult;
	private JLabel teamLabel;
	
	public MenuPanel(HorsesGame game, BoardPanel boardPanel) {
		super();
		setGame(game);
		setBoardPanel(boardPanel);
		
		
		JLabel label = new JLabel("MENU");
		JButton diceButton = new JButton("Lancer Dédé");
		diceResult = new JLabel();
		teamLabel = new JLabel("Au tour de l'équipe 1.");
		DiceListener diceListener = new DiceListener();
		
		diceButton.addActionListener(diceListener);
		this.setLayout(new GridLayout(4, 1));
		
		this.add(label);
		this.add(teamLabel);
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


	public HorsesGame getGame() {
		return game;
	}
	public void setGame(HorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}
	
	public class DiceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int curr = game.getCurrentTeamNb();
			teamLabel.setText("Au tour de l'équipe " + curr);
			game.setDiceResult(dice.roll());
			diceResult.setText("Résultat du dé: " + game.getDiceResult());
			
//			Piece p = game.getTeam(curr).getPiece(2);
//			diceResult.setText("Résultat du dé: " + game.getDiceResult());
//			
//			try {
//				if (p.getSquare() instanceof BottomStairway && game.isPiecesStairway(p) || p.getSquare() instanceof StairwaySquare)
//					game.moveToStairway(p, game.getDiceResult());
//				else {
//					game.moveForward(p, game.getDiceResult());
//				}
//			} catch (PathBlockedException e) {
//				System.out.println("Mouvement impossible");
//			}
//			boardPanel.displayBoard();
		}
	}

	
}
