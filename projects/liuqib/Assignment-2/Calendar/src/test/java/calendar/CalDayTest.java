/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class CalDayTest{
  Appt InvalidAppt = new Appt(12, 00, 0, 0, 0, "BS", "This a mess", "xyz@gmail.com");
  Appt appt0 = new Appt(12, 30, 22, 4, 2018, "Lunch", "Lunch with my wife", "xyz@gmail.com");
  Appt appt1 = new Appt(14, 00, 22, 6, 2018, "Shopping", "Shopping and buy stuffs", "xyz@gmail.com");
  Appt appt2 = new Appt(15, 30, 22, 8, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {

     GregorianCalendar cal = new GregorianCalendar(2018, 3, 22, 15, 30, 00);  // month must be -1
     CalDay day0 = new CalDay(cal);
     assertEquals(22, day0.getDay());
     assertEquals(4, day0.getMonth());
     assertEquals(2018, day0.getYear());
     day0.addAppt(appt0);
     assertNotNull(day0.getAppts());
     day0.addAppt(appt1);
     assertNotNull(day0.getAppts());
     day0.addAppt(InvalidAppt);
     assertNotNull(day0.getAppts());
     assertTrue(day0.isValid());
     assertNotNull(day0.getSizeAppts());
	   assertNotNull(day0.toString());
	   assertNotNull(day0.iterator());
	   assertNotNull(day0.getAppts());

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    Appt InvalidAppt0 = new Appt(12, 00, -2, -3, 20, "", "", "xyz@gmail.com");
     CalDay day0 = new CalDay();
     assertFalse(day0.isValid());
     InvalidAppt0.setValid();
     assertEquals(false, InvalidAppt0.getValid());
     assertEquals(null, day0.iterator());
		 assertEquals("", day0.toString());
     day0.addAppt(InvalidAppt0);

  }
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    Appt appt5 = new Appt(13, 30, 22, 4, 2018, "Lunch", "Lunch with my wife", "xyz@gmail.com");
    Appt appt6 = new Appt(0, 30, 22, 4, 2018, "Lunch", "Lunch with my wife", "xyz@gmail.com");
    GregorianCalendar cal = new GregorianCalendar(2018, 3, 22, 15, 30, 00);  // month must be -1
    CalDay day1 = new CalDay(cal);
    CalDay day2 = new CalDay(cal);
    CalDay day3 = new CalDay(cal);
    day1.addAppt(appt0);
    assertNotNull(day1.getFullInfomrationApp(day1));
    day2.addAppt(appt5);
    assertNotNull(day2.getFullInfomrationApp(day2));
    day3.addAppt(appt6);
    assertNotNull(day3.getFullInfomrationApp(day3));

  }

}
