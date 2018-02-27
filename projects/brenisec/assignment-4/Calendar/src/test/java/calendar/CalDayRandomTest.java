package calendar;


import org.junit.Test;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import static org.junit.Assert.*;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS = 100;

    /**
     * Generate Random Tests that tests Appt Class.
     */
    @Test
    public void randomtest() throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


        System.out.println("Start testing...");

        try {
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed = System.currentTimeMillis(); //10
                //			System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);

                int startHour = ValuesGenerator.RandInt(random);
                int startMinute = ValuesGenerator.RandInt(random);
                int startDay = ValuesGenerator.RandInt(random);
                int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear = ValuesGenerator.RandInt(random);
                String title = "Birthday Party";
                String description = "This is my birthday party.";
                //Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour,
                        startMinute,
                        startDay,
                        startMonth,
                        startYear,
                        title,
                        description);
                GregorianCalendar calendar = new GregorianCalendar();
                for (int i = 0; i < NUM_TESTS; i++) {
                    // run my test

                    CalDay calDayOfAppt = new CalDay(calendar);
                    calDayOfAppt.addAppt(appt);

                    startHour = ValuesGenerator.RandInt(random);
                    appt.setStartHour(startHour);
                    startMinute = ValuesGenerator.RandInt(random);
                    appt.setStartMinute(startMinute);
                    startDay = ValuesGenerator.RandInt(random);
                    appt.setStartDay(startDay);
                    startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    appt.setStartMonth(startMonth);

                    calDayOfAppt.addAppt(appt);

                    startHour = ValuesGenerator.RandInt(random);
                    appt.setStartHour(startHour);
                    startMinute = ValuesGenerator.RandInt(random);
                    appt.setStartMinute(startMinute);
                    startDay = ValuesGenerator.RandInt(random);
                    appt.setStartDay(startDay);
                    startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    appt.setStartMonth(startMonth);

                    calDayOfAppt.addAppt(appt);

                    startHour = ValuesGenerator.RandInt(random);
                    appt.setStartHour(startHour);
                    startMinute = ValuesGenerator.RandInt(random);
                    appt.setStartMinute(startMinute);
                    startDay = ValuesGenerator.RandInt(random);
                    appt.setStartDay(startDay);
                    startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    appt.setStartMonth(startMonth);

                    calDayOfAppt.addAppt(appt);
                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout); // Oh lord, look at that spacing...

            }
        } catch (NullPointerException e) {

        }

        System.out.println("Done testing...");
    }

}
