/*Student Name: Brad Gray, Jake George
 *EID: bg22946, 
 *Lab Section: 16805
*/

package assignment2;
import java.util.ArrayList;
import java.util.Scanner;



public class Game
{
	private boolean showSol; 
	private int turnCounter;
	private ArrayList<String> codeHistory;
	
	
	Game(boolean showCode){
		turnCounter = 12;
		if (showCode==true){showSol = true;}
		else {showSol = false;}
	}
	
	void RunGame(){
		System.out.println("Staring the Game!"); //just seeing if it works
		Code solutionCode =  new Code();
		solutionCode.GenerateSolution();
		System.out.println("The solution is: "  + solutionCode.CodeToString());
	}
	
	public void DisplayHistory(){
		
	}
	
	String GenerateHistory(String code){ //add feedback input object later
	String temp = "";
	return temp;
		
	}
	
	void DisplayWinMsg(){
		
	}
	
	void DisplayLoseMsg(){
		
	}
	
	void DisplayPrompt(){
		
	}
	

}


