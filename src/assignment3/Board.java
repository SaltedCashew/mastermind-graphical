package assignment3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Creates a board class containing the turn history
 * Contains number of remaining turns and the default number of turns
 * and the colors available for the code
 * @author Brad Gray, EE422C
 * @version 1
 **/
public class Board 
{
	
	private int turnsRemaining;
	private ArrayList<Code> codeHistory;  //stores the codes, but not the feedback
	private ArrayList<Feedback> feedbackHistory; //store the feedback history
	private ArrayList<Colors> availableColors;
	private final int DEFAULT_TURNS = 15;
	
	/**
	 * Creates a board instance with empty code and feedback histories
	 * and the default number of turns.
	 **/
	public Board()
	{
		codeHistory = new ArrayList<Code>();
		feedbackHistory = new ArrayList<Feedback>();
		turnsRemaining = DEFAULT_TURNS;
		availableColors = new ArrayList<Colors>();
	}
	
	/**
	 * Creates a board instance with empty code and feedback histories
	 * and sets the number of turns to the passed parameter.
	 * @param turns The number of desired turns as an integer
	 * @param numColors The number of desired colors to use for the code
	 **/
	public Board(int turns, int numColors)
	{
		codeHistory = new ArrayList<Code>();
		feedbackHistory = new ArrayList<Feedback>();
		turnsRemaining = turns;
		availableColors = new ArrayList<Colors>();
		for(int k = 0; k < numColors; k++)
		{
			availableColors.add(new Colors(Colors.getColor(k)));
		}
	}
	
	/**
	 * Takes the passed string parameter and adds that 
	 * to the code history.
	 * @param input The code as a string.
	 **/
	public void addToCodeHistory(Code input){
		codeHistory.add(new Code(input));
	}
	
	/**
	 * Takes the passed Feedback parameter and adds that 
	 * to the feedback history.
	 * @param input The feedback results as a Feedback object.
	 **/
	public void addToFeedbackHistory(Feedback input){
		feedbackHistory.add(input);
	}
	
	/**
	 * Displays the history and feedback histories in a JOptionPane.
	 * Formats information to a table display
	 **/
	public void displayHistory()
	{
		if(codeHistory.size() <= 0)
		{
			JOptionPane.showMessageDialog(null, "No History to show!");
		}
		else
		{	StringBuilder hist = new StringBuilder("<html>Turn Number: &emsp &emsp Guess: &emsp &emsp Result:<br><br>");
			for(int index = 0; index < codeHistory.size(); index++)
			{ 
				if(index < 9) //different formatting for turns in the 2 digits
				{
				hist.append(" &emsp &emsp " + (index + 1) + "  &nbsp &nbsp &emsp &emsp &emsp &emsp " 
						+ (codeHistory.get(index).codeToString()) + " &emsp &emsp " + (feedbackHistory.get(index).toString()) + "<br>");
				}
				else if (index <= 9) //different formatting for turns in the 2 digits
				{
					hist.append(" &emsp &emsp " + (index + 1) + "  &nbsp &emsp &emsp &emsp &emsp " 
							+ (codeHistory.get(index).codeToString()) + " &emsp &emsp " + (feedbackHistory.get(index).toString()) + "<br>");	
				}
			}
			JOptionPane.showMessageDialog(null, hist, "Game History", 0);
		}
	}
	
	/**
	 * Displays the history and feedback histories in a JOptionPane.
	 * Formats information to a table display
	 **/
	public void displayHelp()
	{
		StringBuilder help = new StringBuilder("<html>The code is built from the following colors:<br>");
		for(Colors c : availableColors)
		{
			help.append(" " + c.toString() + "<br>");
		}
		JOptionPane.showMessageDialog(null, help, "Game Help", 0);
	}
	
	/**
	 * Decrements the number of turns remaining by one.
	 **/
	public void takeTurn(){
		turnsRemaining--;
	}
	
	/**
	 * Returns the number of turns remaining.
	 * @return int: The number of turns remaining before the game is over
	 **/
	public int turnsLeft(){
		return turnsRemaining;
	}

	/**
	 * Checks to see if the passed String parameter is in the code history.
	 * @param test The code to be checked as a string
	 * @return boolean: True if found in the code history; False otherwise
	 **/
	public boolean inHistory(Code test) {
		for(Code code : codeHistory) 
		{
			if(code.codeToString().equals(test.codeToString()))
			{
				return true;
			}
		}
		return false;
	}
}
