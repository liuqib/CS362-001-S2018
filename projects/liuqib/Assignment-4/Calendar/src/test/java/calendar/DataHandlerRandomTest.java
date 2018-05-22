package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.GregorianCalendar;
import org.junit.Test;
import java.util.*;


import static org.junit.Assert.*;
import java.util.EmptyStackException;
/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 6 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	/**
	 * Return a randomly selected method to be tests !.
	 */

		public static String RandomSelectMethod(Random random){
				String[] methodArray = new String[] {"deleteAppt","getApptRange"};// The list of the of methods to be tested in the Appt class

			int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

				return methodArray[n] ; // return the method name
				}
    /**
     * Generate Random Tests that tests DataHandler Class.
     */


@Test
	  public void radnomtest()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
 			System.out.println("Start test DataHandler...");

 try{
	 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
		 long randomseed =System.currentTimeMillis(); //10
		 Random random = new Random(randomseed);
		 Calendar current = Calendar.getInstance();
		//  int thisMonth = current.get(Calendar.MONTH)+1;
		// 	int thisYear = current.get(Calendar.YEAR);
		// 	int thisDay = current.get(Calendar.DAY_OF_MONTH);
		// GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		int randbuffer = random.nextInt(3) + 2;//generate ramdom value between 2-4
		// GregorianCalendar tomorrow = new GregorianCalendar(thisYear, thisMonth, thisDay + randbuffer);
		//construct a new calendar time
	 DataHandler DataHandler = new DataHandler();

	 int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 int thisYear = ValuesGenerator.getRandomIntBetween(random, 2010, 2018);
	 int thisDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
	 GregorianCalendar today = new GregorianCalendar(2018, 5, 21);
	 GregorianCalendar tomorrow = new GregorianCalendar(2018, 5, 22);

	 CalDay calday = new CalDay(today);

	 	LinkedList<Appt> listAppts = new LinkedList<Appt>();
	 	LinkedList<Appt> listAppts2 = new LinkedList<Appt>();//contain null appt
	 	LinkedList<Appt> listAppts3 = null;//contain null appts
	 	LinkedList<Appt> listAppts4 = new LinkedList<Appt>();
		LinkedList<Appt> listAppts5 = new LinkedList<Appt>();
	 for (int i = 0; i < NUM_TESTS; i++) {
		 String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
		 int startHour=ValuesGenerator.getRandomIntBetween(random, -10,25);
		 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10,70);
		 int startDay=ValuesGenerator.getRandomIntBetween(random, -10,35);
		 int startMonth=ValuesGenerator.getRandomIntBetween(random, -10,15);
		 int startYear=ValuesGenerator.RandInt(random);
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 String emailAddress="xyz@gmail.com";
		 int buffer = random.nextInt(10);
		 int[] recurringDays = new int[buffer];
		 // int[] extrarecurringDays = new int[7];
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
							startMinute ,
							startDay ,
							startMonth ,
							startYear ,
							title,
						 description,
						 emailAddress);
		Appt appt3 = new Appt(16, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		Appt appt2 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt3.setRecurrence(recurringDays, 1, 1, 1);
		// appt4.setRecurrence(extrarecurringDays, 1, 1, 1);
			if (methodName.equals("deleteAppt")){
				int coin = random.nextInt(4);
				if(coin == 0){
					// calday.addAppt(appt);
					DataHandler.saveAppt(appt);
					DataHandler.deleteAppt(appt);            //listAppts3,
				}
				else if(coin == 1){
					Appt appt4 = new Appt(16, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
					appt4.setValid();
					// calday.addAppt(appt3);
					DataHandler datah1 = new DataHandler("calendar.xml", false);
					// datah1.saveAppt(appt3);
					datah1.deleteAppt(appt4);
			  }
			 	else if(coin == 2){
					// calday.addAppt(appt2);
					// listAppts4.add(appt2);
					appt2.setValid();
					appt2.setXmlElement(null);
					DataHandler datah2 = new DataHandler("calendar.xml", false);
				  datah2.deleteAppt(appt2);
			 }
				else{
					Appt appt6 = new Appt(15, 30, 9, 0, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
					appt6.setValid();
					assertFalse(appt6.getValid());
					// calday.addAppt(appt6);
					// listAppts5.add(appt6);
					DataHandler.saveAppt(appt6);
					DataHandler.deleteAppt(appt6);
				}
			 }/*End if statement*/

			else if(methodName.equals("getApptRange")){
				// int coin = random.nextInt(3);
				int coin = random.nextInt(3);
				if(coin == 0){
					GregorianCalendar cal = new GregorianCalendar();
					cal.set(startYear, startMonth, startDay);

					GregorianCalendar cal2 = new GregorianCalendar();
					cal2.set(startYear, startMonth, startDay);
					GregorianCalendar cal4 = new GregorianCalendar();
					assertTrue(appt.getValid());
					// CalDay calday = new CalDay(cal);
					CalDay calday2 = new CalDay(cal2);
					CalDay calday4 = new CalDay(cal4);
					calday.addAppt(appt);
					calday2.addAppt(appt3);
					calday.toString();
					assertTrue(appt.getValid());
					calday.getAppts();

				 assertTrue(calday.isValid());
				 assertTrue(calday2.isValid());
				 calday4.isValid();
					assertTrue(DataHandler.save());
				 assertNotNull(DataHandler.getApptRange(cal2, cal));
					assertTrue(DataHandler.saveAppt(appt));
					assertTrue(DataHandler.deleteAppt(appt));
					DataHandler.getApptRange(cal,cal2);
					CalDay calday3 = new CalDay(cal2);
					calday3.addAppt(appt2);
					assertFalse(calday3.isValid());
					assertFalse(DataHandler.saveAppt(appt3));
					assertFalse(DataHandler.deleteAppt(appt3));

				}
				else if(coin == 1){
						listAppts2.add(appt);
						listAppts2.add(appt3);

						DataHandler.getApptRange( today, tomorrow);
				}
				else if(coin == 2){

					 try{
					DataHandler.getApptRange( null, null);
				 }
				 catch(DateOutOfRangeException e){}
				}

			 }/*End else if statement*/

		 }


	 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 if((iteration%10000)==0 && iteration!=0 )
			 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

	 }
 }catch(NullPointerException e){

 }


 System.out.println("End test DataHandler...");


	 }



}
