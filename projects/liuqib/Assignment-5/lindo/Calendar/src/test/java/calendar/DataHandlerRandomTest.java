package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

    /**
     * Generate Random Tests that tests DataHandler Class.
     */
    private static final long TestTimeout = 3 * 1000 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=25;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
    }
    /**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }

	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{

			DataHandler getApptRangeHandler2 = new DataHandler();

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis();
				Random random = new Random(randomseed);

		        GregorianCalendar gregDay0 = new GregorianCalendar(2000, 10, 15);
		        GregorianCalendar gregDay1 = new GregorianCalendar(2005, 10, 15);

		        DataHandler handler = new DataHandler("calendar.xml");
				DataHandler handler2 = new DataHandler("calendar.xml", false);
				DataHandler getApptRangeHandler = new DataHandler("calendar.xml");

				for (int i = 0; i < NUM_TESTS; i++) {

					String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
					//System.out.println(methodName);
					if (methodName.equals("deleteAppt")){
						//System.out.println("deleteAppt");
						int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
						int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
						int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
						int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
						int startYear=ValuesGenerator.getRandomIntBetween(random, 1, 100);
						String title="Birthday Party";
						String description="This is my birthday party.";
						String emailAddress="xyz@gmail.com";

						Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
						appt.setValid();
						handler.saveAppt(appt);
						handler.deleteAppt(appt);

						startHour=ValuesGenerator.getRandomIntBetween(random, -5, -1);
						startMinute=ValuesGenerator.getRandomIntBetween(random, -60, -1);
						startDay=ValuesGenerator.getRandomIntBetween(random, -31, -1);
						startMonth=ValuesGenerator.getRandomIntBetween(random, -12, -1);
						startYear=ValuesGenerator.getRandomIntBetween(random, -2000, -1);


						//Construct a new Appointment object with the initial data
						//Construct a new Appointment object with the initial data
						appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description,
						emailAddress);
						appt.setValid();
						handler.saveAppt(appt);
						handler.deleteAppt(appt);


					}

					else if (methodName.equals("getApptRange")){
						//System.out.println("getApptRange");

						int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
						int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
						int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
						int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
						int startYear=ValuesGenerator.getRandomIntBetween(random, 2004, 2005);
						String title="Birthday Party";
						String description="This is my birthday party.";
						String emailAddress="xyz@gmail.com";

						//Construct a new Appointment object with the initial data
						Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
						appt.setValid();

						//Set appointment recurrence to enter while(strk.hasMoreTokens()) loop
						int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
					   	int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
					   	int recur=ApptRandomTest.RandomSelectRecur(random);
					  	int recurIncrement = ValuesGenerator.RandInt(random);
					   	int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
					   	appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

					   	//getApptRangeHandler.saveAppt(appt);
						getApptRangeHandler.getApptRange(gregDay0, gregDay1);

					}

				}

				//long randomseed =System.currentTimeMillis();
				//Random random = new Random(randomseed);
				int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
				int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
				int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear=ValuesGenerator.getRandomIntBetween(random, 0, 2018);
				String title="Birthday Party";
				String description="This is my birthday party.";
				String emailAddress="xyz@gmail.com";

				//Construct a new Appointment object with the initial data
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description,
				emailAddress);
				appt.setValid();
				appt.setXmlElement(null);
				handler2.deleteAppt(appt);
				handler2.saveAppt(appt);
				handler2.deleteAppt(appt);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){
			System.out.println("NullPointerException");
		}
		try{
			DataHandler getApptRangeHandler2 = new DataHandler();
			GregorianCalendar gregDay2 = new GregorianCalendar(1000, 10, 15);
		    GregorianCalendar gregDay3 = new GregorianCalendar(2000, 10, 15);
			getApptRangeHandler2.getApptRange(gregDay3, gregDay2);
		}catch(DateOutOfRangeException d){
			System.out.println("Error: day of last appointment comes before day of first appointment");
		}

		 System.out.println("Done testing...");
	}


}
