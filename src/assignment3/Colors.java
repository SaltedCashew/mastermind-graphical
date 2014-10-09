package assignment3;

import java.util.ArrayList;
import java.util.Random;

public class Colors
{
	String colorName;
	String colorInit;
	final static int MAX_COLORS = 10;
	final static int NAME_LOCATION = 0;
	final static int INIT_LOCATION = 1;
	final static int COLOR_NAME = 6;

	public Colors()
	{  
		Colors tempColor = GetRandomColor(MAX_COLORS);
		colorInit = tempColor.colorInit;
		colorName = tempColor.colorName;
	}
	
	public Colors(int numColors)
	{  
		Colors tempColor;
		if (numColors>MAX_COLORS || numColors < 0)
		{
			tempColor = GetRandomColor(MAX_COLORS);
		}
		else{
			tempColor = GetRandomColor(numColors);	
		}
		colorInit = tempColor.colorInit;
		colorName = tempColor.colorName;
	}
	
	Colors(String s, int numCols){
		ArrayList<Colors> colorList = CreateColors();
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
	
	Colors(String colorInitial, String cName){
		colorInit = colorInitial;
		colorName = cName;
	}
	
	public String toString(){
		return new String ("" + colorInit + " : " + colorName);
	}
	
	public String toString_Init(){
		return colorInit;
	}

	
	public static Colors GetColor(int k){
		ArrayList<Colors> temp = CreateColors();
		return temp.get(k);
	}
	
	public static int MaxColors(){
		return MAX_COLORS;
	}
	
	private static ArrayList<Colors> CreateColors()
	{
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Blue"); //blue
		temp.add("Green"); //green
		temp.add("Orange"); //orange
		temp.add("Red"); //red
		temp.add("Yellow"); //yellow
		temp.add("Purple"); //purple
		temp.add("Black"); //black
		temp.add("Cyan"); //cyan
		temp.add("Maroon"); //maroon
		temp.add("Violet"); //violet
		ArrayList<String> temp2 = new ArrayList<String>();
		temp2.add("B"); //blue
		temp2.add("G"); //green
		temp2.add("O"); //orange
		temp2.add("R"); //red
		temp2.add("Y"); //yellow
		temp2.add("P"); //purple
		temp2.add("K"); //black
		temp2.add("C"); //cyan
		temp2.add("M"); //maroon
		temp2.add("V"); //violet
		ArrayList<Colors> colorList = new ArrayList<Colors>();
		for(int k = 0; k < temp.size(); k++){
			colorList.add(new Colors(temp2.get(k), temp.get(k)) );
		}
		
		return colorList;
	}
		
	private Colors GetRandomColor(int max){
			
		Random r =  new Random();
		int k = r.nextInt(max);
		return GetColor(k);
	}
	
	public boolean Equals(Colors test){
		if(colorInit.equals(test.colorInit)){
			return true;
		}
		return false;
	}

}
