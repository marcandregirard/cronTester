package cronTester;

import java.util.Date;
import java.util.List;


public class CronTester {

	/**
	 * The application take two arguments : 
	 * The first argument is the cron expression surrounded by " : "* * * * * *"
	 * The second argument is the number of dates you want to verify. It's a simple Integer.
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length > 2) {
			throw new IllegalArgumentException("You should only provide 2 arguments. \"[cronExpression]\" [numberOfDates]");
		} else if (args.length != 2) {
			throw new IllegalArgumentException("You need to provide 2 arguments in the following form : \"[cronExpression]\" [numberOfDates]");
		}
		
		final String expression = args[0];
		final int numberOfDates;
		
		try {
			numberOfDates = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The second argument need to be a valid integer.");
		}
		
		final CronDateCreator dateCreator = new CronDateCreator(expression);
		List<Date> result = dateCreator.createValidTimeDatesFromNow(numberOfDates);
		
		for(Date expected : result) {
			System.out.println(expected);
		}

	}

	
	

}
