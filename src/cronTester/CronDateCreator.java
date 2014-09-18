package cronTester;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.CronExpression;

public class CronDateCreator {
	
	private CronExpression cron;
	
	public CronDateCreator(CronExpression cron) {
		this.cron = cron;
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
