import bwi.prog.utils.TextIO;

public class experiment {

	public static void main(String[] args){
		String str = "<a href=\"https://www.technikum-wien.at/\" class=\"very special\">Link to Technikum Wien</a>";
		String rEx = "<a href=\"[a-zA-Z0-9/:\\.-]+\"[a-zA-Z0-9/:\\.-=\"\\s]*>[\\sa-zA-Z0-9]+</a>";
		if(str.matches(rEx)) {
		System.out.println("Yes");
		} else {
		System.out.println("No");
		}
	}
}
