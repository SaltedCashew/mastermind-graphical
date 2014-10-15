/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment3;
import javax.swing.JOptionPane;


/**
 * Creates and runs the Mastermind game instance
 * @author Brad Gray and Jake George, EE422C
 * @version 2
 **/
public class Game
{  
	private boolean showSol; 
	private Options gameOptions;
	private Board gameBoard;
	
	/**
	 * Constructor for the Game class
	 * @param showCode whether or not to show the solution
	 */
	Game(boolean showCode) //parameters: show solution, code size, number of colors, and number of turns for the game
	{
		gameOptions = new Options(); 
		gameOptions.setOptions();
		
		showSol = showCode == true ? true : false; //using showSol as a hard overwrite for showing the solution
		
		gameBoard = new Board(gameOptions.gameTurns(), gameOptions.gameColors());
	}
	
	
	/**
	 * Prompts the user for desired game options
	 * Stores responses as the game instance options
	 **/
	public void setOptions(){
		gameOptions.setOptions();
	}
	
	/**
	 * Runs the Mastermind game for the implicit game instance
	 **/
	public void runGame()
	{	
		JOptionPane.showMessageDialog(null, "Generating Secret Code...\n Press OK to continue");
		Code solutionCode =  new Code(gameOptions.sizeOfCode(), gameOptions.colorNum());
		Code playerGuess = new Code(gameOptions.sizeOfCode(), gameOptions.colorNum());
		solutionCode.generateSolution();
		boolean gameOver = false;
		
		final int NO_MORE_TURNS = 0;
		while(gameOver==false && gameBoard.turnsLeft() > NO_MORE_TURNS)
		{	
			StringBuilder turnPrompt = new StringBuilder();
			turnPrompt.append("<html>You have " + gameBoard.turnsLeft() + " guess(es) remaining.<br>");
			turnPrompt.append("The code size is " + gameOptions.sizeOfCode() + ".<br><br>");
			
			if (showSol==true || gameOptions.spoilVal()==true)
			{ 
				turnPrompt.append("The solution is: " + solutionCode.codeToString() + "<br>");
			}
			
			boolean request = playerGuess.getNextGuess(turnPrompt); //returns true if "History" or false if a valid guess
			if(request)
			{  //GetNextGuess returns a true value if the input is "History" and false if the input is a valid guess.
				if(playerGuess.getRequest().equals("HISTORY_REQUEST")){	gameBoard.displayHistory(); }
				else if (playerGuess.getRequest().equals("HELP_REQUEST")){	gameBoard.displayHelp(); }
			}
			else if(gameBoard.inHistory(playerGuess))
			{
				JOptionPane.showMessageDialog(null, "You've already guessed that. Try again"); 
				playerGuess.resetCode();
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
				gameBoard.addToCodeHistory(playerGuess);
				gameBoard.addToFeedbackHistory(turnResult);
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
	
	//Just displays a message box when the game is won
	private void displayWinMsg()
	{  
		JOptionPane.showMessageDialog(null, "You guessed the secret code! You win!! Do you want to play again?");
	}
	
	//Displays a message box when the game is lost.
	//Also displays the secret code.
	private void displayLoseMsg(Code solution)
	{
		JOptionPane.showMessageDialog(null, "You failed to guess the secret code! The answer was: " + solution.codeToString() + ". You Lose!");
	}
	
}



