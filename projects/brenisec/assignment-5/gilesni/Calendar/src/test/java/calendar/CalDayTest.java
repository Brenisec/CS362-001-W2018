package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable {
		 Appt appointment1 = new Appt(10, 2, 2, 2, 2123, "T", "D");
		 Appt appointment2 = new Appt(1, 2, 2, 2, 2123, "T", "D");

		 GregorianCalendar MainCal = new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
		 CalDay thisCal = new CalDay(MainCal);
		 thisCal.addAppt(appointment1);
		 thisCal.addAppt(appointment2);

		System.out.print(thisCal.toString());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
}
