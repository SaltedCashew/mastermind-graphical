/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment3;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * Creates and runs the Mastermind game instance
 * @author Brad Gray and Jake George, EE422C
 **/
public class Game
{  
	private boolean showSol; 
	Options gameOptions;
	//private static final int TURNS = 12;
	private ArrayList<String> codeHistory;  //stores the codes, but not the feedback
	private ArrayList<String> feedbackHist; //store the feedback history
	
	
	Game(boolean showCode) //parameters: show solution, code size, number of colors, and number of turns for the game
	{
		gameOptions = new Options(); 
		if (showCode == true){showSol = true;}
		else {showSol = false;} //using showSol as a hard overwrite for showing the solution
		codeHistory = new ArrayList<String>();
		feedbackHist = new ArrayList<String>();
	}
	
	
	/**
	 * Promts the user for desired game options
	 **/
	
	public void setOptions(){
		gameOptions.SetOptions();
	}
	
	/**
	 * Runs the Mastermind game for the implicit game instance
	 **/
	public void runGame()
	{	JOptionPane.showMessageDialog(null, "Generating Secret Code...");
		Code solutionCode =  new Code(gameOptions.sizeOfCode(), gameOptions.colorNum());
		Code playerGuess = new Code(gameOptions.sizeOfCode(), gameOptions.colorNum());
		solutionCode.generateSolution();
		boolean gameOver = false;
		
		final int NO_MORE_TURNS = 0;
		while(gameOver==false && gameOptions.turns() > NO_MORE_TURNS)
		{	StringBuilder turnPrompt = new StringBuilder();
			turnPrompt.append("<html>You have " + gameOptions.turns() + " guess(es) remaining.<br>");
			if (showSol==true || gameOptions.spoilVal()==true)
			{ 
				turnPrompt.append("The solution is: " + solutionCode.codeToString() + "<br>");
			}
			
			if(playerGuess.getNextGuess(turnPrompt))
			{  //GetNextGuess returns a true value if the input is "History" and false if the input is a valid guess.
				displayHistory();
			}
			else
			{
				StringBuilder guessResponse = new StringBuilder();
				guessResponse.append("<html>Your guess is: " + playerGuess.codeToString() + "<br>");
				//now we need to compare
				Feedback turnResult = new Feedback(); 
				turnResult = solutionCode.compareCodes(playerGuess);
				guessResponse.append("The number of Black Pegs : " + turnResult.getBlackPegNum() + "<br>");
				guessResponse.append("The Number of White Pegs :  " + turnResult.getWhitePegNum() + "<br>");
				JOptionPane.showMessageDialog(null, guessResponse);
				codeHistory.add(playerGuess.codeToString());
				feedbackHist.add(turnResult.toString()); //change array list to strings later, convert then store as strings like codehistory?
				gameOptions.takeTurn();
				if(turnResult.getBlackPegNum() == solutionCode.numberOfPegs())
				{
					gameOver = true;
					displayWinMsg();
				}
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
			JOptionPane.showMessageDialog(null, "No History to show!");
		}
		else
		{	StringBuilder hist = new StringBuilder("<html>Turn Number: &emsp &emsp Guess: &emsp &emsp Result:<br><br>");
			for(int index = 0; index < codeHistory.size(); index++)
			{
				hist.append(" &emsp &emsp " + (index + 1) + "  &nbsp &nbsp &emsp &emsp &emsp &emsp " + (codeHistory.get(index)) + " &emsp &emsp " + (feedbackHist.get(index)) + "<br>");
			}
			JOptionPane.showMessageDialog(null, hist, "Game History", 0);
		}
	}
	
	private void displayWinMsg()
	{  
		JOptionPane.showMessageDialog(null, "You guessed the secret code! You win!! Do you want to play again?");
	}
	
	private void displayLoseMsg(Code solution)
	{
		JOptionPane.showMessageDialog(null, "You failed to guess the secret code! The answer was: " + solution.codeToString() + ". You Lose!");
	}
	
}


