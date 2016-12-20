package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet01;

import bwi.prog.utils.TextIO;

public class TimeCalculator {
	public static void main(String[] args){
		long i,d,h,m,s,ms;
		TextIO.put("Welcome to the TimeCalculator!\nplease enter a duration in milliseconds:");
		i = TextIO.getlnLong();
		// (1000*60*60*24)
		// (1000*60*60)
		// (1000*60)
		// (100)
		TextIO.putf("%d ms are exactly:\n",i);
		d=i/(1000*60*60*24);
		i=i%(1000*60*60*24);

		h=i/(1000*60*60);
		i=i% (1000*60*60);
		
		m=i/(1000*60);
		i=i%(1000*60);
		
		s=i/1000;
		ms=i%1000;
		
		TextIO.putf("   days %d\n"
				+   "  hours %d\n"
				+ 	"minutes %d\n"
				+ 	"seconds %d\n"
				+ 	"     ms %d\n", d,h,m,s,ms);

	}
}
