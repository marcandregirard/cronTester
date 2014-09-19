package cronTester;

import java.text.ParseException;
import java.time.Instant;
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
	
	public List<Instant> createValidTimeDates(Date startingDate, int numberOfDates) { 
		List<Instant> results = new ArrayList<>(numberOfDates);
		
		for (int i = 0; i < numberOfDates; i++) {
			startingDate = cron.getNextValidTimeAfter(startingDate);
			results.add(Instant.ofEpochMilli(startingDate.getTime()));
		}
		
		return results;
	}
	
	public List<Instant> createValidTimeDatesFromNow(int numberOfDates) {
		return createValidTimeDates(new Date(), numberOfDates);
	}

}
