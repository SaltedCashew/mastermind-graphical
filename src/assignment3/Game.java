/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment3;
import javax.swing.JOptionPane;


/**
 * Creates and runs the Mastermind game instance
 * @author Brad Gray and Jake George, EE422C
 **/
public class Game
{  
	private boolean showSol; 
	Options gameOptions;
	Board gameBoard;
	
	Game(boolean showCode) //parameters: show solution, code size, number of colors, and number of turns for the game
	{
		gameOptions = new Options(); 
		if (showCode == true){showSol = true;}
		else {showSol = false;} //using showSol as a hard overwrite for showing the solution
		gameBoard = new Board(gameOptions.numTurns);
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
		while(gameOver==false && gameBoard.turnsLeft() > NO_MORE_TURNS)
		{	StringBuilder turnPrompt = new StringBuilder();
			turnPrompt.append("<html>You have " + gameOptions.turns() + " guess(es) remaining.<br>");
			if (showSol==true || gameOptions.spoilVal()==true)
			{ 
				turnPrompt.append("The solution is: " + solutionCode.codeToString() + "<br>");
			}
			if(playerGuess.getNextGuess(turnPrompt))
			{  //GetNextGuess returns a true value if the input is "History" and false if the input is a valid guess.
				gameBoard.displayHistory();
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
				gameBoard.addToCodeHistory(playerGuess.codeToString());
				gameBoard.addToFeedbackHistory(turnResult.toString());
				gameBoard.takeTurn();
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
	

	
	private void displayWinMsg()
	{  
		JOptionPane.showMessageDialog(null, "You guessed the secret code! You win!! Do you want to play again?");
	}
	
	private void displayLoseMsg(Code solution)
	{
		JOptionPane.showMessageDialog(null, "You failed to guess the secret code! The answer was: " + solution.codeToString() + ". You Lose!");
	}
	
}



