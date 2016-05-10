package tests;

import dice.Dice;
import game.HorsesGame;
import team.Team;
import board.*;

public class Tester {

	public static void testDice() {
		Dice dice = new Dice(1, 6);
		for (int i = 0; i < 100; i++)
		{
			System.out.println("" + dice.roll());
		}
	}
	
	public static void testTeam() {
		HorsesGame chevaux = new HorsesGame(4, 4);
		Team team1 = new Team(1, chevaux);
		Team team2 = new Team(2, chevaux);
		Team team3 = new Team(3, chevaux);
		Team team4 = new Team(4, chevaux);
		//Throws IllegalArgumentException because the game has only 4 teams.
		//Team team5 = new Team(5, chevaux);
		Team team6 = new Team(4, chevaux);
		
		if (team6.equals(team4))
			System.out.println("Team 6 = Team 4");
		if (!(team6.equals(team3)))
			System.out.println("Team 6 != Team 4");
		
		System.out.println(team1);
		
		BoardHorses board = new BoardHorses(chevaux);
		System.out.println(board);
	}

}
