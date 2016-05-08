package board;

//TODO: Make the Javadoc
public abstract class Board {
	private int width;
	private int height;
	private Square[][] squares;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width <= 0)
			throw new IllegalArgumentException();
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height <= 0)
			throw new IllegalArgumentException();
		this.height = height;
	}

	public Square getSquare(int x, int y) {
		return squares[x][y];
	}

	public void setSquare(Square square, int x, int y) {
		if (square == null)
			throw new IllegalArgumentException();
		this.squares[x][y] = square;
	}

	@Override
	public String toString() {
		return "Board [width=" + width + ", height=" + height + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Board))
			return false;
		Board other = (Board) o;
		if (other.getHeight() != this.height || other.getWidth() != this.width)
			return false;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!(this.squares[height][width].equals(other.getSquare(height, width))))
					return false;
			}
		}
		return true;

	}
}
