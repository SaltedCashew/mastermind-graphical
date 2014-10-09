/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
			temp += p;
		}
		return temp;
	}
	
	/**Asks for and gets next guess from player. Stores guess in implicit Code parameter
	 * @return True if next guess is a request for guess history. False if guess is valid code guess
	 * @throws InputMismatchException if input not equal to Code size or if guess contains invalid colors
	 * 
	 **/	
	public boolean getNextGuess()
	{
		Scanner input = new Scanner(System.in);
		String tempInput = new String(); //using this as the next token
		String c = new String() ;  //c will be a character from the tempInput token
		boolean validEntry = true;
		do
		{
			try
			{
				validEntry=true;
				System.out.println("Please enter your guess: ");
				//if(!input.hasNextLine()){ throw new InputMismatchException();}
				tempInput = input.next();
				if((tempInput.equals("History")) || (tempInput.equals("history")))
				{
					return true;
				}
				if(tempInput.length()!=numPegs){throw new IllegalGuessException("Please ensure you use the correct number of pegs (Code size).");} //throw exception if guess not equal to code size
				for(int i=0; i<numPegs;i++)
				{
					c = tempInput.substring(i, i+1);
					
					code.add(new Pegs(c));
				}
			}
			catch(InputMismatchException ex)
			{
				resetCode();
				validEntry=false;
			}

		}while(validEntry==false);
		return false;
		
	//	input.close(); if close input here, then getnextguess fails on loops
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
		
		for(int i=0; i<codeSize; i++)
		{ 
			for(int k = 0; k < codeSize; k++){
				if(solCopy.get(k).Equals(playerCopy.get(i))) //if both pegs are equal, but positions are not
				{ 
					turnResult.addWhitePeg();
					solCopy.remove(k); //remove from the copy, it's already been included in the feedback
					playerCopy.remove(i); //same as above, no need to check the same peg again
					codeSize=codeSize - 1;
					i--;
				}
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
