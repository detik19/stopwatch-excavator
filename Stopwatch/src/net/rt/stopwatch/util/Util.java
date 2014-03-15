package net.rt.stopwatch.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Util {
	
	public static String Date2String(Date date){
		SimpleDateFormat sdp=new SimpleDateFormat("dd/MM/yyyy");
		sdp.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		return sdp.format(date);
		//return null;
		
	}
	public static String Date2TimeStr(Date date){
		SimpleDateFormat sdp=new SimpleDateFormat("HH:mm:ss");
		sdp.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

		return sdp.format(date);
		//return null;
		
	}
}
