package game;

//TODO: Implement Game
public class Game {
	private int nbTeam;

	public int getNbTeam() {
		return nbTeam;
	}

	public Game(int nbTeam) {
		setNbTeam(nbTeam);
	}

	public void setNbTeam(int nbTeam) {
		if (nbTeam < 1)
			throw new IllegalArgumentException();
		this.nbTeam = nbTeam;
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
