package bwi.prog1D.WS1617.wi16b002_Galanxhi.LabWork01;

import bwi.prog.utils.TextIO;

public class LendItemArrayListFunctions {

	
	public static boolean add(LendItemArrayList list, LendItem p)
	{
		int future_index = list.next;
		int current_list_length = list.lendItems.length;
		
		if(current_list_length > future_index){
			list.lendItems[future_index] = p;
			list.next++;
			
			return true;
		}
		else if(list.resizeable){
			LendItem[] current = list.lendItems;
			LendItem[] new_list = new LendItem[current.length*2];
			
			new_list = copyTo(current,new_list);
			list.lendItems=new_list;
			list.lendItems[future_index] = p;
			list.next++;
			
			return true;
		}
		else{
			// list should be resized but is non resizable
			return false;
		}
	}
	
	public static LendItem remove(LendItemArrayList list, int n)
	{
		if( n < list.next ){
			LendItem removed_item = list.lendItems[n];
			
			LendItem[] newList = new LendItem[list.lendItems.length-1];
			
			int counter = 0;
			
			for(int i=0;i<n;i++){
				
				newList[counter] = list.lendItems[i];
				counter++;
			}
			
			for(int i=n+1;i<list.lendItems.length; i++){
				
				newList[counter] = list.lendItems[i];
				counter++;
			}
			
			list.lendItems=newList;
			list.next--;
			return removed_item;
		}
		
		return null;
	}
	
	public static int list(LendItemArrayList list, int format)
	{
		TextIO.putln(LendItemFunctions.lendItemHeadings(format));
		TextIO.putln(LendItemFunctions.lendItemSeparator(format));
		int i=0;
		for (;i<list.next;i++)
		{
			TextIO.putln(LendItemFunctions.lendItemString(list.lendItems[i], format) + "("+i +")");
		}
		if (i==0)
			TextIO.putln("List empty.");
		else
			TextIO.putln(i + " LendItem(s) in list, " + (list.lendItems.length-i) + " free.");
		return i;
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
	
	// copy the old array to a new one	
	private static LendItem[] copyTo(LendItem[] o, LendItem[] n){
		for(int i=0; i<o.length; i++){
			n[i] = o[i];
		}
		return n;
	}
}
