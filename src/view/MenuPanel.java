package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dice.Dice;
import team.Team;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8402937111338612971L;
	private GraphicalHorsesGame game;
	private BoardPanel boardPanel;
	private Dice dice = new Dice(1, 6);
	private JLabel diceResult;
	private JLabel teamLabel;
	private JTextField debugDice;
	//private JButton debugMove;
	
	public MenuPanel(GraphicalHorsesGame game) {
		super();
		setGame(game);
		setBoardPanel(game.getBoardPanel());
		
		this.setBorder(BorderFactory.createTitledBorder("MENU"));
		JButton diceButton = new JButton("Lancer le dé");
		DiceListener diceListener = new DiceListener();
		diceResult = new JLabel();
		teamLabel = new JLabel("Au tour de l'équipe X");
		
		// Debuging
//		debugDice = new JTextField();
//		debugMove = new JButton("DEBUG BUTTON");
		
		
		diceButton.addActionListener(diceListener);
		this.setLayout(new GridLayout(3, 1));
		
		this.add(teamLabel);
		this.add(diceButton);
		this.add(diceResult);
		
		// Debugging
//		this.add(debugDice);
//		this.add(debugMove);
//		debugMove.addActionListener(new DebugListener());
		
	}
	
	public void setTeamLabelText(String txt) {
		teamLabel.setText(txt);
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

	public class DebugListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int curr = game.getGame().getCurrentTeamNb();
			teamLabel.setText("Au tour de l'équipe " + (curr + 1));
			int diceValue = Integer.parseInt(debugDice.getText());
			game.getGame().setDiceResult(diceValue);
						
		}
		
	}
	
}
