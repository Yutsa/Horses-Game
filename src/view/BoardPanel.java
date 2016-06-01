/*  horses_game
    Copyright (C) 2016  Édouard WILLISSECK

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
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

/**
 * The BoardPanel class is to display the board on the window.
 * 
 * @author edouard
 *
 */
public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 5622654420900097400L;
	private GraphicalHorsesGame game;
	private SquareButton[][] squareButtons;

	/**
	 * @param game The instance of graphical game being played in the window.
	 */
	public BoardPanel(GraphicalHorsesGame game) {
		super();
		squareButtons = new SquareButton[15][15];
		setGame(game);
		setUpBoard(game);
		this.setLayout(new GridLayout(15, 15));
		displayBoard();
	}

	/**
	 * Creates the graphical board for the game.
	 * @param game The instance of graphical game being played in the window.
	 */
	public void setUpBoard(GraphicalHorsesGame game) {
		ImageIcon img = new ImageIcon();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				squareButtons[j][i] = new SquareButton(game.getGame().getBoard().getSquare(j, i), img, game, this);
				this.add(squareButtons[j][i]);
			}
		}
	}

	/**
	 * Gets the SquareButton at the (x, y) position.
	 * @param x The x-axis position of the button
	 * @param y The y-axis position of the button
	 * @return The SquareButton at the (x, y) position
	 * @see SquareButton
	 */
	public SquareButton getSquareButton(int x, int y) {
		return squareButtons[x][y];
	}

	/**
	 * Returns the instance of graphical game being played in the window.
	 * @return The instance of graphical game being played in the window.
	 */
	public GraphicalHorsesGame getGame() {
		return game;
	}

	/**
	 * Sets the instance of graphical game being played in the window.
	 * @param game The instance of graphical game being played in the window.
	 */
	public void setGame(GraphicalHorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	/**
	 * Displays the board in this panel.
	 */
	public void displayBoard() {
		int i, j;
		ImageIcon pion = new ImageIcon();
		ImageIcon img = new ImageIcon();
		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++) {
				Square square = game.getGame().getBoard().getSquare(j, i);
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
