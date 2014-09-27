/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment2;

public class Feedback
{
	private int numBlackPegs;
	private int numWhitePegs;
	
	Feedback(){
		numBlackPegs = 0;
		numWhitePegs = 0;
	}
	
	public void AddBlackPeg(){
		numBlackPegs++;
	}
	
	public void AddWhitePeg(){
		numWhitePegs++;
	}
	
	public int GetBlackPegNum(){
		return numBlackPegs;
	}
	
	public int GetWhitePegNum(){
		return numWhitePegs;
	}
	
	public void ResetFeedback(){
		numWhitePegs = 0;
		numBlackPegs = 0;
	}
	
	public String ToString(){
		String Output = new String("" + numBlackPegs + " black peg(s) & " + numWhitePegs + " white peg(s)") ;
		return Output;
	}
}
