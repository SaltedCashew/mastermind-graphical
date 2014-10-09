package assignment3;

import java.util.ArrayList;
import java.util.Random;

public class Pegs
{
	private String pegColor;
	private ArrayList<String> colors;
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
		colors.clear();
		return;
	}
	
	Pegs(String s){
		CreateColors();
		if(colors.contains(s)){
			pegColor = s;
		}
		else{throw new IllegalGuessException("Please pick a suitable color (Note: Entries must be in CAPS)"); }
	}
	
	private void CreateColors(){
		colors = new ArrayList<String>();
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
} 



