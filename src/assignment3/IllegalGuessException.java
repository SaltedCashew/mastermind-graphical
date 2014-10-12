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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1186212468013811525L;

	public IllegalGuessException()
	{
	}

	public IllegalGuessException(String arg0)
	{
		JOptionPane.showMessageDialog(null, arg0);
	}

}
