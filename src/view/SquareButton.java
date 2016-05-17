package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import board.Square;
import game.Game;

public class SquareButton extends JButton implements ActionListener{
	private Square square;
	private Game game;
	
	public SquareButton(Square square, ImageIcon img, Game game) {
		super(img);
		setSquare(square);
		setGame(game);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.addActionListener(this);
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		if (square == null)
			throw new IllegalArgumentException();
		this.square = square;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		if (game == null) 
			throw new IllegalArgumentException();
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(square.getPosX() + " & " + square.getPosY());
		
	}
}
