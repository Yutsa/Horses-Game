package team;

import java.util.ArrayList;

import board.HorsePen;
import game.Game;
import game.HorsesGame;
import piece.Horse;
import piece.Piece;

/**
 * A class representing a team for a board game.
 * 
 * @author Édouard WILLISSECK
 *
 */
public class Team {
	private int color;
	private Game game;
	private ArrayList<Piece> pieces;
	private boolean canPlay;

	
	/**
	 * Basic constructor.
	 * 
	 * @param color
	 *            An integer representing the color of the team. It must be
	 *            between 1 and the number of Teams for the game.
	 * @param game2
	 *            The Game being played by the Team.
	 */
	public Team(int color, Game game2) {
		setGame(game2);
		setColor(color);
		pieces = new ArrayList<Piece>();
	}

	public Piece createPieces(int x, int y, boolean alive, Team team) {
		return new Horse(x, y, alive, team);
	}
	/**
	 * Gets the game being played by the team.
	 * 
	 * @return The game being played by the Team.
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Sets the game being played.
	 * 
	 * @param game
	 *            The game being played.
	 */
	public void setGame(Game game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}

	/**
	 * Get the color of the team.
	 * 
	 * @return The color of the team.
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Set the color of the team.
	 * 
	 * @param color
	 *            The color of the team.
	 */
	public void setColor(int color) {
		if (color < 1 || color > game.getNbTeam()) {
			throw new IllegalArgumentException("Couleur invalide.");
		}
		this.color = color;
	}
	
	/**
	 * Get the Team's i piece.
	 * @param i The index of the piece to get.
	 * @return The piece at index i
	 */
	public Piece getPiece(int i) {
		if (i < 0 || i > pieces.size())
			throw new IllegalArgumentException();
		return pieces.get(i);
	}
	
	/**
	 * Add a piece to the Team's pieces.
	 * @param p The Piece to add.
	 */
	public void addPiece(Piece p) {
		if (p == null)
			throw new IllegalArgumentException();
		pieces.add(p);
	}
	
	/**
	 * Remove a Piece from the Team's pieces. 
	 * @param p The Piece to remove.
	 */
	public void removePiece(Piece p) {
		if (p == null)
			throw new IllegalArgumentException();
		if (!pieces.contains(p))
			throw new IllegalArgumentException();
		pieces.remove(p);
	}
	
	/**
	 * Get the number of pieces from this team.
	 * @return The number of pieces from this team.
	 */
	public int getNbPieces() {
		return pieces.size();
	}

	/**
	 * Say if the Team still has pieces left or not.
	 * 
	 * @return A boolean, true if the Team still has pieces, false otherwise.
	 */
	public boolean hasPiecesLeft() {
		return getNbPieces() != 0;
	}
	
	public boolean hasPieceOutsideHorsePen() {
		for (Piece piece : pieces) {
			if (!(piece.getSquare() instanceof HorsePen))
				return true;
		}
		return false;
	}
	
	// TODO: Check if a piece is playable bot blocked by another piece.
	public boolean canPlay(int diceNumber) {
		if (diceNumber == 6)
			return true;
		else 
			return hasPieceOutsideHorsePen();
	}
	
	public void setCanPlay(boolean b) {
		this.canPlay = b;
	}
	
	public boolean isPlayable() {
		return this.canPlay;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Team))
			return false;
		Team t = (Team) o;
		return t.getColor() == this.getColor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Team [color=" + color + "]";
	}

}
