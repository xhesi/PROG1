package bwi.prog1D.WS1617.wi16b002_Galanxhi.LabWork01;

import java.util.Arrays;
import java.util.Comparator;

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
			TextIO.put(LendItemFunctions.lendItemString(list.lendItems[i], format) );
			if (format==1)
				TextIO.put("("+ String.format("%02d", i) +")");
			TextIO.put("\n");
		}
		TextIO.putln(LendItemFunctions.lendItemSeparator(format));
		if (i==0)
			TextIO.putln("List empty.");
		else
			TextIO.putln(i + " LendItem(s) in list, " + (list.lendItems.length-i) + " free.");
		return i;
	}
	
	public static void sort(LendItemArrayList list, int order)
	{
		LendItemArrayList newArrayList = new LendItemArrayList();
		for (int i=0;i<list.next;i++)
		{
			add(newArrayList,list.lendItems[i]);
		}
		Arrays.sort(newArrayList.lendItems, new Comparator<LendItem>(){

			@Override
			public int compare(LendItem i1, LendItem i2) {
				if (i1 == null || i2 == null)
					return LendItemFunctions.compare(i1, i2, order)*-1;
				return LendItemFunctions.compare(i1, i2, order);
			}
		});

		
		for (int i=0;i<list.next;i++)
		{
			list.lendItems[i]=newArrayList.lendItems[i];
		}
	}
	
	public static LendItemArrayList filterByDescription(LendItemArrayList list,String desc)
	{
		LendItemArrayList newArrayList = new LendItemArrayList();
		boolean tmp=list.resizeable;
		newArrayList.resizeable=true;
		int i=0;
		for (;i<list.next;i++)
		{
			if (list.lendItems[i].description.contains(desc))
				add(newArrayList,list.lendItems[i]);
				
		}
		newArrayList.resizeable=tmp;
		return newArrayList;
	}
	public static int findByID(LendItemArrayList list, int id) {
		int i=0;
		for (;i<list.next;i++)
		{
			if (list.lendItems[i].id==id)
				return i;
				
		}
		return -1;
	}
	
	// copy the old array to a new one	
	private static LendItem[] copyTo(LendItem[] o, LendItem[] n){
		for(int i=0; i<o.length; i++){
			n[i] = o[i];
		}
		return n;
	}
}
