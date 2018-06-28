package com.vn.ivs.ctu.utils;

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
}
