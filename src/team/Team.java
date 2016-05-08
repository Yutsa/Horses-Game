package team;

//TODO: Make Javadoc
//TODO: Check the Game class to know how many team for the game (Allows reusabilty for this class)
public class Team {
	private int color;

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		if (color < 1 || color > 4) {
			throw new IllegalArgumentException("Il n'y a que 4 équipes et donc 4 couleurs.");
		}
		this.color = color;
	}

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

	@Override
	public String toString() {
		return "Team [color=" + color + "]";
	}

}
