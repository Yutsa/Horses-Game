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
import team.Team;

public class MenuPanel extends JPanel {
	private GraphicalHorsesGame game;
	private BoardPanel boardPanel;
	Dice dice = new Dice(1, 6);
	private JLabel diceResult;
	private JLabel teamLabel;
	
	public MenuPanel(GraphicalHorsesGame game) {
		super();
		setGame(game);
		setBoardPanel(game.getBoardPanel());
		
		
		JLabel label = new JLabel("MENU");
		JButton diceButton = new JButton("Lancer Dédé");
		diceResult = new JLabel();
		teamLabel = new JLabel("Au tour de l'équipe 0.");
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


	public GraphicalHorsesGame getGame() {
		return game;
	}
	public void setGame(GraphicalHorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}
	
	public class DiceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Team team = game.getGame().getCurrentTeam();
			int curr = game.getGame().getCurrentTeamNb();
			teamLabel.setText("Au tour de l'équipe " + (curr + 1));
			
			if (!team.canPlay()) {
				game.getGame().setDiceResult(dice.roll());
				diceResult.setText("Résultat du dé: " + game.getGame().getDiceResult());
				
				if (!team.canMove(game.getGame().getDiceResult())) {
					game.getGame().setDiceResult(0);
					game.getGame().nextTeam();
				}
				else
					team.setCanPlay(true);
			}
		}
	}

	
}
