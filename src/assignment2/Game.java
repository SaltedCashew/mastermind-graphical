/*Student Name: Brad Gray, Jake George
 *EID: bg22946, 
 *Lab Section: 16805
*/

package assignment2;
import java.util.ArrayList;
import java.util.Scanner;



public class Game
{
	
//	private int turnCounter;
	private ArrayList<String> codeHistory;
	
	
	Game(boolean showCode){
	//	turnCounter = 12;
	}
	
	void RunGame(){
		
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
	
	public static void main(String[] args){
		
		Scanner inputScanner = new Scanner(System.in); 

		System.out.println("You have 12 guesses to figure out the secret code or you lose the game. Are you ready to play? \n(Y/N):");
		String playerInput = inputScanner.nextLine();
		char c = playerInput.charAt(0);
		inputScanner.close();
		System.out.println(c);
		if(c=='y' || c=='Y'){
			Game masterMind = new Game(true);
			masterMind.RunGame();
		}
		
	}

}


