/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment2;
import java.util.ArrayList;


/**
 * Creates and runs the Mastermind game instance
 * @author Brad Gray and Jake George, EE422C
 **/
public class Game
{  
	private boolean showSol; 
	//private static final int TURNS = 12;
	private int turnCounter;
	private int codeSize;
	private int colorNum;
	private ArrayList<String> codeHistory;  //stores the codes, but not the feedback
	private ArrayList<String> feedbackHist; //store the feedback history
	
	
	Game(boolean showCode, int size, int colors, int numTurns)
	{
		turnCounter = numTurns;
		colorNum = colors;
		codeSize = size;
		if (showCode == true){showSol = true;}
		else {showSol = false;}
		codeHistory = new ArrayList<String>();
		feedbackHist = new ArrayList<String>();
	}
	
	/**
	 * Runs the Mastermind game for the implicit game instance
	 **/
	public void runGame()
	{
		System.out.println("Generating Secret Code...\n"); //change later
		Code solutionCode =  new Code(codeSize, colorNum);
		Code playerGuess = new Code(codeSize, colorNum);
		solutionCode.generateSolution();
		boolean gameOver = false;
		
		final int NO_MORE_TURNS = 0;
		while(gameOver==false && this.turnCounter > NO_MORE_TURNS)
		{
			System.out.println("You have " + turnCounter + " guess(es) remaining.");	
			if (showSol==true){ System.out.println("The solution is: " + solutionCode.codeToString() );}
			
			if(playerGuess.getNextGuess())
			{  //GetNextGuess returns a true value if the input is "History" and false if the input is a valid guess.
				displayHistory();
			}
			else
			{
				System.out.println("Your guess is: "  + playerGuess.codeToString());
				//now we need to compare
				Feedback turnResult = new Feedback(); 
				turnResult = solutionCode.compareCodes(playerGuess);
				System.out.println("The Number of Black Pegs : " + turnResult.getBlackPegNum());
				System.out.println("The Number of White Pegs : " + turnResult.getWhitePegNum());
				codeHistory.add(playerGuess.codeToString());
				feedbackHist.add(turnResult.toString()); //change array list to strings later, convert then store as strings like codehistory?
				turnCounter --;
				if(turnResult.getBlackPegNum() == solutionCode.numberOfPegs())
				{
					gameOver = true;
					displayWinMsg();
				}
				
				System.out.println(" ");
				
				playerGuess.resetCode(); //erases the players guessed code for a clean start
			}
		}
		if(gameOver != true)
		{
			displayLoseMsg(solutionCode);
		}
		
	}
	
	//Displays history of the players guesses, along with the results of those guesses
	private void displayHistory()
	{
		if(codeHistory.size() <= 0)
		{
			System.out.println("\nNo History to show!\n");
		}
		else
		{	
			System.out.println("\nGame History:");
			System.out.println("Turn Number:\t\tGuess:\t\tResult:");
			for(int index = 0; index < codeHistory.size(); index++)
			{
				System.out.println("" + (index + 1) + "\t\t\t" + (codeHistory.get(index)) + "\t\t" + (feedbackHist.get(index)));
			}
			System.out.println(" ");
		}
	}
	
	private void displayWinMsg()
	{
		System.out.println(" ");
		System.out.println("You guessed the secret code! You Win! Do you want to play again?");
		
	}
	
	private void displayLoseMsg(Code solution)
	{
		System.out.println("You failed to guess the secret code! The answer was: " + (solution.codeToString()) + ". You Lose!");
		System.out.println(" ");
	}
	
}


