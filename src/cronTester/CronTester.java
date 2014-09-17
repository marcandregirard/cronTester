package cronTester;

import java.text.ParseException;
import java.util.ArrayList;
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
		List<Date> result = createValidTimeDates(cronExpression,numberOfDates);
		for(Date expected : result) {
			System.out.println(expected);
		}

	}
	
	private static List<Date> createValidTimeDates(CronExpression cron, int numberOfDates) { 
		Date nextValidDate = cron.getNextValidTimeAfter(new Date());
		List<Date> results = new ArrayList<>();
		for (int i = 0; i < numberOfDates; i++) {
			results.add(nextValidDate);
			nextValidDate = cron.getNextValidTimeAfter(nextValidDate);
		}
		return results;
	}

}
