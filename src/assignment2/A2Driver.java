/*Student Name: Brad Gray, Jake George
 *EID: bg22946, 
 *Lab Section: 16805
*/

package assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A2Driver {
	
	public static void main(String[] args){
		
		Scanner inputScanner = new Scanner(System.in);
		boolean validStart = true;
		
		do {
			try{
				validStart = true;
				System.out.println("You have 12 guesses to figure out the secret code or you lose the game. Are you ready to play? \n(Y/N):");
				//	char playerInput = inputScanner.next();
				char c = inputScanner.next().charAt(0);
				
				System.out.println(c);
				if(c=='y' || c=='Y'){  //create exception for invalid input?
					Game masterMind = new Game(true);
					masterMind.RunGame();	
				}else if (c=='n' || c=='N'){
					System.out.println("Goodbye");
				}else{throw new InputMismatchException();}			
			}
			catch (InputMismatchException ex){
				System.out.println("Seriously? Try again.");
				validStart = false;
			}
			finally{
		
			}
		
		}while(validStart==false);
		inputScanner.close();
	}	
}
