package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	@Test
	  public void test00()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	
	@Test
	 public void test01() throws Throwable{
		//Test for getStartMonth and startMonth
		Appt appointment = new Appt(10, 2, 2, 2, 2123, "T", "D");
		
		 //Tests for getStartMonth and setStartMonth
		 appointment.setStartMonth(7);
		 int test = appointment.getStartMonth();
		 assertEquals(test,7);
		 
		//Tests for getStartMonth and setStartMonth
		 appointment.setStartMonth(12);
		  test = appointment.getStartMonth();
		 assertEquals(test,12);
		 
		//Tests for getStartMonth and setStartMonth
		 appointment.setStartMonth(-1);
		  test = appointment.getStartMonth();
		 assertEquals(test,false);
		 
		//Tests for getStartMonth and setStartMonth
		 appointment.setStartMonth(13);
		  test = appointment.getStartMonth();
		 assertEquals(test,false);
		 
		//Tests for getStartMonth and setStartMonth
		 appointment.setStartMonth(9);
		  test = appointment.getStartMonth();
		 assertEquals(test,9);
	}
	
	@Test
	 public void test02() throws Throwable{
		//Test for getStartMonth and startMonth
		Appt appointment = new Appt(10, 2, 2, 2, 2123, "T", "D");
		
		//Tests for getStartHour and setStartHour
		 appointment.setStartHour(-1);
		 int test = appointment.getStartHour();
		 assertEquals(test, false);
		 
		//Tests for getStartHour and setStartHour
		 appointment.setStartHour(24);
		 test = appointment.getStartHour();
		 assertEquals(test, false);
		 
		//Tests for getStartHour and setStartHour
		 appointment.setStartHour(1);
		 test = appointment.getStartHour();
		 assertEquals(test, 1);
		 
		//Tests for getStartHour and setStartHour
		 appointment.setStartHour(13);
		 test = appointment.getStartHour();
		 assertEquals(test, 13);
		 
		//Tests for getStartHour and setStartHour
		 appointment.setStartHour(23);
		 test = appointment.getStartHour();
		 assertEquals(test, 23);
		 
		//Tests for getStartHour and setStartHour
		 appointment.setStartHour(7);
		 test = appointment.getStartHour();
		 assertEquals(test, 7);
		 
		//Tests for getStartHour and setStartHour
		 appointment.setStartHour(100);
		 test = appointment.getStartHour();
		 assertEquals(test, 100);
		
	}
	
	
	 @Test
	  public void test03()  throws Throwable  {
		 Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");
		 
		 //Tests for getStartMinute and setStartMinute 
		 appointment.setStartMinute(32);
		 int test = appointment.getStartMinute();
		 assertEquals(test, 32);
		 
		 appointment.setStartMinute(-1);
		 test = appointment.getStartMinute();
		 assertEquals(test, false);
		 
		 appointment.setStartMinute(60);
		 test = appointment.getStartMinute();
		 assertEquals(test, false);
		 
		 //Tests for getStartDay and setStartDay
		 
		 appointment.setStartDay(-1);
		 test = appointment.getStartDay();
		 assertEquals(test,false);
		 
		 appointment.setStartDay(2);
		 test = appointment.getStartDay();
		 assertEquals(test,2);
		 
		 appointment.setStartDay(100);
		 test = appointment.getStartDay();
		 assertEquals(test,false);
		 
		 //Tests for getStartYear and setStartYear
		 appointment.setStartYear(2018);
		 test = appointment.getStartYear();
		 assertEquals(test,2018);
		 
		 //Tests for getTitle and setTitle
		 appointment.setTitle("T");
		 String sTest = appointment.getTitle();
		 assertEquals(sTest, "T");
		 
		 //Tests for getDescription and setDescription
		 appointment.setDescription("D");
		 sTest = appointment.getDescription();
		 assertEquals(sTest, "D");
		 
		 //Test for getValid
		 boolean bTrue = appointment.getValid();
		 assertEquals(bTrue, true);
	 }

	 
	 @Test
	  public void test04()  throws Throwable  {
		 //setRecurBy
		 Appt appointment = new Appt(4, 2, 2, 2, 2000, "T", "D");
		 
		 appointment.setRecurrence(null, 5, 5, 5);
		 
		 int iTest = appointment.getRecurNumber();
		 assertEquals(iTest, 5);
		 
		 iTest = appointment.getRecurBy();
		 assertEquals(iTest, 5);
		 
		 int[] iArrTest = appointment.getRecurDays();
		 
		 //isRecurring
		 boolean bTest = appointment.isRecurring();
		 assertEquals(bTest, true);
		 
		 iTest = appointment.getRecurIncrement();
		 assertEquals(iTest, 5);
	 }
	 
	 @Test
	 public void test05() throws Throwable {
		 //toString, representationApp, and compareTo test
		 Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		 Appt appt2 = new Appt(3, 2, 2, 2, 2000, "T", "D");
		 Appt appt3 = new Appt(0, 0, 1, 2, 2000, "T", "D");
		 
		 String sTest = appt.toString();
		 assertEquals(sTest, "\t 2/2/2000 at 12:02pm ,T, D\n");
		 sTest = appt2.toString();
		 assertEquals(sTest, "\t 2/2/2000 at 3:02am ,T, D\n");
		 
		 int iTest = appt.compareTo(appt2);
		 assertEquals(iTest, 9);
		 
		 sTest = appt3.toString();
		 assertEquals(sTest, null);
	 }
}
