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
package dice;

import java.util.Random;

/**
 * This is the implementation of the dice for the horse game.
 * 
 * @author Édouard WILLISSECK
 *
 */
public class Dice {
	/**
	 * The minimum number this dice can roll.
	 * 
	 * @see Dice#setMinimum(int)
	 * @see Dice#roll()
	 */
	private int minimum;
	/**
	 * The maximum number this dice can roll.
	 * 
	 * @see Dice#setMaximum(int)
	 * @see Dice#roll()
	 */
	private int maximum;

	/**
	 * The main constructor for this dice.
	 * 
	 * @param mini
	 *            The minimum number you can roll.
	 * @param maxi
	 *            The maximum number you can roll.
	 * @see Dice#maximum
	 * @see Dice#minimum
	 */
	public Dice(int mini, int maxi) {
		setMinimum(mini);
		setMaximum(maxi);
	}

	/**
	 * The setter for the minimum
	 * 
	 * @param mini
	 *            An integer representing the minimum number to roll.
	 * @see Dice#minimum
	 */
	public void setMinimum(int mini) {
		if (mini < 1) {
			throw new IllegalArgumentException();
		}
		this.minimum = mini;
	}

	/**
	 * The setter for the maximum.
	 * 
	 * @param maxi
	 *            An integer representing the maximum number to roll.
	 * @see Dice#maximum
	 */
	public void setMaximum(int maxi) {
		this.maximum = maxi;
	}

	/**
	 * The getter for the minimum
	 * 
	 * @return An integer representing the minimum.
	 */
	public int getMinimum() {
		return this.minimum;
	}

	/**
	 * The getter for the maximum
	 * 
	 * @return An integer representing the maximum.
	 */
	public int getMaximum() {
		return this.maximum;
	}

	/**
	 * Compares an object to the dice.
	 * 
	 * @param obj
	 *            An object to compare to the dice.
	 * @return True if the object is the same as the dice, False otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dice other = (Dice) obj;
		if (maximum != other.maximum)
			return false;
		if (minimum != other.minimum)
			return false;
		return true;
	}

	/**
	 * Converts the dice to a String.
	 * 
	 * @return A string representing the dice.
	 */
	@Override
	public String toString() {
		return "Dice [minimum=" + minimum + ", maximum=" + maximum + "]";
	}

	/**
	 * Rolls the dice
	 * 
	 * @return An integer between the minimum and maximum.
	 * @see Dice#minimum
	 * @see Dice#maximum
	 */

	public int roll() {
		Random rand = new Random();
		return rand.nextInt(maximum) + 1;
	}

}
