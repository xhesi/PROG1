package bwi.prog1D.WS1617.wi16b002_Galanxhi.LabWork01;

public class LendItemArrayListFunctions {

	
	public static boolean add(LendItemArrayList list, LendItem p)
	{
		int future_index = list.next;
		int current_list_length = list.lendItems.length;
		
		if(current_list_length > future_index){
			list.lendItems[future_index] = p;
			list.next++;
		}
		else{
			LendItem[] current = list.lendItems;
			LendItem[] new_list = new LendItem[current.length+1];
			
			new_list = copyTo(new_list,current);
			
			list.lendItems[future_index] = p;
			list.next++;
		}
		return true;
	}
	
	public static LendItem remove(LendItemArrayList list, int n)
	{
		return null;
	}
	
	public static int list(LendItemArrayList list, int format)
	{
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
	
	// copy the old array to a new one	
	private static LendItem[] copyTo(LendItem[] n, LendItem[] o){
		for(int i=0; i<o.length; i++){
			n[i] = o[i];
		}
		return n;
	}
}
