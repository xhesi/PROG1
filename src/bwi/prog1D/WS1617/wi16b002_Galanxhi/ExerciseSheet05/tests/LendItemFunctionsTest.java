package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet05.tests;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet05.*;
import bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet05.LendItemFunctions;
import bwi.prog.utils.TextIO;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LendItemFunctionsTest {

	LendItem toTest1;
	LendItem toTest2;
	
	@BeforeMethod
	private void init(){
		toTest1=new LendItem();
		toTest2=new LendItem();
	}
	
  @Test(dataProvider="compAll")
  public void compareLendItemLendItemint(String left, String right,int[] d1, int[] d2, int res, int method) {
	  LendItem l1= new LendItem();
	  LendItem l2= new LendItem();
	  
	  Date d1Date=new Date();
	  Date d2Date=new Date();
	  setPrivateField("year", d1Date, d1[0]);
	  setPrivateField("month", d1Date, d1[1]);
	  setPrivateField("day", d1Date, d1[2]);
	  setPrivateField("year", d2Date, d2[0]);
	  setPrivateField("month", d2Date, d2[1]);
	  setPrivateField("day", d2Date, d2[2]);
	  
	  setPrivateField("description", l1, left);
	  setPrivateField("lender", l1, left);
	  setPrivateField("owner", l1, left);
	  setPrivateField("lendDate", l1, d1Date);
	  setPrivateField("returnDate", l1, d1Date);
	  setPrivateField("description", l2, right);
	  setPrivateField("lender", l2, right);
	  setPrivateField("owner", l2, right);
	  setPrivateField("lendDate", l2, d2Date);
	  setPrivateField("returnDate", l2, d2Date);
	  
	  assertEquals(LendItemFunctions.compare(l1, l2,method), res, String.format("values d1:%s %s values d2: %s %s METHOD: %d", left,Arrays.toString(d1), right, Arrays.toString(d2),method));
	  
  }
  
	@DataProvider(name="compYears")
	private Object[][] dp_compYears() {
		return new Object[][] {
				{new int[]{2010,10,1},new int[]{2010,10,1}, 0},
				{new int[]{2010,10,1},new int[]{2011,10,1}, -1},
				{new int[]{2010,10,1},new int[]{2010,3,1}, 1},
				{new int[]{2010,10,22},new int[]{2010,10,31}, -1},
				{new int[]{2010,10,22},new int[]{2008,11,10}, 1},
				{new int[]{1995,12,4},new int[]{2008,11,10}, -1}
				
		};
	}

  
  @Test
  public void compareDateDateNull() {
	  Date d1=null;
	  Date d2=null;
	  
	  assertEquals(LendItemFunctions.compare(d1, d2), 0, "both dates are null and therefore equal");
	  d2=new Date();
	  assertEquals(LendItemFunctions.compare(d1, d2), -1, "second date is not null, but first is, therefore not equal");
	  d1=new Date();
	  d2=null;
	  assertEquals(LendItemFunctions.compare(d1, d2), 1, "first date is not null, but second is, therefore not equal");

  }
  
  @Test(dataProvider="compYears")
  public void compareDateDate(int[] d1, int[] d2, int res) {
	  Date d1Date=new Date();
	  Date d2Date=new Date();
	  setPrivateField("year", d1Date, d1[0]);
	  setPrivateField("month", d1Date, d1[1]);
	  setPrivateField("day", d1Date, d1[2]);
	  setPrivateField("year", d2Date, d2[0]);
	  setPrivateField("month", d2Date, d2[1]);
	  setPrivateField("day", d2Date, d2[2]);
	  
	  assertEquals(LendItemFunctions.compare(d1Date, d2Date), res, String.format("values d1:%s values d2: %s awaited result: %s", Arrays.toString(d1), Arrays.toString(d2), res));
	  
  }
  
	@DataProvider(name="compAll")
	private Object[][] dp_compAll() {
		return new Object[][] {
				{"Alpha Beta","Alpha Beta",new int[]{2010,10,1},new int[]{2010,10,1}, 0, 1},
				{"Alpha Beta","Alpha Beta",new int[]{2010,10,1},new int[]{2011,10,1}, -1, 1},
				{"Alpha Beta","Alpha Beta",new int[]{2010,10,1},new int[]{2010,3,1},  1, 1},
				{"Alpha Beta","Alpha Beta",new int[]{2010,10,22},new int[]{2010,10,31}, -1, 2},
				{"Alpha Beta","Alpha Beta",new int[]{2010,10,22},new int[]{2008,11,10}, 1, 2},
				{"Alpha Beta","Alpha Beta",new int[]{1995,12,4},new int[]{2008,11,10}, -1, 2},
				
				{"Alpha Beta","Alpha Beta",new int[]{2010,10,1},new int[]{2010,10,1}, 0, 3},
				{"Alpha Beta","Gamma Delta",new int[]{2010,10,1},new int[]{2011,10,1}, -1, 3},
				{"Gamma Delta","Alpha Beta",new int[]{2010,10,1},new int[]{2010,3,1}, 1, 4},
				{"alpha","Alpha",new int[]{2010,10,22},new int[]{2010,10,31}, 1, 4},
				
				{"Alpha Beta","Alpha Beta",new int[]{2010,10,1},new int[]{2010,10,1}, 0, -10},
				{"Alpha Beta","Gamma Delta",new int[]{2010,10,1},new int[]{2011,10,1}, -1, 5},
				{"Gamma Delta","Alpha Beta",new int[]{2010,10,1},new int[]{2010,3,1}, 1, 6},
	
		};
	}

  @Test(dataProvider="compStrings")
  public void compareByDescription( String left, String right, int res) {
		  LendItem l1=new LendItem();
		  LendItem l2=new LendItem();

		  setPrivateField("description", l1, left);
		  setPrivateField("description", l2, right);

		  
		  assertEquals(LendItemFunctions.compareByDescription(l1, l2), res, String.format("it1:%s it2: %s ",left,right));

	  
  }
  
  @DataProvider(name="compStrings")
  private Object[][] dp_compStrings() {
		return new Object[][] {
				{"Alpha Beta","Alpha Beta",0},
				{"Alpha Beta","Gamma Delta", -1},
				{"Gamma Delta","Alpha Beta", 1},
				{"alpha","Alpha", 1},
		};
	}

  @Test(dataProvider="compYears")
  public void compareByLendDate(int[] d1, int[] d2, int res) {
	  LendItem it1= new LendItem();
	  LendItem it2= new LendItem();
	  
	  Date d1Date=new Date();
	  Date d2Date=new Date();
	  setPrivateField("year", d1Date, d1[0]);
	  setPrivateField("month", d1Date, d1[1]);
	  setPrivateField("day", d1Date, d1[2]);
	  setPrivateField("year", d2Date, d2[0]);
	  setPrivateField("month", d2Date, d2[1]);
	  setPrivateField("day", d2Date, d2[2]);
	  
	  setPrivateField("lendDate", it1, d1Date);
	  setPrivateField("lendDate", it2, d2Date);
	  
	  assertEquals(LendItemFunctions.compareByLendDate(it1, it2), res, String.format("values d1:%s values d2: %s awaited result: %s", Arrays.toString(d1), Arrays.toString(d2), res));
  }

  @Test(dataProvider="compStrings")
  public void compareByLender(String left, String right, int res) {
	  LendItem l1=new LendItem();
	  LendItem l2=new LendItem();

	  setPrivateField("lender", l1, left);
	  setPrivateField("lender", l2, right);

	  
	  assertEquals(LendItemFunctions.compareByLender(l1, l2), res, String.format("it1:%s it2: %s ",left,right));

  }

  @Test(dataProvider="compStrings")
  public void compareByOwner(String left, String right, int res) {
	  LendItem l1=new LendItem();
	  LendItem l2=new LendItem();

	  setPrivateField("owner", l1, left);
	  setPrivateField("owner", l2, right);

	  
	  assertEquals(LendItemFunctions.compareByOwner(l1, l2), res, String.format("it1:%s it2: %s ",left,right));

  }

  @Test(dataProvider="compYears")
  public void compareByReturnDate(int[] d1, int[] d2, int res) {
	  LendItem it1= new LendItem();
	  LendItem it2= new LendItem();
	  
	  Date d1Date=new Date();
	  Date d2Date=new Date();
	  setPrivateField("year", d1Date, d1[0]);
	  setPrivateField("month", d1Date, d1[1]);
	  setPrivateField("day", d1Date, d1[2]);
	  setPrivateField("year", d2Date, d2[0]);
	  setPrivateField("month", d2Date, d2[1]);
	  setPrivateField("day", d2Date, d2[2]);
	  
	  setPrivateField("returnDate", it1, d1Date);
	  setPrivateField("returnDate", it2, d2Date);
	  
	  assertEquals(LendItemFunctions.compareByReturnDate(it1, it2), res, String.format("values d1:%s values d2: %s awaited result: %s", Arrays.toString(d1), Arrays.toString(d2), res));
  }
  


  @Test
  public void equalsLendItemLendItemNullValues() {
	  LendItem d1=null;
	  LendItem d2=null;
	  
	  assertEquals(LendItemFunctions.equals(d1, d2), true, "both dates are null and therefore equal");
	  d2=new LendItem();
	  assertEquals(LendItemFunctions.equals(d1, d2), false, "second date is not null, but first is, therefore not equal");
	  d1=new LendItem();
	  d2=null;
	  assertEquals(LendItemFunctions.equals(d1, d2), false, "first date is not null, but second is, therefore not equal");
  }
  
  
  
  
  @Test(dataProvider="compLE")
  public void equalsLendItemLendItem(String[] strings1, int[] d1,String[] strings2, int[] d2, boolean res) {
	  LendItem l1=new LendItem();
	  LendItem l2=new LendItem();
	  
	  Date d1Date=new Date();
	  Date d2Date=new Date();
	  setPrivateField("year", d1Date, d1[0]);
	  setPrivateField("month", d1Date, d1[1]);
	  setPrivateField("day", d1Date, d1[2]);
	  setPrivateField("year", d2Date, d2[0]);
	  setPrivateField("month", d2Date, d2[1]);
	  setPrivateField("day", d2Date, d2[2]);
	  
	  setPrivateField("description", l1, strings1[0]);
	  setPrivateField("lender", l1, strings1[1]);
	  setPrivateField("owner", l1, strings1[2]);
	  setPrivateField("lendDate", l1, d1Date);
	  setPrivateField("returnDate", l1, d1Date);
	  setPrivateField("description", l2, strings2[0]);
	  setPrivateField("lender", l2, strings2[1]);
	  setPrivateField("owner", l2, strings2[2]);
	  setPrivateField("lendDate", l2, d2Date);
	  setPrivateField("returnDate", l2, d2Date);
	  
	  assertEquals(LendItemFunctions.equals(l1, l2), res, String.format("values d1:%s %s values d2: %s %s", Arrays.toString(strings1),Arrays.toString(d1), Arrays.toString(strings2), Arrays.toString(d2)));

  }
  
	@DataProvider(name="compLE")
	private Object[][] dp_compLE() {
		return new Object[][] {
				{new String[]{"cd", "you", "me"},new int[]{2010,10,1},
					new String[]{"cd", "you", "me"},new int[]{2010,10,1}, true},
				{new String[]{"cd", "you", "me"},new int[]{2010,10,1},
					new String[]{"cd1", "you", "me"},new int[]{2010,10,1}, false},
				{new String[]{"cd", "you", "me"},new int[]{2010,10,1},
					new String[]{"cd", "marten", "me"},new int[]{2010,10,1}, false},
				{new String[]{"cd", "you", "me"},new int[]{2010,10,1},
					new String[]{"cd", "you", "Rose"},new int[]{2010,10,1}, false},
				{new String[]{"cd", "you", "me"},new int[]{2015,10,1},
					new String[]{"cd", "you", "me"},new int[]{2010,10,1}, false},
				{new String[]{"cd", "you", "me"},new int[]{2010,11,1},
					new String[]{"cd", "you", "me"},new int[]{2010,10,1}, false}
				
		};
	}
  

  @Test
  public void equalsDateDateNullValues() {
	  Date d1=null;
	  Date d2=null;
	  
	  assertEquals(LendItemFunctions.equals(d1, d2), true, "both dates are null and therefore equal");
	  d2=new Date();
	  assertEquals(LendItemFunctions.equals(d1, d2), false, "second date is not null, but first is, therefore not equal");
	  d1=new Date();
	  d2=null;
	  assertEquals(LendItemFunctions.equals(d1, d2), false, "first date is not null, but second is, therefore not equal");

  }
  
  @Test(dataProvider="eqDate")
  public void equalsDateDate(int[] d1, int[] d2, boolean res) {
	  Date d1Date=new Date();
	  Date d2Date=new Date();
	  setPrivateField("year", d1Date, d1[0]);
	  setPrivateField("month", d1Date, d1[1]);
	  setPrivateField("day", d1Date, d1[2]);
	  setPrivateField("year", d2Date, d2[0]);
	  setPrivateField("month", d2Date, d2[1]);
	  setPrivateField("day", d2Date, d2[2]);
	  
	  assertEquals(LendItemFunctions.equals(d1Date, d2Date), res, String.format("values d1:%s values d2: %s awaited result: %s", Arrays.toString(d1), Arrays.toString(d2), res));
  
  }

  
	@DataProvider(name="eqDate")
	private Object[][] dp_eqDate() {
		return new Object[][] {
				{new int[]{2010,10,1},new int[]{2010,10,1}, true},
				{new int[]{2010,10,1},new int[]{2011,10,1}, false},
				{new int[]{2010,10,1},new int[]{2010,3,1}, false},
				{new int[]{2010,10,1},new int[]{2010,10,5}, false}
				
		};
	}

  @Test(description="tests return value of isOut with null and set value ")
  public void isOut() {
	  assertEquals(LendItemFunctions.isOut(toTest1), true, String.format("date is %s, awaited return value: %s", null,true));

	  //change value
		try {
			Field privateStringField = LendItem.class.getDeclaredField("returnDate");
			privateStringField.setAccessible(true);
			privateStringField.set(toTest1, new Date());
			privateStringField.get(toTest1);
		} catch (Exception e) {
		}
		//check with object
		assertEquals(LendItemFunctions.isOut(toTest1), false, "date is set, awaited return value: false");
  }
  
  
  @DataProvider(name = "liString")
	private static Object[][] dp_liString() {
		return new Object[][] {
				{ "normal mycd", "marten", "anna rosa", new int[]{ 2010,11,1},new int[]{2015,11,1}, "normal mycd     marten     2010.11.01 2015.11.01 anna rosa ", 1},
				{ "very very long description to be cut", "anna-maria-magdalena", "Franz-Ferdinand", new int[]{2013,11,1},new int[]{2008,8,1},"very very long  anna-maria 2013.11.01 2008.08.01 Franz-Ferd", 1},
				{ "mycd", "marten", "anna rosa", new int[]{2013,11,1},new int[]{2008,8,1},"mycd            marten    ", 2},
				{ "very very long description to be cut", "anna-maria-magdalena", "Franz-Ferdinand", new int[]{2013,11,1},new int[]{2008,8,1},"very very long  anna-maria", 2},
				{ "mycd", "marten", "anna rosa", new int[]{2015,10,6},new int[]{2015,11,5}, "\"mycd\",\"marten\",\"2015.10.06\",\"2015.11.05\",\"anna rosa\"", 3},
				{ "very very long description to be cut", "anna-maria-magdalena", "Franz-Ferdinand", new int[]{2013,11,1},new int[]{2008,8,1},"\"very very long description to be cut\",\"anna-maria-magdalena\",\"2013.11.01\",\"2008.08.01\",\"Franz-Ferdinand\"", 3},
				};
	}

  @Test(dataProvider="liString")
  public void lendItemString(String item, String lender, String owner, int[]d1,int[]d2, String res, int format) {
	  LendItem l1=new LendItem();

	  Date d1Date=new Date();
	  Date d2Date=new Date();
	  setPrivateField("year", d1Date, d1[0]);
	  setPrivateField("month", d1Date, d1[1]);
	  setPrivateField("day", d1Date, d1[2]);
	  setPrivateField("year", d2Date, d2[0]);
	  setPrivateField("month", d2Date, d2[1]);
	  setPrivateField("day", d2Date, d2[2]);
	  
	  setPrivateField("description", l1, item);
	  setPrivateField("lender", l1, lender);
	  setPrivateField("owner", l1, owner);
	  setPrivateField("lendDate", l1, d1Date);
	  setPrivateField("returnDate", l1, d2Date);
	  
	  assertEquals(LendItemFunctions.lendItemString(l1, format), res);
  
  }
  
  
  
  @Test(dataProvider="inoutLendItem")
  public void scanLendItem(String input, String desc, String lender, String owner, int y, int m, int d, int y2, int m2, int d2) {
	  System.out.println(input);
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
		
		//call scan method
		LendItem toTest=LendItemFunctions.scanLendItem();
		
		//set up values
		List<Object[]> myList = new ArrayList<Object[]>();
		
		myList.add(new Object[] { "String","description", desc});
		myList.add(new Object[] { "String","lender", lender });
		myList.add(new Object[] { "String","owner", owner });
		myList.add(new Object[] { "Date","lendDate", "year", y});
		myList.add(new Object[] { "Date","lendDate", "month", m});
		myList.add(new Object[] { "Date","lendDate", "day", d});
		myList.add(new Object[] { "Date","returnDate", "year", y2});
		myList.add(new Object[] { "Date","returnDate", "month", m2});
		myList.add(new Object[] { "Date","returnDate", "day", d2});

		String message = "";
		
		for (Object[] li : myList){
			try {
				if(li[0].toString()=="Date"){
					message = String.format("field %s.%s should have value %s\n",
							li[1],li[2],li[3]);
					Object dateField = getPrivateField(toTest, li[1].toString()).get(toTest);
					assertEquals(
							getPrivateField(dateField,li[2].toString()).get(dateField), li[3], message);
				}
				else{
					message = String.format("field %s should have value %s\n",
							li[1],li[2]);
					assertEquals(
							getPrivateField(toTest, li[1].toString()).get(toTest), li[2], message);
				}
			
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

			
		}
  
  
	@DataProvider(name="inoutLendItem")
	private Object[][] dp_inoutLendItem() {
		return new Object[][] {
				{"my very cool cd\nyou\nme\n2001\n10\n1\n2001\n11\n1\n", "my very cool cd", "you", "me", 2001, 10, 1, 2001, 11, 1},
				{"\nyou\nme\njava book\nyou\nme\n2001\n10\n1\n2001\n11\n1\n","java book", "you", "me", 2001, 10, 1, 2001, 11, 1},
				{"my very cool cd\n\nme\nmy very cool cd\nyou\nme\n2001\n10\n1\n2001\n11\n1\n", "my very cool cd", "you", "me", 2001, 10, 1, 2001, 11, 1}				
		};
	}

  @Test(dataProvider="inoutDate", description="reads different input and checks correct return value based on last entered y,m,d")
  public void scanDate(String input, int year, int month, int day) {
	  	
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
		
		Date testDate=LendItemFunctions.scanDate();
		String message = "";
		List<Object[]> myList = new ArrayList<Object[]>();

			try {
				message = String.format("field %s should be have value %s\n",
						"year", year);
				assertEquals(
						getPrivateField(testDate, "year").get(testDate), year, message);
				message = String.format("field %s should be have value %s\n",
						"month", month);
				assertEquals(
						getPrivateField(testDate, "month").get(testDate), month, message);

				message = String.format("field %s should be have value %s\n",
						"day", day);
				assertEquals(
						getPrivateField(testDate, "day").get(testDate), day, message);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

  
  
	@DataProvider(name="inoutDate")
	private Object[][] dp_inoutDate() {
		return new Object[][] {
				{"2001\n10\n1\n", 2001, 10,1},
				{"1500\n10\n1\n2001\n10\n1\n", 2001, 10,1},
				{"2001\n22\n1\n2001\n10\n1\n", 2001, 10,1},
				{"2001\n10\n-25\n2001\n10\n1\n", 2001, 10,1}
				
		};
	}


  
  /**
	 * tries to get a private field of the given object
	 * 
	 * @param myObject
	 *            Object of which the field should be reached
	 * @param fieldName
	 *            String which defines the field to be retrieved
	 * @return new Field object if found, fails if NoSuchFieldException
	 */
	private <T> Field getPrivateField(T myObject, String fieldName) {
		Field privateStringField;
		try {
			privateStringField = myObject.getClass()
					.getDeclaredField(fieldName);
			privateStringField.setAccessible(true);
			return privateStringField;
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			fail("field \"" + fieldName + "\" not found");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private <T,V> boolean setPrivateField(String fieldname, T myObject, V value) {
		Field field=getPrivateField(myObject, fieldname);
		try {

			field.setAccessible(true);
			field.set(myObject, value);
		} catch (Exception e) {
			return false;
		}
		return true;
	
	}
}
