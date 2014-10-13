package assignment3;

import java.util.ArrayList;
import java.util.Random;


/**
 * Colors for use with the mastermind game. 
 * Number of available colors can be changed in this class
 * Currently 10 available colors
 * @author Brad Gray, EE422C
 * @version 2
 **/
public class Colors
{
	private String colorName;
	private String colorInit;
	final static int MAX_COLORS = 10;

	/**
	 * Basic constructor. 
	 * Creates an empty color
	 **/
	public Colors()
	{  
		Colors tempColor = getRandomColor(MAX_COLORS);
		colorInit = tempColor.colorInit;
		colorName = tempColor.colorName;
	}
	
	
	/**
	 * Creates a color copy of the passed Colors parameter
	 * @param c The Colors object to be copied
	 **/
	public Colors (Colors c){
		colorInit = c.colorInit;
		colorName = c.colorName;
	}
	
	/**
	 * Creates a color selected randomly from the available colors.
	 * Limits the available colors to the input parameter.
	 * @param numColors A limit on the number of available colors - e.g. only choose from 2 colors
	 **/
	public Colors(int numColors)
	{  
		Colors tempColor;
		if (numColors>MAX_COLORS || numColors < 0)
		{
			tempColor = getRandomColor(MAX_COLORS);
		}
		else{
			tempColor = getRandomColor(numColors);	
		}
		colorInit = tempColor.colorInit;
		colorName = tempColor.colorName;
	}
	
	/**
	 * Creates a color object based off of the desired string parameter.
	 * Limits the available colors to the input parameter.
	 * @param numCols A limit on the number of available colors - e.g. only choose from 2 colors
	 * @param s The desired color as a string - e.g. "B" will create a blue color object
	 * @throws IllegalGuessException Throws if the desired color isn't an available color 
	 **/
	public Colors(String s, int numCols){
		ArrayList<Colors> colorList = createColors();
		boolean found = false;
		for(int k = 0; k < numCols; k++){
			if(colorList.get(k).colorInit.equals(s))
			{
				colorInit = colorList.get(k).colorInit;
				colorName = colorList.get(k).colorName;
				found = true;
				break;
			}
		}

		if (found == false){ throw new IllegalGuessException("Please pick a suitable color (Note: Entries must be in CAPS)"); }
	}
	
	/**
	 * Creates a color object on demand.
	 * No checking/verification offered. 
	 * @param colorInitial The first initial of the color as a string
	 * @param cName The full name of the color as a string
	 **/
	public Colors(String colorInitial, String cName){
		colorInit = colorInitial;
		colorName = cName;
	}
	
	/**
	 * Color object to String method
	 * Takes the implicit color object and returns a formated string
	 * @return string "color_initial : color_name" 
	 **/
	public String toString(){
		return new String ("" + colorInit + " : " + colorName);
	}
	
	/**
	 * Color object to String method
	 * Takes the implicit color object and returns only the color initial
	 * @return String : The first initial of the color
	 **/
	public String toString_Init(){
		return colorInit;
	}


	/**
	 * Returns the max number of available colors
	 * @return int : The maximum number of available colors
	 **/
	public static int maxColors(){
		return MAX_COLORS;
	}
	
	
	/*
	 * Creates 2 arraylists of colors
	 * first contains the names; 2nd contains the initials
	 * Uses these two array to create an arraylist of color objects
	 * Returns this arraylist of color objects
	 * Available colors can be changed easily here
	 */
	private static ArrayList<Colors> createColors()
	{
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Blue"); //blue
		temp.add("Green"); //green
		temp.add("Orange"); //orange
		temp.add("Red"); //red
		temp.add("Yellow"); //yellow
		temp.add("Purple"); //purple
		temp.add("Maroon"); //maroon
		temp.add("Black"); //black
		temp.add("Cyan"); //cyan
		temp.add("Violet"); //violet
		ArrayList<String> temp2 = new ArrayList<String>();
		temp2.add("B"); //blue
		temp2.add("G"); //green
		temp2.add("O"); //orange
		temp2.add("R"); //red
		temp2.add("Y"); //yellow
		temp2.add("P"); //purple
		temp2.add("M"); //maroon
		temp2.add("K"); //black
		temp2.add("C"); //cyan
		temp2.add("V"); //violet
		ArrayList<Colors> colorList = new ArrayList<Colors>();
		for(int k = 0; k < temp.size(); k++){
			colorList.add(new Colors(temp2.get(k), temp.get(k)) );
		}
		
		return colorList;
	}
	
	/*
	 * Input parameter max is the limit of colors desired
	 * allows for selecting a max less than the total available colors
	 * Chooses a random integer k between 0 and the max parameter
	 * returns the color object at index k of the color object arraylist
	 */
	private Colors getRandomColor(int max){
		
		Random r =  new Random();
		int k = r.nextInt(max);
		return getColor(k);
	}
	
	/**
	 * Returns the color object at index k
	 * @param k Index/Key of desired color
	 * @return The color object at location k 
	 **/
	public static Colors getColor(int k){
		ArrayList<Colors> temp = createColors();
		return temp.get(k);
	}
	
	/**
	 * Returns true if the implicit color object contains the same color value as the passed color object parameter
	 * @param test Color object for testing against the implicit parameter
	 * @return boolean 
	 **/
	public boolean equals(Colors test){
		if(colorInit.equals(test.colorInit)){
			return true;
		}
		return false;
	}

}
