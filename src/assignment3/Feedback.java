/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment3;

/**
 * Feedback class for storing the feedback.
 * For Mastermind, the feedback consists of the number of black pegs and the number of white pegs.
 * Black pegs signify correct colors in the correct position. White pegs signify correct colors in the wrong position.
 * @author Brad Gray and Jake George, EE422C
 **/
public class Feedback
{
	private int numBlackPegs;
	private int numWhitePegs;
	
	Feedback()
	{
		numBlackPegs = 0;
		numWhitePegs = 0;
	}
	
	/**
	 * Add a black peg to the feedback object
	 **/
	public void addBlackPeg()
	{
		numBlackPegs++;
	}
	
	/**
	 * Add a white peg to the feedback object
	 **/
	public void addWhitePeg()
	{
		numWhitePegs++;
	}
	
	/**
	 * Returns the number of black pegs in the feedback object.
	 * The number of black pegs is the number of correct colors in the correct position.
	 * @return numBlackPegs The number of black pegs
	 **/
	public int getBlackPegNum()
	{
		return numBlackPegs;
	}
	
	/**
	 * Returns the number of white pegs in the feedback object.
	 * The number ofwhite pegs is the number of correct colors in the correct position.
	 * @return numWhitePegs The number of white pegs
	 **/
	public int getWhitePegNum()
	{
		return numWhitePegs;
	}
	
	/**
	 * Resets(sets to 0) the number of result pegs in the feedback object 
	 * @author Brad Gray and Jake George, EE422C
	 **/
	public void resetFeedback()
	{
		numWhitePegs = 0;
		numBlackPegs = 0;
	}
	
	/**
	 * Returns the feedback results as a formated string
	 * @author Brad Gray and Jake George, EE422C
	 * @return Output Results as a string: 'x' black peg(s) {@literal &} 'y' white peg(s)
	 **/
	public String toString()
	{
		String Output = new String("" + numBlackPegs + " black peg(s) & " + numWhitePegs + " white peg(s)") ;
		return Output;
	}
}
