/*Student Name: Brad Gray, Jake George
 *EID: bg22946, 
 *Lab Section: 16805
*/

package assignment2;

import java.util.ArrayList;
import java.util.Random;



public class Code
{
	private int numPegs;
	private ArrayList<String> code;
	private ArrayList<String> color;
	
	Code(){
		numPegs = 4;
		color = new ArrayList<String>();
		color.add("B");
		color.add("G");
		color.add("O");
		color.add("R");
		color.add("Y");
		color.add("P");
		code = new ArrayList<String>();
	}
 
	public void GenerateSolution(){
		//Code temp = new Code(); //for now
		//generate random characters (color values) for value of numPegs
		Random r =  new Random();
		for (int i=0; i<numPegs; i++){
			String codePeg = color.get(r.nextInt(color.size()-1));
			code.add(codePeg);
		}
		//can you generate random characters from the characters in color ArrayList?
		return;
	}
	
	public String CodeToString(){
		//String convertedCode = new String(code.toString());
		//System.out.println(convertedCode);
		
		return code.toString();
	}
	
}
