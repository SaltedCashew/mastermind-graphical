/*Student Name: Brad Gray, Jake George
 *EID: bg22946, 
 *Lab Section: 16805
*/

package assignment2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public class Code
{
	private int numPegs;
	private ArrayList<String> code;
	private ArrayList<String> color;
	
	Code(){  //change the size of the code (numPegs) and colors here in this constructor
		numPegs = 4;
		color = new ArrayList<String>();
		color.add("B");
		color.add("G");
		color.add("O");
		color.add("R");
		color.add("Y");
		color.add("P");
		code = new ArrayList<String>();
	}
 
	public void GenerateSolution(){ //should work for any size code or number of colors
		Random r =  new Random();
		for (int i=0; i<numPegs; i++){
			String codePeg = color.get(r.nextInt(color.size())); //generates a random number between 0 (inclusive) and the color ArrayList size (non-inclusive). gets the value at that index
			code.add(codePeg);
		}
		return;
	}
	
	public String CodeToString(){
		return new String(code.toString()).replaceAll("[^A-Za-z]", ""); //returns a string of the Color characters only - no brackets or commas, etc
	}
	
	public void GetNextGuess(){
		Scanner input = new Scanner(System.in);
		String tempInput = new String();
		String c = new String() ;
		boolean validEntry = true;
		do{
			try{
				validEntry=true;
				System.out.println("Please enter your guess: ");
				//if(!input.hasNextLine()){ throw new InputMismatchException();}
				tempInput = input.next();
				if(tempInput.length()!=numPegs){throw new InputMismatchException();} //throw exception if guess not equal to code size
				for(int i=0; i<numPegs;i++){
					c = tempInput.substring(i, i+1);
					if (color.contains(c) ){
						code.add(c); //loop to make changing code length easier. get each char, convert to string, and store in arrayList		
					}else{ throw new InputMismatchException(); }
				}
			}
			catch(InputMismatchException ex){
				System.out.println("Please try again!");
				validEntry=false;
			}

		}while(validEntry==false);
	//	input.close(); if close input here, then getnextguess fails on loops
	}
	
	public boolean IsValid(String first){
		return true;
	}
	
	public Feedback CompareCodes(Code playerGuess){
		//what are we doing here? Compare, create feedback pegs, and return a true if there are 4 black pegs
		//do we actually need to boolean return? Make that a feedback method, not a code method?
		ArrayList<String> solCopy = new ArrayList<String>(code.size());
		ArrayList<String> playerCopy = new ArrayList<String>(playerGuess.code.size());
		for(String item: code){
			solCopy.add(item);
		}
		for(String item: playerGuess.code){
			playerCopy.add(item);
		}
		Feedback turnResult = new Feedback();
		int codeSize = numPegs;
		for(int i=0; i<codeSize; i++){ //note: possible error if numPegs != size of either arrayList - add exception here?
			if(solCopy.get(i).equals(playerCopy.get(i))){ //gets both strings at the index and checks if equal 
				turnResult.AddBlackPeg();
				solCopy.remove(i);
				playerCopy.remove(i);
				codeSize=codeSize - 1;
				i--;
			}
		}
		for(int i=0; i<solCopy.size();i++){ //now to get the number of white pegs
			for(int j=0; j<playerCopy.size();j++){
				if(solCopy.get(i).equals(playerCopy.get(j))){
					turnResult.AddWhitePeg();
					solCopy.remove(i);
					playerCopy.remove(j);
					i--;
					break;
				}
			}
		}
		
		return turnResult;
	}
	
	public boolean DetermineStatus(Feedback turnResult){
		return false;
	}
	
	public void ResetCode(){
		code.clear();
	}
}
