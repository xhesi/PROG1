package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class Weekdays {
	public static boolean validate(int year) {
		if (1582 <= year && year <= 2199)
			return true;
		return false;
	}
	public static boolean validate(int year, int month) {
		if (!(month >=1 && month <=12))
			return false;
		if (!validate(year))
			return false;
		if (year == 1582){
			if (month >=10)
				return true;
			return false;
		}
		return true;
	}
	public static boolean isLeap(int inYear) {
	    if (((inYear % 4 == 0) && (inYear % 100 != 0)) || ( inYear % 400 == 0))
	           return true;
		return false;
	}
	public static int nDays(int month, int year) {
		switch(month){
		case 2:
			if (isLeap(year))
				return 29;
			return 28;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		default:
			return 30;
		}
	}
	public static boolean validate(int year, int month, int day) {
		if (!(day >0 && day <= nDays(month,year)))
			return false;
		if (!validate(year,month))
			return false;
		if (year == 1582 && month == 10){
			if (day < 16)
				return false;
		}
		return true;
	}
	public static int weekday(int inDay, int inMonth, int inYear) {
		int m = inMonth-2;
		if (m==0)
			m=12;
		else if (m==-1)
			m=11;
		int d = inDay;
		int inYear2=inYear;
		if (inMonth <=2)
			inYear2=inYear2-1;
		int c = inYear2/100;
		int y = inYear2%100;
		
		int A = d + (int)(2.6*(double)m-0.2) + y + (int)((double)y/4) + (int)((double)c/4)-(2*c);
		//TextIO.putln(d + " + " + ((int)(2.6*(double)m-0.2)) + " + " + y + " + " + ((int)((double)y/4)) + " + " + ((int)((double)c/4)) + " - " + (2*c));
		//TextIO.putln(A%7);
		return ((A%7)+7)%7;
	}
	public static String dayName(int W) {
		switch(W){
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		default:
			return "Saturday";
		}
	}

	public static void main(String[] args) {

		TextIO.putln("enter date (yyyymmdd)");
		int date = TextIO.getInt();
		int inDay = date % 100, inMonth = date % 10000 / 100, inYear = date / 10000;
		if(validate(inYear, inMonth, inDay)){
		int W = weekday(inDay, inMonth, inYear);
		String weekday = dayName(W);
		TextIO.putf("%02d.%02d.%4d was/is or will be a %s", date % 100, date % 10000 / 100,
		date / 10000, weekday);
		}else {
		TextIO.putf("invalid date (%d)\n", date);
		}
		}

}
