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
			throw new IllegalArgumentException("The cron expression supplied is not a valid cron expression.", e);
		}
	}

	public List<Date> createValidTimeDates(Date startingDate, int numberOfDates) {
		List<Date> results = new ArrayList<>(numberOfDates);

		Date nextValidTimeAfter = startingDate;
		for (int i = 0; i < numberOfDates; i++) {
			Date cronDate = cron.getNextValidTimeAfter(nextValidTimeAfter);
			results.add(cronDate);
			nextValidTimeAfter = cronDate;
		}

		return results;
	}

	public List<Date> createValidTimeDatesFromNow(int numberOfDates) {
		return createValidTimeDates(new Date(), numberOfDates);
	}

}
