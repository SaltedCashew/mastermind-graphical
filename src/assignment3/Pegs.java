package assignment3;

import java.util.ArrayList;
import java.util.Random;

public class Pegs
{
	private String pegColor;
	private static ArrayList<String> colors = new ArrayList<String>();
	final int DEFAULT_COLOR_NUM = 6;
	
	Pegs()
	{	
		CreateColors();
		Random r =  new Random();
		pegColor = colors.get(r.nextInt(DEFAULT_COLOR_NUM)); //generates a random number between 0 (inclusive) and the color ArrayList size (non-inclusive). gets the value at that index
		return;
	}
	
	Pegs(int num){ //num will be the number of colors to choose from
		CreateColors();
		Random r =  new Random();
		if(num>colors.size()){ num = DEFAULT_COLOR_NUM;} 
		pegColor = colors.get(r.nextInt(num)); //generates a random number between 0 (inclusive) and the color ArrayList size (non-inclusive). gets the value at that index
		//colors.clear();
		return;
	}
	
	Pegs(String s, int numCols){
		CreateColors();
		if(colors.contains(s) && colors.indexOf(s) < numCols){
			pegColor = s;
		}
		else{throw new IllegalGuessException("Please pick a suitable color (Note: Entries must be in CAPS)"); }
	}
	
	private void CreateColors(){
		colors.add("B"); //blue
		colors.add("G"); //green
		colors.add("O"); //orange
		colors.add("R"); //red
		colors.add("Y"); //yellow
		colors.add("P"); //purple
		colors.add("K"); //black
		colors.add("C"); //cyan
		colors.add("M"); //maroon
		colors.add("V"); //violet
	}
		
	public String toString(){
		return pegColor;
	}
	
	public boolean Equals(Pegs test){
		if (pegColor.equals(test.pegColor)) { return true;}
		return false;
	}
	
	public static String GetColors(int k){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("B for Blue"); //blue
		temp.add("G for Green"); //green
		temp.add("O for Orange"); //orange
		temp.add("R for Red"); //red
		temp.add("Y for Yellow"); //yellow
		temp.add("P for Pink"); //purple
		temp.add("K for Black"); //black
		temp.add("C for Cyan"); //cyan
		temp.add("M for Maroon"); //maroon
		temp.add("V for Violet"); //violet
		return temp.get(k);
	}
} 



