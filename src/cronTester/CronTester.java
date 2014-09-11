package cronTester;

import java.text.ParseException;
import java.util.Date;

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
        Date nextValidDate = cronExpression.getNextValidTimeAfter(new Date());
        for(int i = 0;i < numberOfDates; i++) {
        	System.out.println(nextValidDate);       	
        	nextValidDate = cronExpression.getNextValidTimeAfter(nextValidDate);
        }
 

	}

}
