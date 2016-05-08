package tests;

import dice.Dice;
import board.*;

public class Tester {

	public static void testDice() {
		Dice dice = new Dice(1, 6);
		for (int i = 0; i < 100; i++)
		{
			System.out.println("" + dice.roll());
		}
	}
	
	public static void testSquare() {
		
	}

}
