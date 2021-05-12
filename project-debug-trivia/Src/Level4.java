/*
 * this is the Level4 class, it implements the level interface and creates an object for Level2. It defines the questions and 
 * correct answers for the level along with the level score (increased if  Level2.correctAnswer == userInput in main game play).
 * 
 * Authors:  Mia Collymore Abbas, Nina Redpath, Sarah Willis
 */
import java.util.Scanner;

public class Level4 implements Level {
	
	int levelScore;
	Question[] levelFourQuestions = new Question[6];
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
		System.out.println("Welcome to Level 4: Worms");
		System.out.println("                           (o)(o)\n"
				+ "                          /     \\\n"
				+ "                         /       |\n"
				+ "                        /   \\  * |\n"
				+ "          ________     /    /\\__/\n"
				+ "  _      /        \\   /    /\n"
				+ " / \\    /  ____    \\_/    /\n"
				+ "//\\ \\  /  /    \\         /\n"
				+ "V  \\ \\/  /      \\       /\n"
				+ "    \\___/        \\_____/");
		System.out.println();
		for(int i = 0; i < levelFourQuestions.length; i++) {
			Question currentQ = levelFourQuestions[i];
			System.out.println();
			System.out.println(currentQ.prompt);
			System.out.println();
			System.out.println(randomize(currentQ));
			String answer = ap.nextLine();
			while (!levelFourQuestions[i].checkValidInput(answer)) {
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
		//Here, the questions for level four are defined, along with their correct answers, and answer options.
		Question qOne = new Question( "How many eyes do worms have?", "0", "2", "1", "3" );
		Question qTwo = new Question( "About how much exposure to light does it take to paralyze a worm?", "One hour", "Thirty minutes", "Four hours", "Five minutes" );
		Question qThree = new Question( "How fast can a medium earthworm move through the earth?", "185ft/hr", "20ft/hr", "3ft/hr", "100ft/hr" );
		Question qFour = new Question( "A worm's tail will grow back if cut off. This is called:", "Regeneration", "Starfishing", "Regrowth", "Shifting" );
		Question qFive = new Question( "How many hearts does a worm have?", "5", "6", "1", "3" );
		Question qSix = new Question( "Which of the team members had to dissect a worm in high school biology class?", "Sarah", "Mia", "Nina", "Sideshow Bob" );
		levelFourQuestions[0] = qOne;
		levelFourQuestions[1] = qTwo;
		levelFourQuestions[2] = qThree;
		levelFourQuestions[3] = qFour;
		levelFourQuestions[4] = qFive;
		levelFourQuestions[5] = qSix;

		this.levelScore = 40;
	}
}
