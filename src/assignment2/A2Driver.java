/**Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
 *Assignment 2 - MasterMind
**/

package assignment2;



import java.util.ArrayList;
import java.util.Collection;
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
		
		while(true)
		{
			try
			{
				System.out.println("Are you ready to play? \n(Y/N):");
				char c = inputScanner.next().charAt(0);
				if(c=='y' || c=='Y')
				{  
					int codeSize = getCodeSize();
					int numColors = getColors();
					int numTurns = getTurns();
					boolean reveal = spoilSecret();
					Game masterMind = new Game( reveal, codeSize, numColors, numTurns);
					masterMind.runGame();
				}
				else if (c == 'n' || c == 'N' )
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
	
	/*------------- getCodeSize ------------------------/
	 * Takes input on the size of code to use in the game
	 * Sets size to 4 by default, or if invalid entry
	 * Input: nothing
	 * Returns: size size of desired code
	 */
	
	private static int getCodeSize()
	{ 
		boolean repeat = true;
		int size = 4; //default
		
		try
		{
			Scanner input = new Scanner(System.in);
			while(repeat == true){
				System.out.println("Would you like to change the code size from the default of 4? (Y/N)");	
				char c = input.next().charAt(0);			
				if(c=='y' || c=='Y')
				{  
					System.out.println("Enter the reasonable, postive size code (otherwise, default will be used) ");
					size = input.nextInt();
					if(size < 1){ size = 4;}
					repeat = false;
				}
				else if (c=='n' || c=='N')
				{
					repeat = false;
				}
				else
				{
					System.out.println("(Y/N) please");
				}
			}
		}
		catch(InputMismatchException e)	{	} //catch the exception so it doesn't go elsewhere, causes things to just keep going
		System.out.println("Now using a code size of " + size + "\n");		
		return size;
	}

	/*------------- getColors ------------------------/
	 * Takes input on the number to use in the game
	 * Sets size to 6 by default, or if invalid entry
	 * Input: nothing
	 * Returns: size size of desired code
	 */
	
	private static int getColors()
	{ 
		boolean repeat = true;
		int size = 6; //default
		
		try
		{
			Scanner input = new Scanner(System.in);
			while(repeat == true){
				System.out.println("Would you like to change the number of colors from the default of 6? (Y/N)");	
				char c = input.next().charAt(0);			
				if(c=='y' || c=='Y')
				{  
					System.out.println("Please enter a number between 1 and 10 (otherwise, 6 will be used) ");
					size = input.nextInt();
					if(size < 1 || size > 10){ 
						size = 6;}
					repeat = false;
				}
				else if (c=='n' || c=='N')
				{
					repeat = false;
				}
				else
				{
					System.out.println("(Y/N) please");
				}
			}
		}
		catch(InputMismatchException e) { } //catch the exception so it doesn't go elsewhere, causes things to just keep going
			
		System.out.println("Now using " + size + " different colors\n");	
		ArrayList<String> colorList = new ArrayList<String>(10);
		colorList.add("G for Green");
		colorList.add("O for Orange");
		colorList.add("R for Red");
		colorList.add("Y for Yellow");
		colorList.add("P for Purple");
		colorList.add("K for Black");
		colorList.add("C for Cyan");
		colorList.add("M for Magenta");
		colorList.add("V for Violet");
		
		System.out.println("The colors are:");	
		for (int index = 0; index < size; index++)
		{
			System.out.println(colorList.get(index));	
		}	
		System.out.println("\n");
		return size;
	}

	/*------------- getTurns ------------------------/
	 * Takes input on the number to use in the game
	 * Sets size to 12 by default, or if invalid entry
	 * Input: nothing
	 * Returns: size number of turns in the game
	 */
	
	private static int getTurns()
	{ 
		boolean repeat = true;
		int size = 12; //default
		
		try
		{
			Scanner input = new Scanner(System.in);
			while(repeat == true){
				System.out.println("Would you like to change the number of turns from the default of 12? (Y/N)");	
				char c = input.next().charAt(0);			
				if(c=='y' || c=='Y')
				{  
					System.out.println("Enter a reasonable, postive number of turns (otherwise, default will be used) ");
					size = input.nextInt();
					if(size < 1){ size = 12;} //12 is the default value;
					repeat = false;
				}
				else if (c=='n' || c=='N')
				{
					repeat = false;
				}
				else
				{
					System.out.println("(Y/N) please");
				}
			}
		}
		catch(InputMismatchException e)	{ } //catch the exception so it doesn't go elsewhere, causes things to just keep going
		System.out.println("The number of turns is now " + size + "\n");		
		return size;
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
		System.out.println("The computer will think of a secret code. \nThe code consists of a default of 4 colored pegs. ");
		System.out.println("The size of the code can be changed!");
		System.out.println("The pegs MUST be one of stated colors: default is blue, green, orange, purple, red, or yellow.");
		System.out.println("The number of colors can be changed!\n");
		System.out.println("A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in. ");
		System.out.println("After you make a valid guess the result (feedback) will be displayed.");
		System.out.println("The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  ");
		System.out.println("For each peg in the guess that is the correct color, but is out of position, you get a white peg.");
		System.out.println("For each peg, which is fully incorrect, you get no feedback. \n");
		
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.  ");
		System.out.println("When entering guesses you only need to enter the first character of each color as a capital letter.");
		System.out.println("  ");
		System.out.println("You have 12 guesses to figure out the secret code or you lose the game.");
		System.out.println("(This can be changed too!)\n");
		
		
		
	}
	
}
