package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet03.tests;
import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.PrintWriter;
import bwi.prog.utils.TestNGSupport;
import bwi.prog.utils.TextIO;


public class WeekdaysTest {
	
	//dynamically read class to test incl. package
	private String className=this.getClass().getName().replace("Test", "").replace(".tests", "");
	//dynamically create filepath of testfiles
		private String dirName=System.getProperty("user.dir")+System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+this.getClass().getPackage().getName().replace(".", System.getProperty("file.separator"))+System.getProperty("file.separator");
	
	//create output Stream
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//declare input Stream
	private String input = "";
	
	
	//use supporter class for common methods
	private TestNGSupport supporter= new TestNGSupport(this.getClass().getSimpleName().replace("Test", ""), dirName); 
	
  @Test(dataProvider = "inout", description="tests the output of main compared with the awaited output")
  public void testMain(String input, String expOutput) {
	  	outContent.reset();	
	    System.setOut(new PrintStream(outContent));

		System.setIn(null);
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		try{
		// reset stdin in BinaryStdIn through reflection
		  java.lang.reflect.Field in = TextIO.class.getDeclaredField("in");
		  in.setAccessible(true);
		  in.set(null, new BufferedReader(
					new InputStreamReader(System.in)));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			//reset out stream for textio
			  java.lang.reflect.Field in = TextIO.class.getDeclaredField("out");
			  in.setAccessible(true);
			  in.set(null, new PrintWriter(new PrintStream(outContent)));
			}catch(Exception e){
				e.printStackTrace();
			}
		Class myClass;
		try {

			
			Class<?> cls = Class.forName(className);
		    Method meth = cls.getMethod("main", String[].class);
		    String[] params = null; // init params accordingly
		    meth.invoke(null, (Object) params); // static method doesn't have an instance
	
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//exact comparison, ignoring \r
		assertEquals(outContent.toString().replace("\r", ""),expOutput.replace("\r", ""));

  }

  @DataProvider
  private Object[][] inout() {
	 return supporter.getDataProvider();
  }

}
