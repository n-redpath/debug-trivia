/*
 * This is the Question class. It defines the properties of an individual question. It defines a method that creates a question, using 
 * the question, answer, and three other incorrect answers. 
 * 
 * Authors:  Mia Collymore Abbas, Nina Redpath, Sarah Willis
 */
import java.util.regex.*;


public class Question {
	String prompt;
	String answer;
	String choiceOne;
	String choiceTwo;
	String choiceThree;
	
	public Question(String prompt, String answer, String choiceOne, String choiceTwo, String choiceThree) {
		this.prompt = prompt;
		this.answer = answer;
		this.choiceOne = choiceOne;
		this.choiceTwo = choiceTwo;
		this.choiceThree = choiceThree;
	}
	
	/*
	 * this function checks whether a user's answer is any of the options. 
	 * @param input, the users response 
	 * @return boolean, true if it is a valid input, false otherwise.
	 * */
	public boolean checkValidInput(String input) {
		Pattern pattern = Pattern.compile("[a-dA-D]");
        Matcher patternMatch = pattern.matcher(input);

		
		if (input.isEmpty() || input.trim().length()==0) {
			return false;
		}
		else if (!patternMatch.matches()) {
			return false;
		}
		else {
			return true;
			}		
	}
	
	
	public String getPrompt() {
		return prompt;
	}
	
	public String getAnswer() {
		return answer;
	}
}

