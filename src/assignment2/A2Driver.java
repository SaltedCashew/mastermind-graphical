/*Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
*/

package assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A2Driver {
	
	public static void main(String[] args){
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("You have 12 guesses to figure out the secret code or you lose the game.");
		while(true) {
			try{
				System.out.println("Are you ready to play? \n(Y/N):");
				char c = inputScanner.next().charAt(0);
				if(c=='y' || c=='Y'){  
					boolean reveal = SpoilSecret();
					Game masterMind = new Game(reveal);
					masterMind.RunGame();
				}else if (c=='n' || c=='N'){
					//N
					System.out.println("Ok then");
					break;
				}
				else{throw new InputMismatchException();}		//exception for invalid input	
			}
			catch (InputMismatchException ex){
				System.out.println("\nSeriously? Try again.\n");
		
			}
		
		}
		inputScanner.close();
		
	}	

	private static boolean SpoilSecret(){
		boolean repeat = false;
		boolean spoil = false;
		
		Scanner input = new Scanner(System.in);
		do{
		System.out.println("Show the Secret Code? (Y/N)");	
		char c = input.next().charAt(0);			
		if(c=='y' || c=='Y'){  
			spoil = true;
			repeat = false;
		}else if (c=='n' || c=='N'){
			spoil = false;
			repeat = false;
		}
		else{
			System.out.println("(Y/N) please");
			repeat = true;
		}
		}while(repeat == true);
		return spoil;
	}
	
	
}
