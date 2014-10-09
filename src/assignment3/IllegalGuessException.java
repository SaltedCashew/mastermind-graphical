package assignment3;

import java.util.InputMismatchException;

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
		System.out.println("\n" + arg0);
	}

}
