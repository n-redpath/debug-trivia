/*
 * this is the Level5 class, it implements the level interface and creates an object for Level2. It defines the questions and 
 * correct answers for the level along with the level score (increased if  Level2.correctAnswer == userInput in main game play).
 * 
 * Authors:  Mia Collymore Abbas, Nina Redpath, Sarah Willis
 */
import java.util.Scanner;

public class Level5 implements Level {
	
	int levelScore;
	Question[] levelFiveQuestions = new Question[6];
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
		System.out.println("Welcome to Level 5: Ants");
		System.out.println("/\\/\\\n"
				+ "  \\_\\  _..._\n"
				+ "  (\" )(_..._)\n"
				+ "   ^^  // \\\\");
		System.out.println();
		for(int i = 0; i < levelFiveQuestions.length; i++) {
			Question currentQ = levelFiveQuestions[i];
			System.out.println();
			System.out.println(currentQ.prompt);
			System.out.println();
			System.out.println(randomize(currentQ));
			String answer = ap.nextLine();
			while (!levelFiveQuestions[i].checkValidInput(answer)) {
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
		//Here, the questions for level five are defined, along with their correct answers, and answer options.
		Question qOne = new Question( "An ant can carry up to __ times its body weight.", "5,000", "200", "1,000", "30" );
		Question qTwo = new Question( "An ant colony is also known as what?", "A formicary", "A Pogonomyrmex", "A compound", "An apothecary" );
		Question qThree = new Question( "The Middle English origin of the name ant, 'ampte,' means what?", "The biter-off", "The emperor", "The firestorm", "The freckle" );
		Question qFour = new Question( "Mating ants have which special ability/", "Flying", "Super-speed", "Color-changing", "Singing" );
		Question qFive = new Question( "Which type of ant CANNOT be found in a colony?", "Mating females", "The Queen", "Female workers", "Males" );
		Question qSix = new Question( "The Cornell Sun called which ant-themed movie 'Marxist Propaganda'?", "Antz", "Ant-Man", "The Ant Bully", "None of the above." );
		levelFiveQuestions[0] = qOne;
		levelFiveQuestions[1] = qTwo;
		levelFiveQuestions[2] = qThree;
		levelFiveQuestions[3] = qFour;
		levelFiveQuestions[4] = qFive;
		levelFiveQuestions[5] = qSix;

		this.levelScore = 50;
	}
}
