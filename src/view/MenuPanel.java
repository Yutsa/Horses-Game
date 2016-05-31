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

/**
 * The MenuPanel class is the one displaying the menu of the GraphicalHorsesGame.
 * @author edouard
 *
 */
public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 8402937111338612971L;
	private GraphicalHorsesGame game;
	private BoardPanel boardPanel;
	private Dice dice = new Dice(1, 6);
	private JLabel diceResult;
	private JLabel teamLabel;
	private JTextField debugDice;
	//private JButton debugMove;
	
	/**
	 * @param game The instance of GraphicalHorsesGame this menu is for.
	 */
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
	
	/**
	 * Sets the text for the label indication the team currently playing.
	 * @param txt The text you want to put in the label. 
	 */
	public void setTeamLabelText(String txt) {
		teamLabel.setText(txt);
	}
	
	/**
	 * Gets the BoardPanel of the game's main window.
	 * @return The Boardpanel of the game's main window.
	 * @see GraphicalHorsesGame
	 * @see BoardPanel
	 */
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}


	/**
	 * Sets the BoardPanel of the game's main window.
	 * @param boardPanel The BoardPanel of the game's main window.
	 */
	public void setBoardPanel(BoardPanel boardPanel) {
		if (boardPanel == null)
			throw new IllegalArgumentException();
		this.boardPanel = boardPanel;
	}


	/**
	 * Gets the instance of the graphical version of horses game being played.
	 * @return The instance of the graphical version of horses game being played.
	 */
	public GraphicalHorsesGame getGame() {
		return game;
	}
	
	/**
	 * Sets the instance of the graphical version of horses game being played.
	 * @param game The instance of the graphical version of horses game being played.
	 */
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
