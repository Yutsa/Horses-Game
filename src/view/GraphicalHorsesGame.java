package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import board.BottomStairway;
import board.StairwaySquare;
import exceptions.PathBlockedException;
import game.HorsesGame;
import piece.Piece;

public class GraphicalHorsesGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 466892845740861801L;
	private HorsesGame game = new HorsesGame(4, 1);
	private BoardPanel boardPanel;
	private MenuPanel menuPanel;
	private JLabel[] diceResultLabels;
	private JButton diceButton;
	private JDialog deciderFrame;

	public GraphicalHorsesGame() {
		// Place a Piece on the final step of the stairway to test the win condition.
		game.getTeam(0).getPiece(0).setSquare(game.getBoard().getSquare(6, 7));
		
		this.setResizable(false);
		
		boardPanel = new BoardPanel(this);
		menuPanel = new MenuPanel(this);

		this.setLayout(new BorderLayout());
		this.add(boardPanel, BorderLayout.EAST);
		this.add(menuPanel, BorderLayout.WEST);

		this.setTitle("Jeu des Petits Chevaux");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		createMenu();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		decideStartingTeam();
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
	
	public void setBoardPanel(BoardPanel b) {
		if (b == null)
			throw new IllegalArgumentException();
		this.boardPanel = b;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel m) {
		if (m == null)
			throw new IllegalArgumentException();
		this.menuPanel = m;
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
		switch (JOptionPane.showConfirmDialog(this,
				"L'équipe " + piece.getTeam().getColor() + " a gagné ! Rejouer ?", "GAGNÉ", JOptionPane.YES_NO_OPTION)) {
		case JOptionPane.YES_OPTION:
			replay();
			break;
		case JOptionPane.NO_OPTION:
			this.dispose();
			break;
		}
	}

	public void replay() {
		setGame(new HorsesGame(4, 1));
		this.remove(boardPanel);
		this.remove(menuPanel);
		setBoardPanel(new BoardPanel(this));
		setMenuPanel(new MenuPanel(this));
		this.add(boardPanel, BorderLayout.EAST);
		this.add(menuPanel, BorderLayout.WEST);
		this.setVisible(true);
		boardPanel.displayBoard();
		decideStartingTeam();
	}
	
	public void decideStartingTeam() {
		deciderFrame = new JDialog(this, "Quelle équipe va commencer ?", true);
		JPanel panel = new JPanel(new GridBagLayout());
		JPanel diceResultPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		panel.add(diceResultPanel, c);
		
		diceResultLabels = new JLabel[game.getNbTeam()];
		for (int i = 0; i < game.getNbTeam(); i++) {
			JLabel label = new JLabel("Équipe " + (i + 1) + ":");
			c.gridx = i;
			c.gridy = 0;
			c.weightx = 1;
			c.weighty = 1;
			c.ipadx = 40;
			c.ipady = 40;
			diceResultPanel.add(label, c);
			diceResultLabels[i] = new JLabel();
			c.gridx = i;
			c.gridy = 1;
			c.weightx = 1;
			c.weighty = 1;
			diceResultPanel.add(diceResultLabels[i], c);
		}
		
		diceButton = new JButton("Lancer le dé");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		panel.add(diceButton, c);
		panel.setSize(400, 600);
		panel.setVisible(true);
		diceButton.addActionListener(new DiceHandler());
		
		deciderFrame.getContentPane().add(panel);
		deciderFrame.pack();
		deciderFrame.setVisible(true);
		
	}
	
	public class DiceHandler implements ActionListener {
		private int counter = 0;
		private int[] result = new int[game.getNbTeam()];
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (counter < game.getNbTeam()) {
				this.result[counter] = game.getDice().roll();
				diceResultLabels[game.getCurrentTeamNb()].setText("" + result[counter]);
				game.nextTeam();
				counter++;
				if (counter == 4)
					diceButton.setText("Lancer la partie");
			}
			else {
				int indexMax = 0;
				int max = 0;
				for (int i = 0; i < game.getNbTeam(); i++) {
					if (result[i] > max) {
						max = result[i];
						indexMax = i;
					}
				}
				game.setCurrentTeam(game.getTeam(indexMax));
				menuPanel.setTeamLabelText("Au tour de l'équipe " + (indexMax + 1));
				deciderFrame.dispose();
			}
		}
		
	}
	
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem rules = new JMenuItem("Règles");
		menuBar.add(rules);
		rules.addActionListener(new RulesListener());
		this.setJMenuBar(menuBar);
	}
	
	public class RulesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new RulesDialog();
		}
		
	}
}
