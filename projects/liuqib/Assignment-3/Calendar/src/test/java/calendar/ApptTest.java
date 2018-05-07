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


      //mutation test
      Appt appt8 = new Appt(15, 30, 9, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt8.setValid();
      assertTrue(appt8.getValid());
      Appt appt9 = new Appt(15, 30, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt9.setValid();
      assertTrue(appt9.getValid());
      Appt appt10 = new Appt(0, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt10.setValid();
      assertTrue(appt10.getValid());
      Appt appt11 = new Appt(23, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt11.setValid();
      assertTrue(appt11.getValid());
      Appt appt12 = new Appt(15, 0, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt12.setValid();
      assertTrue(appt12.getValid());
      Appt appt13 = new Appt(15, 59, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt13.setValid();
      assertTrue(appt13.getValid());
      Appt appt14 = new Appt(15, 30, 9, 10, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt14.setValid();
      assertFalse(appt14.getValid());
      Appt appt15 = new Appt(15, 30, 31, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt15.setValid();
      assertTrue(appt15.getValid());
      Appt appt16 = new Appt(15, 30, 1, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt16.setValid();
      assertTrue(appt16.getValid());
      // Appt appt17 = new Appt(-15, -2, -9, -10, -2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      // appt17.setValid();
      // assertFalse(appt17.getValid());
      // assertEquals("\t-10/-9/-2018 at -15:-2am ,Birthday Party, This is my birthday party\n", appt17.toString());
      Appt appt18 = new Appt(11, 30, 15, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      assertEquals("\t1/15/2018 at 11:30am ,Birthday Party, This is my birthday party\n", appt18.toString());

}

}
