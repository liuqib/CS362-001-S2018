/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      assertTrue(appt0.getValid());
      String string0 = appt0.toString();
      int startDay0 = appt0.getStartDay();
      int startMonth0 = appt0.getStartMonth();
      int startYear0 = appt0.getStartYear();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      assertTrue(appt0.hasTimeSet());
      assertNull(appt0.getXmlElement());
      assertTrue(appt0.isOn(startDay0, startMonth0, startYear0));
      assertFalse(appt0.isOn(startDay0+1, startMonth0, startYear0));
      assertFalse(appt0.isOn(startDay0, startMonth0+1, startYear0));
      assertFalse(appt0.isOn(startDay0, startMonth0, startYear0+1));

  }
/*************************************************************************************/
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      int recurdays[] = null;
		  int recurby = 1;
		  int recurinc = 1;
		  int recurnnum= 1;
		  appt0.setRecurrence(recurdays, recurby, recurinc, recurnnum);
		  appt0.isRecurring();
      assertEquals("Birthday Party", appt0.getTitle());
      assertEquals("This is my birthday party", appt0.getDescription());
      assertEquals("xyz@gmail.com", appt0.getEmailAddress());

}
/************************************************************************************/
@Test(timeout = 4000)
public void test02()  throws Throwable  {
  int startHour=15;
  int startMinute=30;
  int startDay=9;
  int startMonth=10;
  int startYear=2018;
  String title=null;
  String description=null;
  String emailAddress=null;
  // test gettitle, description, emailAddress
  Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
    assertEquals("", appt0.getTitle());
    assertEquals("", appt0.getDescription());
    assertEquals("", appt0.getEmailAddress());


}
/****************************************************************************************************/
@Test(timeout = 4000)
 public void test03()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt0.setValid();
      assertTrue(appt0.getValid());
      /* test starthour */
      Appt appt1 = new Appt(30, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt1.setValid();
      assertFalse(appt1.getValid());
      Appt appt2 = new Appt(-3, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt2.setValid();
      assertFalse(appt2.getValid());
      // appt2.setValid();
      // System.err.print("\tThis appointment is not valid");
      // assertEquals("\tThis appointment is not valid", appt2.toString());
      /* test startmin */
      Appt appt3 = new Appt(15, 60, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt3.setValid();
      assertFalse(appt3.getValid());
      Appt appt4 = new Appt(15, -2, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt4.setValid();
      assertFalse(appt4.getValid());
      /* test startmonth */
      Appt appt5 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt5.setValid();
      assertFalse(appt5.getValid());
      Appt appt6 = new Appt(15, 30, 9, 0, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt6.setValid();
      assertFalse(appt6.getValid());
      /* test startyear  */
      Appt appt7 = new Appt(15, 30, 9, 14, -3, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt7.setValid();
      assertFalse(appt7.getValid());

}

}
