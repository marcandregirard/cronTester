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
        final String expression = "0 0 0/4 ? * 2-6";
        final CronExpression cronExpression = new CronExpression(expression);
        Date nextValidDate1 = cronExpression.getNextValidTimeAfter(new Date());
        while(true) {
        	System.out.println(nextValidDate1);       	
        	nextValidDate1 = cronExpression.getNextValidTimeAfter(nextValidDate1);
        }
 

	}

}
