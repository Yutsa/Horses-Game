package board;

import game.HorsesGame;

// Faire javadoc
public abstract class Board {
	private int width;
	private int height;
	private Square[][] squares;
	private HorsesGame game;

	public Board(int width, int height, HorsesGame game) {
		setWidth(width);
		setHeight(height);
		setGame(game);
		squares = new Square[width][height];
	}
	
	public void setGame(HorsesGame game) {
		if (game == null)
			throw new IllegalArgumentException();
		this.game = game;
	}
	
	public HorsesGame getGame() {
		return this.game;
	}
	
	public Square[][] getBoard() {
		return this.squares;
	}
	
	/**
	 * Get the width of the Board.
	 * 
	 * @return The width of the Board.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the width of the Board.
	 * 
	 * @param width
	 *            The width of the Board.
	 */
	public void setWidth(int width) {
		if (width <= 0)
			throw new IllegalArgumentException();
		this.width = width;
	}

	/**
	 * Get the height of the Board.
	 * 
	 * @return The height of the Board.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set the height of the Board.
	 * 
	 * @param height
	 *            The height of the Board.
	 */
	public void setHeight(int height) {
		if (height <= 0)
			throw new IllegalArgumentException();
		this.height = height;
	}

	/**
	 * Get the Square of at the (x, y) position in the Board.
	 * 
	 * @param x
	 *            The x-axis position of the Square.
	 * @param y
	 *            The y-axis position of the Square.
	 * @return The Square at the (x, y) position in the Board.
	 */
	public Square getSquare(int x, int y) {
		return squares[x][y];
	}

	/**
	 * Get the Square of at the (x, y) position in the Board.
	 * 
	 * @param square
	 *            The instance of a Square to put in the Board.
	 * @param x
	 *            The x-axis position of the Square.
	 * @param y
	 *            The y-axis position of the Square.
	 */
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
