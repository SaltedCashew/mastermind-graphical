/*Student Name: Brad Gray, Jake George
 *EID: bg22946, 
 *Lab Section: 16805
*/

package assignment2;
import java.util.ArrayList;
import java.util.Scanner;



public class Game
{
	private boolean showSol; 
	private int turnCounter;
	private ArrayList<String> codeHistory;  //stores the codes, but not the feedback
	private ArrayList<Feedback> feedbackHist; //store the feedback history
	
	
	Game(boolean showCode){
		turnCounter = 12;
		if (showCode==true){showSol = true;}
		else {showSol = false;}
		codeHistory = new ArrayList<String>();
		feedbackHist = new ArrayList<Feedback>();
	}
	
	void RunGame(){
		System.out.println("Starting the Game!"); //change later
		Code solutionCode =  new Code();
		Code playerGuess = new Code();
		solutionCode.GenerateSolution();
		boolean gameOver = false;
		
		
		System.out.println("The solution is: "  + solutionCode.CodeToString());
		playerGuess.GetNextGuess();
		System.out.println("Your guess is: "  + playerGuess.CodeToString());
		//now we need to compare
		Feedback turnResult = new Feedback(); 
		turnResult = solutionCode.CompareCodes(playerGuess);
		System.out.println("The Number of Black Pegs (Game Class): " + turnResult.GetBlackPegNum());
		System.out.println("The Number of White Pegs (Game Class): " + turnResult.GetWhitePegNum());
		codeHistory.add(playerGuess.CodeToString());
		feedbackHist.add(turnResult); //change array list to strings later, convert then store as strings like codehistory?
		turnCounter --;
		gameOver = playerGuess.DetermineStatus(turnResult);
		System.out.println(" ");
		
		
		
		//object created with white pegs and black pegs set to 0
		//or boolean result = solutionCode.CompareCode(playerGuess), where CompareCode returns true if win or false otherwise
		//but, we also need to create the history, so we need the feedback, not just a win or lose boolean
		//compare should be in the feedback class, not code class. determining if win or lose should be in the code class
		
		
		
	}
	
	public void DisplayHistory(){
		
	}
	
	String GenerateHistory(String code){ //add feedback input object later
	String temp = "";
	return temp;
		
	}
	
	void DisplayWinMsg(){
		
	}
	
	void DisplayLoseMsg(){
		
	}
	
	void DisplayPrompt(){
		
	}
	

}


