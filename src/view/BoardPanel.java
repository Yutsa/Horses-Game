package view;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import board.BasicSquare;
import board.BottomStairway;
import board.HorsePen;
import board.Square;
import board.StairwaySquare;
import game.Game;

public class BoardPanel extends JPanel {
	private Game game;
	private SquareButton[][] squareButtons;

	public BoardPanel(Game game) {
		super();
		squareButtons = new SquareButton[15][15];
		ImageIcon img = new ImageIcon();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				squareButtons[j][i] = new SquareButton(game.getBoard().getSquare(j, i), img, game);
				this.add(squareButtons[j][i]);
			}
		}
		this.setLayout(new GridLayout(15, 15));
		setGame(game);
		displayBoard();
	}
	
	private SquareButton getSquareButton(int x, int y) {
		return squareButtons[x][y];
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	public void displayBoard() {
		int i, j;
		ImageIcon pion = new ImageIcon();
		ImageIcon img = new ImageIcon();
		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++) {
				Square square = game.getBoard().getSquare(j, i);
				SquareButton squareB = getSquareButton(j, i);
				if (square instanceof BasicSquare || square instanceof BottomStairway) {
					switch (square.getTeam().getColor()) {
					case 1:
						img = new ImageIcon("img/jaune/case.png");
						break;
					case 2:
						img = new ImageIcon("img/bleu/case.png");
						break;
					case 3:
						img = new ImageIcon("img/vert/case.png");
						break;
					case 4:
						img = new ImageIcon("img/rouge/case.png");
						break;
					}
				}

				else if (square instanceof HorsePen) {
					switch (square.getTeam().getColor()) {
					case 1:
						img = new ImageIcon("img/jaune/fond.png");
						break;
					case 2:
						img = new ImageIcon("img/bleu/fond.png");
						break;
					case 3:
						img = new ImageIcon("img/vert/fond.png");
						break;
					case 4:
						img = new ImageIcon("img/rouge/fond.png");
						break;
					}
				}

				else if (square.getPosX() == 7 && square.getPosY() == 7) {
					img = new ImageIcon("img/caseCentre.png");
				}

				else if (square instanceof StairwaySquare) {
					StairwaySquare stairway = (StairwaySquare) square;
					switch (square.getTeam().getColor()) {
					case 1:
						img = new ImageIcon("img/jaune/" + stairway.getNbStairway() + ".png");
						break;
					case 2:
						img = new ImageIcon("img/bleu/" + stairway.getNbStairway() + ".png");
						break;
					case 3:
						img = new ImageIcon("img/vert/" + stairway.getNbStairway() + ".png");
						break;
					case 4:
						img = new ImageIcon("img/rouge/" + stairway.getNbStairway() + ".png");
						break;
					}
				}

				if (!square.isEmpty()) {
					switch (square.getPieceOnSquare().getTeam().getColor()) {
					case 1:
						pion = new ImageIcon("img/jaune/pion.png");
						break;
					case 2:
						pion = new ImageIcon("img/bleu/pion.png");
						break;
					case 3:
						pion = new ImageIcon("img/vert/pion.png");
						break;
					case 4:
						pion = new ImageIcon("img/rouge/pion.png");
						break;
					}
					BufferedImage combinedImage = new BufferedImage(img.getIconWidth(), img.getIconHeight(),
							BufferedImage.TYPE_INT_ARGB);
					Graphics2D g = combinedImage.createGraphics();
					g.drawImage(img.getImage(), 0, 0, null, null);
					g.drawImage(pion.getImage(), 0, 0, null, null);
					g.dispose();
					img = new ImageIcon(combinedImage);
					
				}
				squareB.setIcon(img);
			}
		}
	}
}
