package assignment3;

public class Pegs
{
	private Colors pegColor;
	final int DEFAULT_COLOR_NUM = 6;
	
	Pegs()
	{	
		pegColor = new Colors(DEFAULT_COLOR_NUM);
	}
	
	Pegs(int num){ //num will be the number of colors to choose from
		pegColor = new Colors(num);
	}
	
	Pegs(String s, int numCols){
			pegColor = new Colors(s, numCols);
	}
	
	
	public String toString(){
		return pegColor.toString_Init();
	}
	
	public boolean Equals(Pegs test){
		if (pegColor.equals(test.pegColor)) { return true;}
		return false;
	}
} 





