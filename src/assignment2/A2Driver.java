/**Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
 *Assignment 2 - MasterMind
**/

package assignment2;



import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main driver for running the Mastermind program (Assignment 2). Starts the game and prompts with instructions
 * Gets initial game variables from the player, such as if the secret code should be shown or hidden
 * Creates a new game instance and runs the game 
 * @author Brad Gray and Jake George, EE422C
 **/
public class A2Driver {
		
	public static void main(String[] args)
	{
		
		Scanner inputScanner = new Scanner(System.in);
		instPrompt();
		System.out.println("You have 12 guesses to figure out the secret code or you lose the game.");
		while(true)
		{
			try
			{
				System.out.println("Are you ready to play? \n(Y/N):");
				char c = inputScanner.next().charAt(0);
				if(c=='y' || c=='Y')
				{  
					boolean reveal = spoilSecret();
					Game masterMind = new Game(reveal);
					masterMind.runGame();
				}
				else if (c=='n' || c=='N')
				{
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
	
	/*------------- spoilSecret ------------------------/
	 * Takes input on whether to display the secret code to the player
	 * for ease/debugging, or if it should remain hidden.
	 * Input: nothing
	 * Returns: false if the code is to remain hidden, and true otherwise
	 */
	
	private static boolean spoilSecret()
	{
		boolean repeat = true;
		boolean spoil = false;
		
		Scanner input = new Scanner(System.in);
		while(repeat==true){
			System.out.println("Show the Secret Code? (Y/N)");	
			char c = input.next().charAt(0);			
			if(c=='y' || c=='Y')
			{  
				spoil = true;
				repeat = false;
			}
			else if (c=='n' || c=='N')
			{
				spoil = false;
				repeat = false;
			}
			else
			{
				System.out.println("(Y/N) please");
			}
		}
		return spoil;
	}
	
	/*------------- instPrompt ------------------------/
	 * Static method for displaying the rules to the player
	 * Input: nothing
	 * Returns: nothing
	 */
	
	private static void instPrompt()
	{
		System.out.println("Welcome to MasterMind\n");
		System.out.println("The computer will think of a secret code. \nThe code consists of 4 colored pegs. ");
		System.out.println("The pegs MUST be one of six colors: blue, green, orange, purple, red, or yellow.");
		System.out.println("A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in. ");
		System.out.println("After you make a valid guess the result (feedback) will be displayed.");
		System.out.println("The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  ");
		System.out.println(" For each peg in the guess that is the correct color, but is out of position, you get a white peg.");
		System.out.println(" For each peg, which is fully incorrect, you get no feedback.  ");
		
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.  ");
		System.out.println("When entering guesses you only need to enter the first character of each color as a capital letter.");
		System.out.println("  ");
		
	}
	
}
