package assignment3;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 * Controls the options for the Mastermind game. 
 * Options currently allow for changing the code size, the number of different colors used, and the number of turns.
 * @author Brad Gray, EE422C
 **/

public class Options
{
	int codeSize;
	int numColors;
	int numTurns;
	boolean reveal;
	
	Options(){
		codeSize = 4;
		numColors = 6;
		numTurns = 12;
		reveal = false;
	}
	
	/**
	 * Main method for setting the options.
	 * Implicit parameter of a options instance.
	 * Requests option settings from the user and sets user determined options within that instance 
	 **/
	public void SetOptions(){
		int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the game settings?", "Settings", JOptionPane.YES_NO_OPTION);
		if(input ==JOptionPane.YES_OPTION)
		{  
			codeSize = getCodeSize();
			numColors = this.getColors();
			numTurns = getTurns();
			reveal = spoilSecret();
		}
	}
	
	
	/**
	 * Returns the size of the code within the options instance
	 **/
	public int sizeOfCode(){
		return codeSize;
	}
	
	/**
	 * Returns the number of colors being used in the code
	 **/
	public int colorNum(){
		return numColors;
	}
	
	/**
	 * Returns the number of turns in the game
	 * This value is the number of turns remaining, not necessarily the number of turns
	 * the player starts off with.
	 * @return numTurns
	 **/
	public int turns()
	{
		return numTurns;
	}
	

	
	/**
	 * Returns the boolean value on whether the secret solution should be shown or not
	 * True: show the secret solution
	 * False: Don't show the secret solution
	 * @return reveal boolean
	 **/
	public boolean spoilVal(){
		return reveal;
	}
	/*------------- getCodeSize ------------------------/
	 * Takes input on the size of code to use in the game
	 * Sets size to 4 by default, or if invalid entry
	 * Input: nothing
	 * Returns: size size of desired code
	 */
	
	private int getCodeSize()
	{ 
		int size = 4; //default
		
		try
		{
			int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the code size?", "Settings - Code Size", JOptionPane.YES_NO_OPTION);
			if(input==JOptionPane.YES_OPTION)
			{  
				String sizeIn = JOptionPane.showInputDialog(null, "Enter the reasonable, positive code size (otherwise, default will be used)", "Settings - Code Size", JOptionPane.YES_NO_OPTION);
				size = Integer.parseInt(sizeIn);
				if(size < 1){ size = 4;}
			}
		}
		catch(InputMismatchException e)	{	} //catch the exception so it doesn't go elsewhere, causes things to just keep going
		catch(NumberFormatException ex) { }
		JOptionPane.showMessageDialog(null, "Now using a code size of " + size);	
		return size;
	}

	/*------------- getColors ------------------------/
	 * Takes input on the number to use in the game
	 * Sets size to 6 by default, or if invalid entry
	 * Input: nothing
	 * Returns: size size of desired code
	 */
	
	private int getColors()
	{ 
		int size = 6; //default
		
		try
		{
			int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the number of colors used in the code?", "Settings - Color Numbers", JOptionPane.YES_NO_OPTION);
				if(input == JOptionPane.YES_OPTION )
				{  
					String input2 = JOptionPane.showInputDialog(null, "Please enter a number between 1 and 10 (otherwise, 6 will be used)", "Settings - Code Size", JOptionPane.YES_NO_OPTION);
					size = Integer.parseInt(input2);
					if(size < 1 || size > 10){ 
						size = 6;}
				}
		}
		catch(InputMismatchException e) { } //catch the exception so it doesn't go elsewhere, causes things to just keep going
		catch(NumberFormatException ex) { }
		
		StringBuilder msg = new StringBuilder("<html>Now using " + size + " different colors<br>");
		msg.append("The colors are:<br>");
		for(int k = 0; k<size; k++){
			msg.append(" " + Pegs.GetColors(k) + "<br>");
		}
		JOptionPane.showMessageDialog(null, msg);
		return size;
	}

	/*------------- getTurns ------------------------/
	 * Takes input on the number to use in the game
	 * Sets size to 12 by default, or if invalid entry
	 * Input: nothing
	 * Returns: size number of turns in the game
	 */
	
	private int getTurns()
	{ 
		int size = 12; //default
		
		try
		{	
			int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the number of turns?", "Settings - Turns", JOptionPane.YES_NO_OPTION);
			if(input == JOptionPane.YES_OPTION)
				{  
					String turnIn = JOptionPane.showInputDialog(null, "Enter a reasonable, positive number of turns (otherwise, default will be used", "Settings - Turns");
					
					size = Integer.parseInt(turnIn);
					if(size < 1){ size = 12;} //12 is the default value;
				}
		}
		catch(InputMismatchException e)	{ } //catch the exception so it doesn't go elsewhere, causes things to just keep going
		catch(NumberFormatException ex) { }
		JOptionPane.showMessageDialog(null, "The number of turns is now " + size);
		return size;
	}
	
	/*------------- spoilSecret ------------------------/
	 * Takes input on whether to display the secret code to the player
	 * for ease/debugging, or if it should remain hidden.
	 * Input: nothing
	 * Returns: false if the code is to remain hidden, and true otherwise
	 */
	private static boolean spoilSecret()
	{
		int input = JOptionPane.showConfirmDialog(null, "Show the secret code", "Settings - Spoilers", JOptionPane.YES_NO_OPTION);
		if(input==JOptionPane.YES_OPTION)	{ return true;	}
		return false;
	}
	
	
}
