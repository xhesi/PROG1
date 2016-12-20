package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet01;

import bwi.prog.utils.TextIO;

public class TheLifeOfPi {
	public static void main(String[] args){
		double pi=3.14159265359;
		TextIO.putf("Pi=%f!\n",pi);
		TextIO.putf("Pi=%12f!\n",pi);
		TextIO.putf("Pi=%12.2f!\n",pi);
		TextIO.putf("Pi=%10.0f!\n",pi);
		TextIO.putf("Pi=%.11f!\n",pi);
		TextIO.putf("Pi=%015.6f!\n",pi);
		TextIO.putf("Pi=%+015.2f!\n",pi);


	}
}
