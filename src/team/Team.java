package team;

import game.Game;

/**
 * A class reprenseting a team for a board game.
 * 
 * @author Édouard WILLISSECK
 *
 */
public class Team {
	private int color;
	private Game game;

	/**
	 * Basic constructor.
	 * 
	 * @param color
	 *            An integer representing the color of the team. It must be
	 *            between 1 and the number of Teams for the game.
	 * @param game
	 *            The Game being played by the Team.
	 */
	public Team(int color, Game game) {
		setGame(game);
		setColor(color);
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
