package com.vn.ivs.ctu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
	
	public static int getCurentMonth() {		
        GregorianCalendar date = new GregorianCalendar();      
        return date.get(Calendar.MONTH) + 1;        
	}
	public static int getCurentYear() {		
        GregorianCalendar date = new GregorianCalendar();      
        return date.get(Calendar.YEAR);        
	}
	public static int getDateOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	public static int getWeekOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);        
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	public static int getCurrentWeekend() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.WEEK_OF_YEAR);
		
	}
	public static void main(String []args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "14-6-2018";
        Date date = formatter.parse(dateInString);
		System.out.println(getWeekOfYear(date));
	}
}
