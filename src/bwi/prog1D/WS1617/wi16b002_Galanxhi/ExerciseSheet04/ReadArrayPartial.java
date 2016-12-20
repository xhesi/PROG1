package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet04;

import bwi.prog.utils.TextIO;

public class ReadArrayPartial {

	/**
	 *  Write a Program that reads at most 10 integer numbers on the console and 
	 *  stores in an array. After reading, output the number of entered numbers and 
	 *  all numbers in the order entered in the given format. Negative numbers 
	 *  are ignored but produce a warning message invalid input!. Input ends after 
	 *  the 10th valid number or when zero is entered.
	 */
	
	public static void main(String[] args)
	{
		int[] arr = new int[10];
		int count=0;
		int input;
		while (true)
		{
			TextIO.put((count+1) + ". number: ");
			input = TextIO.getInt();
			if (input == 0)
				break;
			if (input < 0)
			{
				TextIO.putln("invalid input!");
				continue;
			}
			arr[count]=input;
			count++;
			if (count==10)
				break;
		}
		
		
		TextIO.putln(count + " number(s) entered.");
		
		for (int i=0;i<count;i++)
		{
			TextIO.putln("[" + i + "]: " + arr[i]);
		}
		if (count!=0)
			TextIO.put("Output finished.");
		
	}
}
