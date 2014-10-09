/**Student Name: Brad Gray, Jake George
 *EID: bg22946, jag6626
 *Lab Section: 16805
 *Assignment 2 - MasterMind
**/

package assignment3;

import javax.swing.*;

/**
 * Main driver for running the Mastermind program (Assignment 2). Starts the game and prompts with instructions
 * Gets initial game variables from the player, such as if the secret code should be shown or hidden
 * Creates a new game instance and runs the game 
 * @author Brad Gray and Jake George, EE422C
 **/
public class A3Driver {
	
	public static void main(String[] args)
	{
		
		instPrompt();
		
		while(true)
		{
			int choice = JOptionPane.showConfirmDialog(null, "Are you ready to play? (Y/N)", "MasterMind", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				Game masterMind = new Game(true); //boolean to override game option and always show solution
				masterMind.setOptions();
				masterMind.runGame();
			}	
			else 
			{
				JOptionPane.showMessageDialog(null, "OK then. Program terminating...");
				break;
			}	
		}
	}	

	
	/*------------- instPrompt ------------------------/
	 * Static method for displaying the rules to the player
	 * Input: nothing
	 * Returns: nothing
	 */
	
	private static void instPrompt()
	{ 
		
		String msg1 = "<html>The computer will think of a secret code <br>The code consists of a default of 4 different colors.<br><br>";
		msg1 += "The pegs MUST be one of stated colors: default is blue, green, orange, purple, red, or yellow.<br>";
		msg1 += "A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in. <br>";
		msg1 += "After you make a valid guess the result (feedback) will be displayed.<br>";
		msg1 += "The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.<br>";
		msg1 += "For each peg, which is fully incorrect, you get no feedback.<br><br>";
		msg1 += "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.<br>";
		msg1 += "When entering guesses you only need to enter the first character of each color as a capital letter.<br><br>";
		msg1 += "Type \"history\" at any time to see your previous guesses.<br>";
		msg1 += "You have 12 guesses to figure out the secret code or you lose the game.<br>";
		
		JOptionPane.showMessageDialog(null, msg1, "Welcome to MasterMind", JOptionPane.OK_OPTION);
	
	}
	
}