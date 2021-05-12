/*
 * this is the Play class. This is the class that is called from the terminal. It defines a username and calls the Player class to create a 
 * Player object. It also creates all the level objects, and implements a loop so that the user can play through all of the levels. 
 * 
 * Authors:  Mia Collymore Abbas, Nina Redpath, Sarah Willis
 */
import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class

public class Play {
	
	public static void main(String[] args) {		
		//create the scanner for all the levels
		Scanner ap = new Scanner(System.in);
		
		
		//Creating a player class: 
		Player temp = new Player(" ", 0);
		Player singlePlayer = temp.createPlayer(ap);
		
		//creating player arrays for leaderboard.
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(singlePlayer);
		Leaderboard leaders = new Leaderboard();
		
		//declaration of levels
		Level1 levelOne = new Level1();
		Level2 levelTwo = new Level2();
		Level3 levelThree = new Level3();
		Level4 levelFour = new Level4();
		Level5 levelFive = new Level5();
		
		
		//playing of games
		boolean one = levelOne.playLevel(singlePlayer, ap);
		boolean two = false;
		boolean three = false;
		boolean four = false;
		
		
		if(one) {
			leaders.printLeaderboard(players);
			two = levelTwo.playLevel(singlePlayer, ap);
		}
		if(two) {
			leaders.printLeaderboard(players);
			three = levelThree.playLevel(singlePlayer, ap);

		}
		if(three) {
			leaders.printLeaderboard(players);
			four = levelFour.playLevel(singlePlayer, ap);
		}
		if(four) {
			leaders.printLeaderboard(players);
			levelFive.playLevel(singlePlayer, ap);
		}
		
		System.out.println("Thank you for playing!!");
		System.out.println();
		System.out.println();

	}
	
}
