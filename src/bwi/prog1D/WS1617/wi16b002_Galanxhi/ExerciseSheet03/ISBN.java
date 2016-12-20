package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class ISBN {
	static boolean validatePattern(String s) {
		return s.matches("^\\d{13}$");
	}
	static boolean validateCheckDigit(String s) {
		if (!validatePattern(s))
			return false;
		int[] isbn = {0,0,0,0,0,0,0,0,0,0,0,0,0}; 
		String s2[] = s.split("");
		for (int i=0; i<13; i++){
			isbn[i]= Integer.parseInt(s2[i]);
		}
		int a = (10-((isbn[0]+3*isbn[1]+isbn[2]+3*isbn[3]+isbn[4]+3*isbn[5]+isbn[6]+3*isbn[7]+isbn[8]+3*isbn[9]+isbn[10]+3*isbn[11]))%10)%10;
		//TextIO.putln(a);
		if (isbn[12] == a)
			return true;
		return false;
	}

	public static void main(String[] args) {
		TextIO.put("enter ISBN: ");
		String isbn = TextIO.getln();
		TextIO.putf("valid pattern: %s\n", validatePattern(isbn));
		TextIO.putf("valid checkDigit: %s\n", validateCheckDigit(isbn));
	}
}
