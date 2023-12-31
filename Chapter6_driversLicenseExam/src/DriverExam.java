import java.util.Scanner;

public class DriverExam {

	public static void main(String[] args) {
		//Instantiated variables to hold returned values from methods
		boolean hasPassed;
		int totalCorrect;
		int totalIncorrect;
		String[] userAnswers;
		int[] missedQuestions;
		//Called methods and and saved their returned values to their corresponding variable
		userAnswers = getUserAnswer();
		totalCorrect = getTotalCorrect(userAnswers);
		totalIncorrect = getTotalIncorrect(userAnswers);
		hasPassed = passed(totalCorrect);
		missedQuestions = getQuestionsMissed(userAnswers);
		//Called a method to display the results of returned from called methods
		displayResults(hasPassed, totalCorrect, totalIncorrect, missedQuestions);
	}
	
	/* [Displays the calculated data to the user through the console] */
	static void displayResults(boolean hasPassed, int totalCorrect, int totalIncorrect, int[] missedQuestions){
		//Displays the calculated results of the program to the user
		System.out.println("\n----------------------------------------------------");
		System.out.println();
		System.out.print("You " + (hasPassed == true? "passed ": "failed ") + "with a " + totalCorrect + "/" + (totalCorrect+totalIncorrect) + ".");
		System.out.println();
		
		//Checks if the user missed a question
		if (totalCorrect != 20) {//1st if statement
			//Tells the user that the questions they got wrong will be displayed
			System.out.print("The questions you got wrong are question(s): ");
			//Runs through the missed questions array to get the questions missed
			for (int i = 0; i < missedQuestions.length; i++) {//1st for loop
				if (missedQuestions[i] != 0) {//2nd if statement
					//Displays the number of the missed question
					System.out.print( "[" + missedQuestions[i]  + "] ");
				}//closes 2nd if statement
			}//1st for loop
		}//closes 1st if statement
	}//closes displayResults methods
	/* [Prompt user to insert values (represented as answer choices) and returns those values in an array] */
	static String[] getUserAnswer() {
		//Created a Scanner object to take the user's input
		Scanner userInput = new Scanner(System.in);
		//Initializes an array to hold the user inputed answers
		String[] userAnswers = new String[20];
		//Initialized a variable to be used to save the user's input
		String inputedAns = "empty";
		
		//loops 20 times to get 20 user inputed answers
		for (int i = 0; i < userAnswers.length; i++) {//1st for-loop
			//prompts the user to enter an answer from an exam
			System.out.print("Please enter the answer of question " + (i+1) + ".\n>> ");
			//Checks if the user did not type a valid answer typed a valid answer
				//first while loop
			while ( !inputedAns.equals("a") && !inputedAns.equals("b") && !inputedAns.equals("c") && !inputedAns.equals("d") ) {
				//Gets the user's input and saves it to the variable inputedAns
				inputedAns = userInput.nextLine();
				//Checks if the user has not entered valid answer choices...
					//Give the user an error message and tells them valid inputs
					//first if statement
				//saves the lowercase value of what inputedAns is
				inputedAns = inputedAns.toLowerCase();
				//Checks if the inputed value is a valid answer
				if ( inputedAns.equals("a") || inputedAns.equals("b") || inputedAns.equals("c") || inputedAns.equals("d") ) {
					//sets the current index of userAnswers to the value of inputedAns
					userAnswers[i] = inputedAns;
				}//closes if statement
				else {//1st else statement
					//Displays a message listing valid inputs
					System.out.println();
					System.out.print("Please enter one of the four options: A, B, C, or D \n>> ");
				}//closes 1st else statement
				System.out.println("");
			}//closes 1st while loop	
			inputedAns = "empty";
		}//closes 1st for-loop
		//Closes the Scanner object
		userInput.close();
		return userAnswers;
	}
	/* [Checks to see if the user passed or failed the exam and returns the result as a boolean] */
	static boolean passed(int numOfCorrectAnswers) {
		boolean userPassed = false;
		//Checks if the user passed
		if (numOfCorrectAnswers >= 15) {//2nd if statement
			//sets that the user passed to true
			userPassed = true;
		}//closes 2nd if statement
		return userPassed;	
	}
	/* [Calculates and returns how many questions the user got correct] */
	static int getTotalCorrect(String[] answerArray) {
		final String[] correctAnswers = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
		//Initialized variables to hold calculated information
		int cAnswers = 0;//correct Answers
		//Loops 20 times to compare the values of both array's current indexes
		for (int i = 0; i < correctAnswers.length; i++) {//1st for-loop
			//Checks if the current index of both arrays have the same value
			//System.out.println("Index 0: " + correctAnswers[i].toLowerCase());
			if (answerArray[i].equals(correctAnswers[i].toLowerCase())) {//1st if statement
				//Adds 1 to the variable containing the count of correct answers
				cAnswers++;
			}//closes if statement
		}//closes for loop
		return cAnswers;
	}//closes totalCorrect method
	/* [Calculates and returns how many questions the user got incorrect] */
	static int getTotalIncorrect(String[] answerArray) {
		final String[] correctAnswers = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
		//Initialized variables to hold calculated information
		int inAnswers = 0;//correct Answers
		//Loops 20 times to compare the values of both array's current indexes
		for (int i = 0; i < correctAnswers.length; i++) {//1st for-loop
			//Checks if the current index of both arrays have the same value
			//System.out.println("Index 0: " + correctAnswers[i].toLowerCase());
			if (!answerArray[i].equals(correctAnswers[i].toLowerCase())) {//1st if statement
				//Adds 1 to the variable containing the count of correct answers
				inAnswers++;
			}//closes if statement
		}//closes for loop
		return inAnswers;
	}//closes totalIncorrect method
	/* [Check which questions the user got wrong and saves and returns those values in an array] */
	static int[] getQuestionsMissed(String[] answerArray) {
		final String[] correctAnswers = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
		int[] missedQ = new int[correctAnswers.length];
		//Loops 20 times to compare the values of both array's current indexes
		for (int i = 0; i < correctAnswers.length; i++) {//1st for-loop
			//Checks if the current index of both arrays have the same value
			//System.out.println("Index 0: " + correctAnswers[i].toLowerCase());
			if (!answerArray[i].equals(correctAnswers[i].toLowerCase())) {//1st if statement
				//Adds 1 to the variable containing the count of correct answers
				missedQ[i] = i;
			}//closes if statement
		}//closes for loop
		return missedQ;
	}//closes questionsMissed method

}
