package assignment3;

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
	private final int CODE_SIZE_DEFAULT = 5;
	private final int NUM_COLORS_DEFAULT = 7;
	private final int NUM_TURNS_DEFAULT = 15;
	
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
		      
		    if(numColors!=NUM_COLORS_DEFAULT)
		    {
		   	displayColorsUsed(numColors);
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
	
	 /**
	 * Returns the number of colors to be used as entered by the player (or as default)
	 * @return: numColors The selected number of colors
	 */
	public int gameColors()
	{
		return numColors;
	}
	
	/*
	 * Static method to display the colors being used
	 */
	private static void displayColorsUsed(int numColors){
		 StringBuilder msg = new StringBuilder("<html>Now using " + numColors + " different colors<br>");
	 		msg.append("The colors are:<br>");
		 		for(int k = 0; k<numColors; k++){
		 			msg.append(" " + Colors.getColor(k).toString() + "<br>");
		 		}
		 		JOptionPane.showMessageDialog(null, msg);
	}
}
