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
package game;

import java.util.ArrayList;

import board.Board;
import piece.Piece;
import team.Team;

/**
 * The Game class represents the board game (Chess, Horses game and so on) being
 * played.
 * 
 * @author edouard
 *
 */
public abstract class Game {

	private int nbTeam;
	private int nbPiece;
	private Board board;
	private ArrayList<Team> teams;
	private int currentTeam = 0;

	/**
	 * @param nbTeam
	 *            The number of teams to play this game.
	 * @param nbPiece
	 *            The number of pieces per team in this game.
	 * @see Team
	 * @see Piece
	 */
	public Game(int nbTeam, int nbPiece) {
		setNbTeam(nbTeam);
		setNbPiece(nbPiece);
		teams = new ArrayList<Team>();
		for (int i = 1; i <= getNbTeam(); i++) {
			addTeam((createTeam(i, this)));
		}
	}

	/**
	 * Gets the team currently playing.
	 * 
	 * @return The team that is currently plaiyng this game this turn.
	 * @see Team
	 */
	public Team getCurrentTeam() {
		return teams.get(currentTeam);
	}

	/**
	 * Gets the number of the team playing this turn.
	 * 
	 * @return The number of this turn's team.
	 * @see Team
	 */
	public int getCurrentTeamNb() {
		return currentTeam;
	}

	/**
	 * Sets the currentTeam number.
	 * 
	 * @param team
	 *            The team you want to be the current one.
	 * @see Team
	 */
	public void setCurrentTeam(Team team) {
		currentTeam = teams.indexOf(team);
	}

	/**
	 * Change the playing team, it's used to go to the next turn.
	 */
	public void nextTeam() {
		if (currentTeam == teams.size() - 1)
			currentTeam = 0;
		else
			currentTeam++;
	}

	/**
	 * Gets the board used for this game.
	 * 
	 * @return The {@link Board} used by this game.
	 * @see Board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets the {@link ArrayList} containing the teams.
	 * 
	 * @return The {@link ArrayList} containing the teams.
	 * @see ArrayList
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}

	/**
	 * Sets the board for this game.
	 * 
	 * @param board
	 *            The board used by this game.
	 * @see Board
	 */
	public void setBoard(Board board) {
		if (board == null)
			throw new IllegalArgumentException();
		this.board = board;
	}

	/**
	 * Sets the number of team to play this game.
	 *
	 * @param nbTeam
	 *            The number of team playing this game.
	 * @see Team
	 */
	public void setNbTeam(int nbTeam) {
		if (nbTeam < 1)
			throw new IllegalArgumentException();
		this.nbTeam = nbTeam;
	}

	/**
	 * Gets the number of teams playing this game.
	 * 
	 * @return The number of teams playing this game.
	 * @see Team
	 */
	public int getNbTeam() {
		return nbTeam;
	}

	/**
	 * Gets the number of pieces per Team.
	 * 
	 * @return the number of pieces per Team.
	 * @see Piece
	 * @see Team
	 */
	public int getNbPieces() {
		return nbPiece;
	}

	/**
	 * Sets the number of pieces per team in this game.
	 * 
	 * @param nb
	 *            The number of pieces per team for this game
	 * @see Piece
	 * @see Team
	 */
	public void setNbPiece(int nb) {
		if (nb <= 0)
			throw new IllegalArgumentException();
		nbPiece = nb;
	}

	/**
	 * Adds a team to the ArrayList of teams playing this game.
	 * 
	 * @param team
	 *            The team to add to the list.
	 * @see Team
	 */
	public void addTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException();
		if (teams.contains(team))
			throw new IllegalArgumentException();
		teams.add(team);
	}

	/**
	 * Removes a team from the ArrayList of teams playing this game.
	 * 
	 * @param team
	 *            The team to remove from the list.
	 * @see Team
	 */
	public void removeTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException();
		if (!teams.contains(team))
			throw new IllegalArgumentException();
		teams.remove(team);
	}

	/**
	 * Gets the size of the ArrayList containing the teams in this game.
	 * 
	 * @return The size of the ArrayList of teams.
	 */
	public int size() {
		return teams.size();
	}

	/**
	 * Gets a team from the ArrayList of teams of this game.
	 * 
	 * @param i
	 *            The index of the team to get.
	 * @return The Team at the index i.
	 * @see Team
	 */
	public Team getTeam(int i) {
		if (i < 0 || i > teams.size())
			throw new IllegalArgumentException();
		return teams.get(i);
	}

	/**
	 * Creates a Team.
	 * 
	 * @param color
	 *            The color of the team to create.
	 * @param game
	 *            The game the team is going to play.
	 * @return The team newly created.
	 * @see Team
	 */
	public Team createTeam(int color, Game game) {
		return new Team(color, game);
	}
}
