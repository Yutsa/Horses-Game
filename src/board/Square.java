package board;

import team.Team;

public abstract class Square {
	private int posX;
	private int poxY;
	private Team team;
	
	//TODO: Make tests inside setters.
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPoxY() {
		return poxY;
	}
	public void setPoxY(int poxY) {
		this.poxY = poxY;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		if (team == null)
			throw new IllegalArgumentException("Paramètre null.");
		this.team = team;
	}

}
