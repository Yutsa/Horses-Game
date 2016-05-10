package game;

import java.util.ArrayList;

import team.Team;

//TODO: Implement Game
//TODO: Implement the Movement System.
public class Game {
	private int nbTeam;
	private int nbPiece;
	private ArrayList<Team> teams;

	public Game(int nbTeam, int nbPiece) {
		setNbTeam(nbTeam);
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
	
	public void getTeam(int i) {
		if (i < 0)
			throw new IllegalArgumentException();
		teams.get(i);
	}
	
	public Team createTeam(int color, Game game) {
		return new Team(color, game);
	}
	
	@Override
	public String toString() {
		return "Game [nbTeam=" + nbTeam + "]";
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}
}
