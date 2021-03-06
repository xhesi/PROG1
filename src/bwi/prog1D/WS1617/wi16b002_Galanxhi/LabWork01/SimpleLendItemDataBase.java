package bwi.prog1D.WS1617.wi16b002_Galanxhi.LabWork01;
import bwi.prog.utils.TextIO;
public class SimpleLendItemDataBase {
	public static void main(String[] args){
		
		LendItemArrayList list = new LendItemArrayList();
		populateDB(list);
		
		interactiveMenu(list);
	}
	
	
	public static void populateDB(LendItemArrayList list)
	{
		
		//list.lendItems = new LendItem[list.INITIAL_SIZE];
		list.resizeable=true;
		int nextID=1;
		for (int i = 0; i < 10; i++) {
			LendItem li = new LendItem();
			li.id = nextID++;
			li.description = String.format("%c_description", ((int) (i
			* Math.PI * 10000)) % 15 + 'A');
			li.lender = String.format("Gustav_%02d", ((int) (i
			* Math.PI * 1000000)) % 10);
			li.lendDate = new Date();
			li.lendDate.year = 2010 - ((int) (i * Math.PI * 100)) % 100;
			li.lendDate.month = ((int) (i * Math.PI * 1000000)) % 12 + 1;
			li.lendDate.day = ((int) (i * Math.PI * 100000000)) % 28 + 1;
			
			LendItemArrayListFunctions.add(list, li);
			
			}
	//	LendItemArrayListFunctions.remove(list, 7);
	//	LendItemArrayListFunctions.list(list, 0);
	}
	public static void interactiveMenu(LendItemArrayList list){
		String menuOptions = 	"1) list\n" + 
								"2) add\n" +
								"3) remove\n" +
								"4) sort\n" +
								"5) filter\n" +
								"6) set format\n" +
								"0) quit\n";
		int format=1;
		int inputOption;
		String inputErrorOutput="Please enter a number listed in the menu options [0-6]!";
		menuloop: while (true)
		{
			 TextIO.put(menuOptions);
			 TextIO.put("Enter option: ");
			 try {
				 inputOption=TextIO.getlnInt();
			 }
			 catch (Exception e)
			 {
				 TextIO.putln(inputErrorOutput);
				 continue;
			 }
			 switch (inputOption)
			 {
			 case 1:
				 LendItemArrayListFunctions.list(list, format);
				 break;
			 case 2:
				 LendItem item = LendItemFunctions.scanLendItem();
				 item.id=(int) Math.round(Math.random()*100);
				 if(LendItemArrayListFunctions.add(list, item)){
					 TextIO.putln("1 item added.");
				 }
				 else{
					 
				 }
				 
				 break;
			 case 3:
				 TextIO.put("Enter ID of LendItem to be removed: ");
				 int id = TextIO.getlnInt();
				 int index=LendItemArrayListFunctions.findByID(list,id);
				 if (index!=-1)
				 {
					 LendItemArrayListFunctions.remove(list, index);
					 TextIO.putln("1 LendItem (ID=" + id + ") removed.");
				 }
				 else
					 TextIO.putln("LendItem not found (ID "+id+")");
				 break;
			 case 4:
				 String[] sortOptions = {"lend date", "return date", "lender", "owner", "description"};
				 for(int i =1; i<=sortOptions.length;i++){
					 TextIO.putln(i+") by "+sortOptions[i-1]);
				 }
				 
				 int chosenOption = TextIO.getlnInt();
				 
				 if(chosenOption > 4 && chosenOption < 0){
					 TextIO.putln("invalid choice!");
					 continue;
				 }
				 else
				 {
					 LendItemArrayListFunctions.sort(list, chosenOption);
					 LendItemArrayListFunctions.list(list, format);
					 
				 }
				 //
				 
				 //LendItemArrayListFunctions.list(list, 1);
				 
				 break;
			 case 5:
				 TextIO.put("enter description: ");
				 String searchDescription = TextIO.getlnWord();
				 TextIO.put("displaying matches: \n");
				 
				 LendItemArrayList searchedByDescription = LendItemArrayListFunctions.filterByDescription(list, searchDescription);
				 LendItemArrayListFunctions.list(searchedByDescription, format);
				 
				 break;
			 case 6:
				 TextIO.put("available options:\n1) full format\n2) short format\n3) csv format\nEnter format option: ");
				 format=TextIO.getlnInt();
				 break;
			 case 0:
				 break menuloop;
			 default:
				 TextIO.putln(inputErrorOutput);
				 continue;
			 }
			 
			 
		}
	}
	
	
}
