package assignment3;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

/**
 * Controls the options for the Mastermind game. 
 * Options currently allow for changing the code size, the number of different colors used, and the number of turns.
 * @author Brad Gray, EE422C
 * @version 1
 **/

public class Options
{
	private int codeSize;
	private int numColors;
	private int numTurns;
	private boolean reveal;
	final int CODE_SIZE_DEFAULT = 5;
	final int NUM_COLORS_DEFAULT = 7;
	final int NUM_TURNS_DEFAULT = 15;
	
	Options(){
		codeSize = CODE_SIZE_DEFAULT;
		numColors = NUM_COLORS_DEFAULT;
		numTurns = NUM_TURNS_DEFAULT;
		reveal = false;
	}
	
	/**
	 * Main method for setting the options.
	 * Implicit parameter of a options instance.
	 * Requests option settings from the user and sets user determined options within that instance 
	 **/
	public void setOptions()
	{
		int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the game settings?", "Settings", JOptionPane.YES_NO_OPTION);
		if(input == JOptionPane.YES_OPTION)
		{  
			OptionsForm form = new OptionsForm();
			form.start(codeSize, numColors, numTurns, reveal);
			
		      int result = JOptionPane.showConfirmDialog(null, form, "Set Options", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		      if (result == JOptionPane.OK_OPTION) {
		         form.getInputs();
		         codeSize = form.getCodeSize();
				numColors = form.getColors();
				numTurns = form.getTurns();
				reveal = form.spoilSecret();
		      }
			
		}
	}
	
	
	/**
	 * Returns the size of the code within the options instance
	 * @return codeSize 
	 **/
	public int sizeOfCode()
	{
		return codeSize;
	}
	
	/**
	 * Returns the size of the code within the options instance
	 * @return numTurns
	 **/
	public int gameTurns()
	{
		return numTurns;
	}
	
	/**
	 * @return int The number of colors being used in the code
	 **/
	public int colorNum()
	{
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
	public boolean spoilVal()
	{
		return reveal;
	}
//	/*------------- getCodeSize ------------------------/
//	 * Takes input on the size of code to use in the game
//	 * Sets size to 4 by default, or if invalid entry
//	 * Input: nothing
//	 * Returns: size size of desired code
//	 */
//	
//	private int getCodeSize()
//	{ 
//		int size = CODE_SIZE_DEFAULT; //default
//		
//		try
//		{
//			int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the code size?", "Settings - Code Size", JOptionPane.YES_NO_OPTION);
//			if(input==JOptionPane.YES_OPTION)
//			{  
//				String sizeIn = JOptionPane.showInputDialog(null, "Enter the reasonable, positive code size (otherwise, default will be used)", "Settings - Code Size", JOptionPane.YES_NO_OPTION);
//				size = Integer.parseInt(sizeIn);
//				if(size < 1){ size = CODE_SIZE_DEFAULT;}
//			}
//		}
//		catch(InputMismatchException e)	{	} //catch the exception so it doesn't go elsewhere, causes things to just keep going
//		catch(NumberFormatException ex) { }
//		JOptionPane.showMessageDialog(null, "Now using a code size of " + size);	
//		return size;
//	}
//
//	/*------------- getColors ------------------------/
//	 * Takes input on the number to use in the game
//	 * Sets size to 6 by default, or if invalid entry
//	 * Input: nothing
//	 * Returns: size size of desired code
//	 */
//	
//	private int getColors()
//	{ 
//		int size = NUM_COLORS_DEFAULT; //default
//		
//		try
//		{
//			int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the number of colors used in the code?", "Settings - Color Numbers", JOptionPane.YES_NO_OPTION);
//				if(input == JOptionPane.YES_OPTION )
//				{  
//					String input2 = JOptionPane.showInputDialog(null, "Please enter a number between 1 and " + Colors.maxColors() + " (otherwise, default will be used)", "Settings", JOptionPane.YES_NO_OPTION);
//					size = Integer.parseInt(input2);
//					if(size < 1 || size > Colors.maxColors()){ 
//						size = NUM_COLORS_DEFAULT;}
//				}
//		}
//		catch(InputMismatchException e) { } //catch the exception so it doesn't go elsewhere, causes things to just keep going
//		catch(NumberFormatException ex) { }
//		
//		StringBuilder msg = new StringBuilder("<html>Now using " + size + " different colors<br>");
//		msg.append("The colors are:<br>");
//		for(int k = 0; k<size; k++){
//			msg.append(" " + Colors.getColor(k).toString() + "<br>");
//		}
//		JOptionPane.showMessageDialog(null, msg);
//		return size;
//	}
//
//	/*------------- getTurns ------------------------/
//	 * Takes input on the number to use in the game
//	 * Sets size to 12 by default, or if invalid entry
//	 * Input: nothing
//	 * Returns: size number of turns in the game
//	 */
//	
//	private int getTurns()
//	{ 
//		int size = NUM_TURNS_DEFAULT; 
//		
//		try
//		{	
//			int input = JOptionPane.showConfirmDialog(null, "Would you like to edit the number of turns?", "Settings - Turns", JOptionPane.YES_NO_OPTION);
//			if(input == JOptionPane.YES_OPTION)
//				{  
//					String turnIn = JOptionPane.showInputDialog(null, "Enter a reasonable, positive number of turns (otherwise, default will be used", "Settings - Turns", JOptionPane.YES_NO_OPTION);
//					
//					size = Integer.parseInt(turnIn);
//					if(size < 1){ size = NUM_TURNS_DEFAULT;} 
//				}
//		}
//		catch(InputMismatchException e)	{ } //catch the exception so it doesn't go elsewhere, causes things to just keep going
//		catch(NumberFormatException ex) { }
//		JOptionPane.showMessageDialog(null, "The number of turns is now " + size);
//		return size;
//	}
//	
//	/*------------- spoilSecret ------------------------/
//	 * Takes input on whether to display the secret code to the player
//	 * for ease/debugging, or if it should remain hidden.
//	 * Input: nothing
//	 * Returns: false if the code is to remain hidden, and true otherwise
//	 */
//	private static boolean spoilSecret()
//	{
//		int input = JOptionPane.showConfirmDialog(null, "Show the secret code", "Settings - Spoilers", JOptionPane.YES_NO_OPTION);
//		if(input==JOptionPane.YES_OPTION)	{ return true;	}
//		return false;
//	}

	 /**
	 * Returns the number of colors to be used as entered by the player (or as default)
	 * @return: numColors The selected number of colors
	 */
	public int gameColors()
	{
		return numColors;
	}
	
	
}
