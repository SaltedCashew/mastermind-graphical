package assignment3;
	
/**
	* Creates a peg class
	* Stores the color of the peg and the default number of colors
	* @author Brad Gray, EE422C
	* @version 1
	**/
public class Pegs
{
	private Colors pegColor;
	final int DEFAULT_COLOR_NUM = 6;
	
	/**
	 * Creates a peg with a random color selected from the 
	 * default number of colors
	 **/
	Pegs()
	{	
		pegColor = new Colors(DEFAULT_COLOR_NUM);
	}
	
	/**
	 * Creates a peg with a random color selected from only
	 * the desired number of colors as determined by the passed int parameter
	 * @param int: The number of colors to choose from
	 **/
	Pegs(int num){ //num will be the number of colors to choose from
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
	Pegs(String s, int numCols){
			pegColor = new Colors(s, numCols);
	}
	
	/**
	 * Creates a peg with a random color selected from only
	 * the desired number of colors as determined by the passed int parameter
	 * @return String: The abbreviation of the peg color as a string
	 **/
	public String toString(){
		return pegColor.toString_Init();
	}
	
	/**
	 * Creates a peg with a random color selected from only
	 * the desired number of colors as determined by the passed int parameter
	 * @param test: Pegs object to test against the implicit parameter
	 * @return boolean: True if the two peg objects are equal. False otherwise
	 **/
	public boolean equals(Pegs test){
		if (pegColor.equals(test.pegColor)) { return true;}
		return false;
	}
} 





