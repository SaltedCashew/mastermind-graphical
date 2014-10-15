package assignment3;
	
/**
	* Peg class for storing the peg color
	* @author Brad Gray, EE422C
	* @version 1
	**/
public class Pegs
{
	private Colors pegColor;
	
	/**
	 * Creates a new, empty peg
	 **/
	Pegs()
	{	
		pegColor = new Colors();
	}
	
	/**
	 * Creates a peg with a random color selected from only
	 * the desired number of colors as determined by the passed int parameter
	 * @param int: The number of colors to choose from
	 **/
	Pegs(int num)
	{ //num will be the number of colors to choose from
		pegColor = new Colors(num);
	}
	
	/**
	 * Creates a peg with the desired color, as long as that color
	 * is available from the number of colors as determined by the
	 * passed int parameter.
	 * The desired color string should only be the first initial of the color.
	 * @parameter s The desired color initial as a string 
	 * @param numCols The number of colors to choose from as an int
	 **/
	Pegs(String s, int numCols)
	{
			pegColor = new Colors(s, numCols);
	}
	
	/**
	 * Returns the peg color as a String.
	 * String will be the initial/abbreviation of the color only
	 * @return String: The abbreviation of the peg color as a string
	 **/
	public String toString()
	{
		return pegColor.toString_Init();
	}
	
	/**
	 * Checks the equality of two peg objects
	 * @param test: Pegs object to test against the implicit parameter
	 * @return boolean: True if the two peg objects are equal. False otherwise
	 **/
	public boolean equals(Pegs test)
	{
		return pegColor.equals(test.pegColor);
	}
} 





