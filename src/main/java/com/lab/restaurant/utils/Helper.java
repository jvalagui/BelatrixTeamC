package main.java.com.lab.restaurant.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static String dateFormat(Date myDate){
		return sdf.format(myDate);
	}
	
}
