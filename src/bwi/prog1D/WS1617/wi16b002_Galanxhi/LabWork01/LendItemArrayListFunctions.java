package bwi.prog1D.WS1617.wi16b002_Galanxhi.LabWork01;

import bwi.prog.utils.TextIO;

public class LendItemArrayListFunctions {

	
	public static boolean add(LendItemArrayList list, LendItem p)
	{
		return true;
	}
	
	public static LendItem remove(LendItemArrayList list, int n)
	{
		return null;
	}
	
	public static int list(LendItemArrayList list, int format)
	{
		TextIO.putln(LendItemFunctions.lendItemHeadings(format));
		for (int i=0;i<list.next;i++)
		{
			TextIO.putln(LendItemFunctions.lendItemString(list.landItems[i], format));
		}
		return 0;
	}
	
	public static void sort(LendItemArrayList list, int order)
	{
		
	}
	
	public static LendItemArrayList filterByDescription(LendItemArrayList list,String desc)
	{
		return null;
	}
	public static int findByID(LendItemArrayList list, int id) {
		return 0; 
	}
}
