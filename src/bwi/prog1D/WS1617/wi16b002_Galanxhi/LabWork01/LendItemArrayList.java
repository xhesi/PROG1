package bwi.prog1D.WS1617.wi16b002_Galanxhi.LabWork01;
import java.util.ArrayList;

public class LendItemArrayList {
	int INITIAL_SIZE = 20;
	boolean resizeable;
	LendItem[] lendItems;
	int next = 0;
	public LendItemArrayList()
	{
		resizeable = false;
		lendItems = new LendItem[INITIAL_SIZE];
	}

}
