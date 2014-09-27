/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment2;
import java.util.ArrayList;



public class Game
{
	private boolean showSol; 
	private int turnCounter;
	private ArrayList<String> codeHistory;  //stores the codes, but not the feedback
	private ArrayList<String> feedbackHist; //store the feedback history
	
	
	Game(boolean showCode){
		turnCounter = 12;
		if (showCode==true){showSol = true;}
		else {showSol = false;}
		codeHistory = new ArrayList<String>();
		feedbackHist = new ArrayList<String>();
	}
	
	void RunGame(){
		System.out.println("Generating Secret Code...\n"); //change later
		Code solutionCode =  new Code();
		Code playerGuess = new Code();
		solutionCode.GenerateSolution();
		boolean gameOver = false;
		
		while(gameOver==false && this.turnCounter >0){
		System.out.println("You have " + turnCounter + " guesses remaining.");	
		if (showSol==true){System.out.println("The solution is: "  + solutionCode.CodeToString());}
		
		if(playerGuess.GetNextGuess()){  //GetNextGuess returns a true value if the input is "History" and false if the input is a valid guess.
			DisplayHistory();
		}
		else{
		System.out.println("Your guess is: "  + playerGuess.CodeToString());
		//now we need to compare
		Feedback turnResult = new Feedback(); 
		turnResult = solutionCode.CompareCodes(playerGuess);
		System.out.println("The Number of Black Pegs : " + turnResult.GetBlackPegNum());
		System.out.println("The Number of White Pegs : " + turnResult.GetWhitePegNum());
		codeHistory.add(playerGuess.CodeToString());
		feedbackHist.add(turnResult.ToString()); //change array list to strings later, convert then store as strings like codehistory?
		turnCounter --;
		if(turnResult.GetBlackPegNum() == solutionCode.NumberOfPegs()){
			gameOver = true;
			DisplayWinMsg();
		}
		
		System.out.println(" ");
		
		playerGuess.ResetCode(); //erases the players guessed code for a clean start
		}
		}
		if(gameOver != true){
			DisplayLoseMsg(solutionCode);
		}
		
		//object created with white pegs and black pegs set to 0
		//or boolean result = solutionCode.CompareCode(playerGuess), where CompareCode returns true if win or false otherwise
		//but, we also need to create the history, so we need the feedback, not just a win or lose boolean
		//compare should be in the feedback class, not code class. determining if win or lose should be in the code class
		
		
		
	}
	
	public void DisplayHistory(){
		if(codeHistory.size() <= 0){
			System.out.println("\nNo History to show!\n");
		}
		else{
			
		System.out.println("\nGame History:");
		System.out.println("Turn Number:\t\tGuess:\t\tResult:");
		for(int index = 0; index < codeHistory.size(); index++){
			System.out.println("" + (index + 1) + "\t\t\t" + (codeHistory.get(index)) + "\t\t" + (feedbackHist.get(index)));
		}
		System.out.println(" ");
		}
	}
	
	
	void DisplayWinMsg(){
		System.out.println(" ");
		System.out.println("You guessed the secret code! You Win! Do you want to play again?");
		
	}
	
	void DisplayLoseMsg(Code solution){
		System.out.println("You failed to guess the secret code! The answer was: " + (solution.CodeToString()) + ". You Lose!");
		System.out.println(" ");
	}
	
	void DisplayPrompt(){
		
	}
	

}


