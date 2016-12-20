package bwi.prog1D.WS1617.wi16b002_Galanxhi.LabWork01;

import bwi.prog.utils.TextIO;

public class LendItemFunctions {

	
	public static String lendItemString(LendItem it, int format)
	{
		switch (format)
		{
		case 1:
			return String.format("%-15.15s %-10.10s %s %s %-10.10s", it.description,it.lender, dateString(it.lendDate), dateString(it.returnDate), it.owner);
		case 2:
			return String.format("%-15.15s %-10.10s", it.description, it.lender);
		default:
			return String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", it.description,it.lender, dateString(it.lendDate), dateString(it.returnDate), it.owner);
		}
	}
	
	
	private static String dateString(Date d)
	{
		return String.format("%04d.%02d.%02d", d.year, d.month, d.day);
	}

	public static int compare(LendItem it1, LendItem it2, int method)
	{
		switch (method) {
			case 1:
				return compareByLendDate(it1, it2);
			case 2:
				return compareByReturnDate(it1, it2);
			case 3:
				return compareByLender(it1, it2);
			case 4:
				return compareByOwner(it1, it2);
			default:
				return compareByDescription(it1, it2);
		}
	}

	public static int compareByLendDate(LendItem it1, LendItem it2)
	{
		//null comparison
		if (it1 == null && it2 == null)
			return 0;
		else if (it1 == null)
			return -1;
		else if (it2 == null)
			return 1;
		//end null comparison
		
		return compare(it1.lendDate, it2.lendDate);
	 }
	
	 public static int compareByReturnDate(LendItem it1, LendItem it2)
	 {
		//null comparison
		if (it1 == null && it2 == null)
			return 0;
		else if (it1 == null)
			return -1;
		else if (it2 == null)
			return 1;
		//end null comparison
		
		return compare(it1.returnDate, it2.returnDate);
		 
	 }
	 
	 public static int compareByDescription(LendItem it1, LendItem it2)
	 {
		//null comparison
		if (it1 == null && it2 == null)
			return 0;
		else if (it1 == null)
			return -1;
		else if (it2 == null)
			return 1;
		//end null comparison
		
		int tmp=it1.description.compareTo(it2.description);
		if (tmp>0) return 1;
		else if (tmp<0) return -1;
		return 0;
	 }
	 
	 public static int compare(Date d1, Date d2)
	 {
		//null comparison
			if (d1 == null && d2 == null)
				return 0;
			else if (d1 == null)
				return -1;
			else if (d2 == null)
				return 1;
		//end null comparison
			
		 int tmp1 = d1.day + d1.month * 100 + d1.year * 10000;
		 int tmp2 = d2.day + d2.month * 100 + d2.year * 10000;
		 if (tmp1 < tmp2)
			 return -1;
		 else if (tmp1 > tmp2)
			 return 1;
		 else
			 return 0;
	 }
	 
	 public static int compareByLender(LendItem it1, LendItem it2)
	 {
		//null comparison
		if (it1 == null && it2 == null)
			return 0;
		else if (it1 == null)
			return -1;
		else if (it2 == null)
			return 1;
		//end null comparison
		
		
		int tmp=it1.lender.compareTo(it2.lender);
		if (tmp>0) return 1;
		else if (tmp<0) return -1;
		return 0;
	 }
	 
	 public static int compareByOwner(LendItem it1, LendItem it2)
	 {
		//null comparison
		if (it1 == null && it2 == null)
			return 0;
		else if (it1 == null)
			return -1;
		else if (it2 == null)
			return 1;
		//end null comparison
		
		
		int tmp=it1.owner.compareTo(it2.owner);
		if (tmp>0) return 1;
		else if (tmp<0) return -1;
		return 0;
	 }
	 
	 public static boolean equals(LendItem it1, LendItem it2)
	 {
		if (it1 == null && it2 == null)
			return true;
		if (it1.description.equals(it2.description) && it1.lender.equals(it2.lender) && it1.owner.equals(it2.owner) && equals(it1.lendDate, it2.lendDate) && equals(it1.returnDate, it2.returnDate))
			return true;
		return false;
	 }
	 
	 public static boolean equals(Date d1, Date d2)
	 {
		 if (d1 == null && d2 == null)
				return true;
		 if (d1.day == d2.day && d1.month == d2.month && d1.year == d2.year)
			 return true;
		 return false;
	 }
	 
	 public static LendItem scanLendItem()
	 {
	 String desc = "", lender = "", owner = "";
		do {
			TextIO.putf("description: ");
			desc = TextIO.getln();
			TextIO.putf("lender: ");
			lender = TextIO.getln();
			TextIO.putf("owner: ");
			owner = TextIO.getln();

			if (desc.isEmpty()) {
				TextIO.putf("description cannot be empty!\n");
				continue;
			}
			if (lender.isEmpty()) {
				TextIO.putf("lender cannot be empty!\n");
				continue;
			}

			break;
		} while (true);

		LendItem it = new LendItem();
		it.description = desc;
		it.lender = lender;
		it.owner = owner;
		TextIO.putf("lend date:\n");
		it.lendDate = scanDate();
		TextIO.putf("return date:\n");
		it.returnDate = scanDate();

		return it;
	 }
	 
	 public static Date scanDate()
	 {
	 int y, m, d;
		do {
			TextIO.put("year: ");
			y = TextIO.getlnInt();
			TextIO.put("month:");
			m = TextIO.getlnInt();
			TextIO.put("day:");
			d = TextIO.getlnInt();

			if (y < 1582) {
				TextIO.put("year cannot be before 1582!\n");
				continue;
			}
			if (m < 1 || m > 12) {
				TextIO.put("month must be 1-12!\n");
				continue;
			}
			if (d < 1 || d > 31) {
				TextIO.put("day must be 1-31!\n");
				continue;
			}

			break;
		} while (true);
		Date dat = new Date();
		dat.day = d;
		dat.month = m;
		dat.year = y;
		return dat;
	 }
	 public static boolean isOut(LendItem li)
	 {
		 return (li.returnDate == null);
	 }
}