package bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet05.tests;
import bwi.prog1D.WS1617.wi16b002_Galanxhi.ExerciseSheet05.Date;


import static org.testng.Assert.*;

import static org.testng.Assert.fail;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class DateTest {
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

	
	@Test(description="tests if all requested fields are available using the requested datatype")
	/**
	 * tests if all requested fields are available using the requested datatype
	 */
	public void Date() {
		Date toTest= new Date();
		String message = "";
		List<Object[]> myList = new ArrayList<Object[]>();

		myList.add(new Object[] { "int","year"  });
		myList.add(new Object[] { "int","month" });
		myList.add(new Object[] { "int","day" });
		

		for (Object[] li : myList) {
			message = String.format("field %s should be of datatype %s\n",
					li[1], li[0]);
			try {
				assertEquals(
						getPrivateField(toTest, li[1].toString()).getType().getSimpleName(), li[0], message);

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

	}
}
