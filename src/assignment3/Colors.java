package assignment3;

import java.util.ArrayList;
import java.util.Random;

public class Colors
{
	String colorName;
	String colorInit;
	final static int MAX_COLORS = 10;
	final int COLOR_NAME = 6; //start of the color name in the string

	public Colors()
	{  
		String tempColor = new String(GetRandomColor(MAX_COLORS));
		colorInit = new String(tempColor.substring(0,1));
		colorName = new String (tempColor.substring(COLOR_NAME, tempColor.length()));
	}
	
	public Colors(int numColors)
	{  
		String tempColor;
		if (numColors>MAX_COLORS)
		{
			tempColor = new String(GetRandomColor(MAX_COLORS));
		}
		else{
			tempColor = new String(GetRandomColor(numColors));	
		}
		colorInit = new String (tempColor.substring(0,1));
		colorName = new String (tempColor.substring(COLOR_NAME, tempColor.length()));
	}
	
	public String toString_Init(){
		return colorInit;
	}
	
	public String toString_Name(){
		return colorName;
	}
	
	Colors(String s, int numCols){
		ArrayList<String> temp = CreateColors();
		if(temp.contains(s) && temp.indexOf(s) < numCols){
			String tempColor = temp.get(temp.indexOf(s));
			colorInit = tempColor.substring(0,1);
			colorName = tempColor.substring(COLOR_NAME, tempColor.length()); 
		}
		else{throw new IllegalGuessException("Please pick a suitable color (Note: Entries must be in CAPS)"); }
	}
	
	public static String GetColors(int k){
		ArrayList<String> temp = CreateColors();
		return temp.get(k);
	}
	
	public static int MaxColors(){
		return MAX_COLORS;
	}
	
	private static ArrayList<String> CreateColors(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("B for Blue"); //blue
		temp.add("G for Green"); //green
		temp.add("O for Orange"); //orange
		temp.add("R for Red"); //red
		temp.add("Y for Yellow"); //yellow
		temp.add("P for Purple"); //purple
		temp.add("K for Black"); //black
		temp.add("C for Cyan"); //cyan
		temp.add("M for Maroon"); //maroon
		temp.add("V for Violet"); //violet
		return temp;
	}
	
	private String GetRandomColor(int max){
			
		Random r =  new Random();
		int k = r.nextInt(max);
		return GetColors(k);
	}

}
