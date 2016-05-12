package game;

import java.util.ArrayList;

import board.Board;
import dice.Dice;
import team.Team;

public abstract class Game {

	private int nbTeam;
	private int nbPiece;
	private Board board;
	private ArrayList<Team> teams;
	private Dice dice;
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		if (board == null)
			throw new IllegalArgumentException();
		this.board = board;
	}


	public Game(int nbTeam, int nbPiece) {
		setNbTeam(nbTeam);
		teams = new ArrayList<Team>();
		for (int i = 1; i <= getNbTeam(); i++)
		{
			teams.add(createTeam(i, this));
		}
		setNbPiece(nbPiece);
	}

	public void setNbTeam(int nbTeam) {
		if (nbTeam < 1)
			throw new IllegalArgumentException();
		this.nbTeam = nbTeam;
	}

	
	public int getNbTeam() {
		return nbTeam;
	}

	/**
	 * Get the number of pieces per Team.
	 * @return the number of pieces per Team.
	 */
	public int getNbPieces() {
		return nbPiece;
	}

	public void setNbPiece(int nb) {
		if (nb <= 0)
			throw new IllegalArgumentException();
		nbPiece = nb;
	}

	public void addTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException();
		if (teams.contains(team))
			throw new IllegalArgumentException();
		teams.add(team);
	}

	public void removeTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException();
		if (!teams.contains(team))
			throw new IllegalArgumentException();
		teams.add(team);
	}

	public int getNbTeams() {
		return teams.size();
	}

	public Team getTeam(int i) {
		if (i < 0)
			throw new IllegalArgumentException();
		return teams.get(i);
	}

	public Team createTeam(int color, Game game) {
		return new Team(color, game);
	}
	
	public abstract void runGame();

}
