package assignment3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Board 
{
	
	int turnsRemaining;
	final int DEFAULT_TURNS = 12;
	private ArrayList<String> codeHistory;  //stores the codes, but not the feedback
	private ArrayList<String> feedbackHistory; //store the feedback history
	
	public Board()
	{
		codeHistory = new ArrayList<String>();
		feedbackHistory = new ArrayList<String>();
		turnsRemaining = DEFAULT_TURNS;
	}
	
	public Board(int turns)
	{
		codeHistory = new ArrayList<String>();
		feedbackHistory = new ArrayList<String>();
		turnsRemaining = turns;
	}
	
	public void addToCodeHistory(String input){
		codeHistory.add(input);
	}
	
	public void addToFeedbackHistory(String input){
		feedbackHistory.add(input);
	}
	
	//Displays history of the players guesses, along with the results of those guesses
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
				hist.append(" &emsp &emsp " + (index + 1) + "  &nbsp &nbsp &emsp &emsp &emsp &emsp " + (codeHistory.get(index)) + " &emsp &emsp " + (feedbackHistory.get(index)) + "<br>");
			}
			JOptionPane.showMessageDialog(null, hist, "Game History", 0);
		}
	}
	
	/**
	 * Decrements the number of turns in the instance by one
	 * Returns nothing
	 **/
	public void takeTurn(){
		turnsRemaining--;
	}
	
	/**
	 * Returns: turnsRemaining nothing
	 **/
	public int turnsLeft(){
		return turnsRemaining;
	}

	public boolean InHistory(String test) {
		if(codeHistory.contains(test)){return true; }
		return false;
	}

}
