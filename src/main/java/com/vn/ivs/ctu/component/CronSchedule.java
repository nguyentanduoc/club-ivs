package com.vn.ivs.ctu.component;

import java.util.Calendar;
import java.util.Date;

public class CronSchedule {
	    
	 public static void showCalendar() {
		
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 15);
		dt = c.getTime();
		
        int year = c.get(Calendar.YEAR);
       
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int millis = c.get(Calendar.MILLISECOND);
 
        System.out.println(" " + year + "-" + (month + 1) + "-" + day //
                + " " + hour + ":" + minute + ":" + second + " " + millis);
    }
 	
}
