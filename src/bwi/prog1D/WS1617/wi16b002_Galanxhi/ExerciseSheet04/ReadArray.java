package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet04;

import bwi.prog.utils.TextIO;

public class ReadArray {
	public static void main(String[] args){
		int[] arr = new int[10];
		for (int i=0;i<10;i++)
		{
			TextIO.put((i+1) +". number: ");
			arr[i] = TextIO.getInt();
		}
		TextIO.putln("Input finished.");
		for (int i=9;i>=0;i--)
		{
			TextIO.putln("[" + i + "]: " +arr[i]);	
		}
		TextIO.put("Output finished.");
	}
}
