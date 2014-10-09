package assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controls the options for the Mastermind game. 
 * Options currently allow for changing the code size, the number of different colors used, and the number of turns.
 * @author Brad Gray, EE422C
 **/

public class Options
{
	int codeSize;
	int numColors;
	int numTurns;
	boolean reveal;
	
	Options(){
		codeSize = 4;
		numColors = 6;
		numTurns = 12;
		reveal = false;
	}
	
	/**
	 * Main method for setting the options.
	 * Implicit parameter of a options instance.
	 * Requests option settings from the user and sets user determined options within that instance 
	 **/
	public void SetOptions(){
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("\nPress Y to edit game settings. Press any other button to skip:");
		char c = inputScanner.next().charAt(0);
		if(c=='y' || c=='Y')
		{  
			codeSize = getCodeSize();
			numColors = getColors();
			numTurns = getTurns();
			reveal = spoilSecret();
		}
	}
	
	
	/**
	 * Returns the size of the code within the options instance
	 **/
	public int sizeOfCode(){
		return codeSize;
	}
	
	/**
	 * Returns the number of colors being used in the code
	 **/
	public int colorNum(){
		return numColors;
	}
	
	/**
	 * Returns the number of turns in the game
	 * This value is the number of turns remaining, not necessarily the number of turns
	 * the player starts off with.
	 * @return numTurns
	 **/
	public int turns()
	{
		return numTurns;
	}
	
	/**
	 * Decrements the number of turns in the instance by one
	 * Returns nothing
	 **/
	public void takeTurn(){
		numTurns--;
	}
	
	/**
	 * Returns the boolean value on whether the secret solution should be shown or not
	 * True: show the secret solution
	 * False: Don't show the secret solution
	 * @return reveal boolean
	 **/
	public boolean spoilVal(){
		return reveal;
	}
	/*------------- getCodeSize ------------------------/
	 * Takes input on the size of code to use in the game
	 * Sets size to 4 by default, or if invalid entry
	 * Input: nothing
	 * Returns: size size of desired code
	 */
	
	private int getCodeSize()
	{ 
		boolean repeat = true;
		int size = 4; //default
		
		try
		{
			Scanner input = new Scanner(System.in);
			while(repeat == true){
				System.out.println("Would you like to edit the code size? (Y/N)");	
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
	
	private int getColors()
	{ 
		boolean repeat = true;
		int size = 6; //default
		
		try
		{
			Scanner input = new Scanner(System.in);
			while(repeat == true){
				System.out.println("Would you like to edit the number of colors? (Y/N)");	
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
		colorList.add("B for Blue");
		colorList.add("G for Green");
		colorList.add("O for Orange");
		colorList.add("R for Red");
		colorList.add("Y for Yellow");
		colorList.add("P for Purple");
		colorList.add("K for Black");
		colorList.add("C for Cyan");
		colorList.add("M for Maroon");
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
	
	private int getTurns()
	{ 
		boolean repeat = true;
		int size = 12; //default
		
		try
		{
			Scanner input = new Scanner(System.in);
			while(repeat == true){
				System.out.println("Would you like to edit the number of turns? (Y/N)");	
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
	
	
}
