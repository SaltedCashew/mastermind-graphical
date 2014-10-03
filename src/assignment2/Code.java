/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
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
	private ArrayList<String> code;
	private ArrayList<String> color;
	private int numColors; 
	
	Code(int codeSize, int colors) //
	{  
		numColors = colors;
		numPegs = codeSize;
		color = new ArrayList<String>();
		color.add("B"); //blue
		color.add("G"); //green
		color.add("O"); //orange
		color.add("R"); //red
		color.add("Y"); //yellow
		color.add("P"); //purple
		color.add("K"); //black
		color.add("C"); //cyan
		color.add("M"); //magenta
		color.add("V"); //violet
		
		code = new ArrayList<String>();
	}
 
	/**Generates the computer's secret code. Works for any size code or number of colors.<br>
	 * Secret code stored with Game instance 
	 **/
	public void generateSolution()
	{ 	//should work for any size code or number of colors
		Random r =  new Random();
		for (int i = 0; i < numPegs; i++)
		{
			String codePeg = color.get(r.nextInt(numColors)); //generates a random number between 0 (inclusive) and the color ArrayList size (non-inclusive). gets the value at that index
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
		return new String(code.toString()).replaceAll("[^A-Za-z]", ""); //returns a string of the Color characters only - no brackets or commas, etc
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
				if(tempInput.length()!=numPegs){throw new InputMismatchException();} //throw exception if guess not equal to code size
				for(int i=0; i<numPegs;i++)
				{
					c = tempInput.substring(i, i+1);
					if (color.contains(c) )
					{
						code.add(c); //loop to make changing code length easier. get each char, convert to string, and store in arrayList		
					}
					else{ throw new InputMismatchException(); }
				}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("INVALID GUESS!");
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
		
		ArrayList<String> solCopy = new ArrayList<String>(code.size());
		ArrayList<String> playerCopy = new ArrayList<String>(playerGuess.code.size());
		for(String item: code)
		{
			solCopy.add(item);
		}
		for(String item: playerGuess.code)
		{
			playerCopy.add(item);
		}
		Feedback turnResult = new Feedback();
		int codeSize = numPegs;
		for(int i=0; i<codeSize; i++)
		{ //note: possible error if numPegs != size of either arrayList - add exception here?
			if(solCopy.get(i).equals(playerCopy.get(i)))
			{ //gets both strings at the index and checks if equal 
				turnResult.addBlackPeg();
				solCopy.remove(i);
				playerCopy.remove(i);
				codeSize=codeSize - 1;
				i--;
			}
		}
		
		for(String element: playerCopy) //iterate through playerguess arrayList
		{
			if(solCopy.contains(element)) //if the current element exists in the solution copy, add white peg and remove from solution copy
			{
				turnResult.addWhitePeg(); 
				solCopy.remove(element);
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
