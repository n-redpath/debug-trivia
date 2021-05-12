/*
 * This is the unit testing file.  it contains unit tests for the entire project.
 * 
 * Authors:  Mia Collymore Abbas, Nina Redpath, Sarah Willis
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTesting {

	private Player testPlayer;
	private Question testQuestion;
	private Scanner testScanner;

	@BeforeEach
	void setUpTestingVariables() {
		testPlayer = new Player("testusername", 0);
		testQuestion = new Question("Question", "Answer", "option one", "option 2", "option 3");
		testScanner = new Scanner(System.in);
	}

	//checking for valid and invalid new user names
			@Test
			void testNewUser() {
				//check if "Username" is a valid user name.
				boolean isValidUsername = testPlayer.checkUsername("username");
				assertTrue(isValidUsername);
			}

			@Test
			void testBadNewUser() {
				boolean isValidUsername = testPlayer.checkUsername("");
				assertFalse(isValidUsername);
			}

			@Test
			void testAnotherBadNewUser() {
				boolean isValidUsername = testPlayer.checkUsername("    ");
				assertFalse(isValidUsername);
			}

			//test valid and invalid input
			@Test
			void testGoodInput() {
				boolean isValidInput = testQuestion.checkValidInput("A");
				assertTrue(isValidInput);
			}
			
			void testAnotherGoodInput() {
				boolean isValidInput = testQuestion.checkValidInput("a");
				assertTrue(isValidInput);
			}
			
			@Test
			void testBadInput() {
				boolean isValidInput = testQuestion.checkValidInput("my answer");
				assertFalse(isValidInput);		
			}
			
			@Test
			void testAnotherBadInput() {
				boolean isValidInput = testQuestion.checkValidInput("  ");
				assertFalse(isValidInput);		
			}
			
			@Test
			void testNullInput() {
				boolean isValidInput = testQuestion.checkValidInput("");
				assertFalse(isValidInput);		
			}
			
			//METHODS TESTING 
			
			//randomize test -- THIS ONE NEEDS FIXIN
			@Test 
			void randomizeTest() {
				Level1 one = new Level1();
				
				String oneOutcome = "A: " + testQuestion.answer + " B: " + testQuestion.choiceTwo + " C: " + testQuestion.choiceThree + " D: " + testQuestion.choiceOne;
				String twoOutcome = "A: " + testQuestion.choiceThree + " B: " + testQuestion.answer + " C: " + testQuestion.choiceOne + " D: " + testQuestion.choiceTwo;
				String threeOutcome = "A: " + testQuestion.choiceTwo + " B: " + testQuestion.choiceOne + " C: " + testQuestion.answer + " D: " + testQuestion.choiceThree;
				String fourOutcome = "A: " + testQuestion.choiceOne + " B: " + testQuestion.choiceThree + " C: " + testQuestion.choiceTwo + " D: " + testQuestion.answer;

				String result = one.randomize(testQuestion);
				
				System.out.println(result);
				
				System.out.println(oneOutcome);
				System.out.println(twoOutcome);
				System.out.println(threeOutcome);
				System.out.println(fourOutcome);


				
				assertTrue((result.equals(oneOutcome) || result.equals(twoOutcome) || result.equals(threeOutcome) || result.equals(fourOutcome)));
			}

			//add points test
			@Test 
			void addPoints() {
				int pointsValue = testPlayer.getPoints();
				int addNum = 5;
				testPlayer.addPoints(addNum);
				pointsValue += addNum;
				
				assertEquals(testPlayer.getPoints(), pointsValue);
			}
			
			
			//OBJECT CREATION TESTING 
			
			// create player test
			@Test
			void createPlayer() {
				String username = "test-username";
				int points =0;
				Player newPlayer = new Player(username, points);
				
				assertAll( "Testing created Player",
						() -> assertTrue(username == newPlayer.username),
						() -> assertTrue(points == newPlayer.points));
			}


			//create question test
			@Test 
			void testCreateQuestion() {
				String question = "Question";
				String one = "option1";
				String two = "option2";
				String three = "option3";
				String ans = "answer";
				
				Question newQuestion = new Question(question, ans, one, two, three);
				
				assertAll("Checking all question parameters", 
						()-> assertTrue(ans== newQuestion.answer), 
						()-> assertTrue(question == newQuestion.prompt), 
						()-> assertTrue(one == newQuestion.choiceOne), 
						()-> assertTrue(two == newQuestion.choiceTwo), 
						()-> assertTrue(three == newQuestion.choiceThree)
						);
			}
			
			// test create levels. 
			@Test
			void createLevelOne() {
				Level1 newLevelOne = new Level1();
				
				assertAll("Testing correct level one setup", 
						() -> assertTrue(newLevelOne.levelOneQuestions.length == 6), 
						() -> assertTrue(newLevelOne.levelScore == 	10)
						);
			}
			
			@Test
			void createLevelTwo() {
				Level2 newLevelTwo = new Level2();
				
				assertAll("Testing correct level one setup", 
						() -> assertTrue(newLevelTwo.levelTwoQuestions.length == 6), 
						() -> assertTrue(newLevelTwo.levelScore == 	20)
						);
			}
			
			@Test
			void createLevelThree() {
				Level3 newLevelThree = new Level3();
				
				assertAll("Testing correct level one setup", 
						() -> assertTrue(newLevelThree.levelThreeQuestions.length == 6), 
						() -> assertTrue(newLevelThree.levelScore == 	30)
						);
			}
			
			@Test
			void createLevelFour() {
				Level4 newLevelFour = new Level4();
				
				assertAll("Testing correct level one setup", 
						() -> assertTrue(newLevelFour.levelFourQuestions.length == 6), 
						() -> assertTrue(newLevelFour.levelScore == 	40)
						);
			}
			
			@Test
			void createLevelFive() {
				Level5 newLevelFive = new Level5();
				
				assertAll("Testing correct level one setup", 
						() -> assertTrue(newLevelFive.levelFiveQuestions.length == 6), 
						() -> assertTrue(newLevelFive.levelScore == 	50)
						);
			}

			

}