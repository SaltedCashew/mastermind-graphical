/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 * Class for running the Mastermind program. Starts the game and prompts with instructions
 * Gets initial game variables from the player, such as if the secret code should be shown or hidden. 
 * Creates a new game instance and runs the game
 * Color values can be changed in the constructor, up to a max of 26 
 * @author Brad Gray and Jake George, EE422C
 **/

public class Code
{
	
	private int numPegs; //size of solution
	private ArrayList<Pegs> code;
	private int numColors; 
	
	Code(int codeSize, int colors) //
	{  
		numColors = colors;
		numPegs = codeSize;
		code = new ArrayList<Pegs>();
	}
 
	/**Generates the computer's secret code. Works for any size code or number of colors.<br>
	 * Secret code stored with Game instance 
	 **/
	public void generateSolution()
	{ 	//should work for any size code or number of colors
		for (int i = 0; i < numPegs; i++)
		{
			Pegs codePeg = new Pegs(numColors); //generates peg at random from the number of desired colors
			code.add(codePeg);
		}
		return;
	}
	
	/**Returns the given Code in a String of characters only
	 * @author Brad Gray and Jake George, EE422C
	 * @return Code in string format
	 **/	
	public String codeToString()
	{ 
		String temp = "";
		for(Pegs p : code){
			temp += p.toString();
		}
		return temp;
	}
	
	/**Asks for and gets next guess from player. Stores guess in implicit Code parameter
	 * @return True if next guess is a request for guess history. False if guess is valid code guess
	 * @throws InputMismatchException if input not equal to Code size or if guess contains invalid colors
	 * 
	 **/	
	public boolean getNextGuess(StringBuilder prompt)
	{
		String c = new String() ;  //c will be a character from the tempInput token
		boolean validEntry = true;
		prompt.append("<html>Please enter your guess<br>");
		do
		{
			try
			{
				validEntry=true;
				
				String inGuess = JOptionPane.showInputDialog(null, prompt, "", JOptionPane.YES_NO_OPTION);
				if((inGuess.equals("History")) || (inGuess.equals("history")))
				{
					return true;
				}
				if(inGuess.length()!=numPegs){throw new IllegalGuessException("Please ensure you use the correct number of pegs (Code size).");}
				for(int i=0; i<numPegs;i++)
				{
					c = inGuess.substring(i, i+1);
					code.add(new Pegs(c, numColors));
				}
			}
			catch(InputMismatchException ex)
			{
				resetCode();
				validEntry=false;
			}

		}while(validEntry==false);
		return false;
	}
	
	/**
	 * Compares the implicit code object with the passed parameter code object
	 * @param playerGuess The player's guess as a Code object
	 * @return turnResult Feedback object containing the results of the comparison
	 **/
	public Feedback compareCodes(Code playerGuess)
	{
		
		ArrayList<Pegs> solCopy = new ArrayList<Pegs>(code.size());
		ArrayList<Pegs> playerCopy = new ArrayList<Pegs>(playerGuess.code.size());
		for(Pegs item: code)
		{
			 solCopy.add(item);
		}
		for(Pegs item: playerGuess.code)
		{
			playerCopy.add(item);
		}
		Feedback turnResult = new Feedback();
		int codeSize = numPegs;
		for(int i=0; i<codeSize; i++)
		{ 
			if(solCopy.get(i).Equals(playerCopy.get(i))) //if both pegs are equal
			{ 
				turnResult.addBlackPeg();
				solCopy.remove(i); //remove from the copy, it's already been included in the feedback
				playerCopy.remove(i); //same as above, no need to check the same peg again
				codeSize=codeSize - 1;
				i--;
			}
		}
		
		for(Pegs p : playerCopy){
			for(int k = 0; k < solCopy.size(); k++)
			if(p.Equals(solCopy.get(k))) //if both pegs are equal, but positions are not
			{
				turnResult.addWhitePeg();
				solCopy.remove(p);
				break;
			}
	
		}
		return turnResult;
	}
	
	/**
	 * Returns the size of the solution
	 * @return numPegs The size (number of pegs) of the solution 
	 **/
	public int numberOfPegs()
	{
		return numPegs;
	}
	
	/**
	 * Resets/clears the implicit Code object 
	 **/
	public void resetCode()
	{
		code.clear();
	}
}
