package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class BMI {
	public static double bmiCalc(double height, double weight) {
		if (height < 1.6 || weight <40)
			return -1;
		return weight/(height*height);
	}
	
	public static int bmiCategory(double bmi) {
		if (bmi < 0)
			return -1;
		else if (bmi < 15)
			return 10;
		else if (bmi < 16)
			return 11;
		else if (bmi < 18.5)
			return 12;
		else if (bmi < 25)
			return 20;
		else if (bmi < 30)
			return 30;
		else if (bmi < 35)
			return 40;
		else if (bmi < 40)
			return 41;
		else 
			return 42;
					
	}
	
	public static void bmiMessage(int bmiCategory) {
		switch(bmiCategory) {
		case 10:
			TextIO.put("Very severely underweight");
			break;
		case 11:
			TextIO.put("Severely underweight");
			break;
		case 12:
			TextIO.put("Underweight");
			break;
		case 20:
			TextIO.put("Normal");
			break;
		case 30:
			TextIO.put("Overweight");
			break;
		case 40:
			TextIO.put("Moderately obese");
			break;
		case 41:
			TextIO.put("Severely obese");
			break;
		case 42:
			TextIO.put("Very severely obese");
			break;
		default:
			TextIO.put("invalid");
		}
		
	}
	
	public static void main(String[] args) {
		double weight, height, bmi;
		TextIO.putf("weight [kg]: ");
		weight = TextIO.getlnDouble();
		TextIO.putf("height [m]: ");
		height = TextIO.getlnDouble();
		TextIO.putf("m=%.2fkg h=%.2fm -> BMI=%.2f (",weight, height, bmi=bmiCalc(height, weight));
		bmiMessage(bmiCategory(bmi));
		TextIO.putf(")\n");
		}
}
