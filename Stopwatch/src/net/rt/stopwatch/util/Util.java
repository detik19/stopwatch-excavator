package net.rt.stopwatch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static String Date2String(Date date){
		SimpleDateFormat sdp=new SimpleDateFormat("dd/MM/yyyy");
		return sdp.format(date);
		//return null;
		
	}
	public static String Date2TimeStr(Date date){
		SimpleDateFormat sdp=new SimpleDateFormat("HH:mm:ss");
		return sdp.format(date);
		//return null;
		
	}
}
