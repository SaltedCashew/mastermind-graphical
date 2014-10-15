package assignment3;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;


/**
 * Custom exception for the mastermind game. 
 * Allows for exception when an invalid guess is made
 * @author Brad Gray, EE422C
 * @version 1
 */
public class IllegalGuessException extends InputMismatchException
{

	private static final long serialVersionUID = 1186212468013811525L;

	/**
	 * Basic Exception Constructor
	 * Does nothing by itself
	 **/
	public IllegalGuessException()
	{
	}

	/**
	 * Displays a JOPtionPane message box with the supplied parameter string as the message
	 * @param arg The message to display as a String
	 **/
	public IllegalGuessException(String arg)
	{
		JOptionPane.showMessageDialog(null, arg);
	}

}
