/*
 * this is the Level3 class, it implements the level interface and creates an object for Level2. It defines the questions and 
 * correct answers for the level along with the level score (increased if  Level2.correctAnswer == userInput in main game play).
 * 
 * Authors:  Mia Collymore Abbas, Nina Redpath, Sarah Willis
 * 
 */
import java.util.Scanner;

public class Level3 implements Level{
	
	int levelScore;
	Question[] levelThreeQuestions = new Question[6];	
	String answerLetter;
	
	/* This method randomizes the order in which the answers to the questions are printed. 
	 * @param q a question being asked 
	 * @return String random order of answers. 
	 * */	
	public String randomize(Question q){
		double randomNumber = Math.floor(Math.random() * 4) + 1;
		String result = "";
		if(randomNumber == 1) {
			result = "A: " + q.answer + " B: " + q.choiceTwo + " C: " + q.choiceThree + " D: " + q.choiceOne;
			answerLetter = "A";
		}
		else if(randomNumber == 2) {
			result = "A: " + q.choiceThree + " B: " + q.answer + " C: " + q.choiceOne + " D: " + q.choiceTwo;
			answerLetter = "B";
		}
		else if(randomNumber == 3) {
			result = "A: " + q.choiceTwo + " B: " + q.choiceOne + " C: " + q.answer + " D: " + q.choiceThree;
			answerLetter = "C";
		}
		else if(randomNumber == 4) {
			result = "A: " + q.choiceOne + " B: " + q.choiceThree + " C: " + q.choiceTwo + " D: " + q.answer;
			answerLetter = "D";
		}
		return result;
	}

	/*
	 * This function plays the current level. 
	 * @param p the current player
	 * @param ap the scanner, how the player will be answering questions. 
	 * @return boolean, true once the level has been played all the way through. 
	 * 
	 * */
	public boolean playLevel(Player p, Scanner ap){
		//don't close the Scanner because the game ends
		System.out.println("Welcome to Level 3: Dragonflies");
		System.out.println(" __         _           _         __\n"
				+ "( '\\___      \\_  (^)  _/      ___/' )\n"
				+ " \\ , ' \\____   \\ / \\ /   ____/ ' , /\n"
				+ "  \\__ ' , ' \\___{~V~}___/ ' , ' __/\n"
				+ " ____\\_________ {<!>} _________/____\n"
				+ "/ , ' , ' , ' ,`{<!>}~, ' , ' , ' , \\\n"
				+ "\\_____________ /{<!>}\\______________/\n"
				+ "                 \\./\n"
				+ "                 (~)\n"
				+ "                 (~)\n"
				+ "                 (~)\n"
				+ "                 (~)\n"
				+ "                 (~)\n"
				+ "                 (~)\n"
				+ "                 ,0,\n"
				+ "                  \"");
		System.out.println();
		for(int i = 0; i < levelThreeQuestions.length; i++) {
			Question currentQ = levelThreeQuestions[i];
			System.out.println();
			System.out.println(currentQ.prompt);
			System.out.println();
			System.out.println(randomize(currentQ));
			String answer = ap.nextLine();
			while (!levelThreeQuestions[i].checkValidInput(answer)) {
				System.out.println("That answer is not one of the options");
				answer = ap.nextLine();
			}
			System.out.println();
			if(answer.equals(answerLetter)  || answer.equals(answerLetter.toLowerCase())) {
				p.addPoints(levelScore);
				System.out.println("correct!");
			}
			else {
				System.out.println("Incorrect :(, the answer was " + currentQ.answer);

			}
			System.out.println(p.username + "'s score is: " + p.points);

		}
		return true;
	}
	
	{
		//Here, the questions for level three are defined, along with their correct answers, and answer options.
		Question qOne = new Question( "Out of 5,000 species of dragonfly, how many species live in the U.S.?", "450", "3,500", "105", "2,032" );
		Question qTwo = new Question( "The largest known modern dragonfly has a wingspan of:", "6.3 in", "2 ft", "1 ft 4.2 in", "11 in" );
		Question qThree = new Question( "During the larval stage, dragonflies live where?", "In water", "Underground", "In a tree", "In their mother's pouch" );
		Question qFour = new Question( "Dragonflies catch their prey in their...", "Feet", "Wings", "Nests", "Antennae" );
		Question qFive = new Question( "How far does the globe skinner dragonfly migrate?", "11,000 miles", "100 miles", "3 miles", "They do not migrate." );
		Question qSix = new Question( "What is a group of dragonflies called?", "A swarm", "A dragoon", "A castle", "A clan" );
		levelThreeQuestions[0] = qOne;
		levelThreeQuestions[1] = qTwo;
		levelThreeQuestions[2] = qThree;
		levelThreeQuestions[3] = qFour;
		levelThreeQuestions[4] = qFive;
		levelThreeQuestions[5] = qSix;

		this.levelScore = 30;
	}
}
