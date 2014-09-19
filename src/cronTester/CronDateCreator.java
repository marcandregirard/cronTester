package cronTester;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.CronExpression;

public class CronDateCreator {
	
	private CronExpression cron;
	
	public CronDateCreator(String cronExpressionRaw) {
		try {
			this.cron = new CronExpression(cronExpressionRaw);
		} catch (ParseException e) {
			throw new IllegalArgumentException("The cron expression supplied is not a valid cron expression.",e);
		}
	}
	
	public List<Date> createValidTimeDates(Date startingDate, int numberOfDates) { 
		Date nextValidDate = cron.getNextValidTimeAfter(startingDate);
		List<Date> results = new ArrayList<>();
		
		for (int i = 0; i < numberOfDates; i++) {
			results.add(nextValidDate);
			nextValidDate = cron.getNextValidTimeAfter(nextValidDate);
		}
		
		return results;
	}
	
	public List<Date> createValidTimeDatesFromNow(int numberOfDates) {
		return createValidTimeDates(new Date(), numberOfDates);
	}

}
