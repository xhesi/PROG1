package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class StudentID {
	public static boolean validate(String studID) {
		return studID.matches("wi\\d\\db\\d\\d\\d");
	}

	public static int graduation(String studID) {
		if (!validate(studID))
			return -1;
		return Integer.parseInt(20+studID.substring(2, 4))+3;
	}

	public static void main(String[] args) {
		TextIO.put("enter studentID (wi**b***): ");
		String studID = TextIO.getln();
		TextIO.putf("ID valid: %s\n", validate(studID));
		TextIO.putf("graduation in: %d\n", graduation(studID));
		}

}
