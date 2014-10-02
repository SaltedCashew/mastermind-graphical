/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment2;

public class Feedback
{
	private int numBlackPegs;
	private int numWhitePegs;
	
	Feedback()
	{
		numBlackPegs = 0;
		numWhitePegs = 0;
	}
	
	public void addBlackPeg()
	{
		numBlackPegs++;
	}
	
	public void addWhitePeg()
	{
		numWhitePegs++;
	}
	
	public int getBlackPegNum()
	{
		return numBlackPegs;
	}
	
	public int getWhitePegNum()
	{
		return numWhitePegs;
	}
	
	public void resetFeedback()
	{
		numWhitePegs = 0;
		numBlackPegs = 0;
	}
	
	public String toString()
	{
		String Output = new String("" + numBlackPegs + " black peg(s) & " + numWhitePegs + " white peg(s)") ;
		return Output;
	}
}
