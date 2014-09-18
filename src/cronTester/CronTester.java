package cronTester;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.quartz.CronExpression;

public class CronTester {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		final String expression = args[0];
		final int numberOfDates = Integer.parseInt(args[1]);
		final CronExpression cronExpression = new CronExpression(expression);
		final CronDateCreator dateCreator = new CronDateCreator(cronExpression);
		List<Date> result = dateCreator.createValidTimeDatesFromNow(numberOfDates);
		for(Date expected : result) {
			System.out.println(expected);
		}

	}
	
	

}
