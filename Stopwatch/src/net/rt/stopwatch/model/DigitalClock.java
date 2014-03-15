package net.rt.stopwatch.model;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DigitalClock extends JLabel {
	private String pattern;
	private Timer timer;
	private int delay;
	private Date date;
	/**
	 * Constructs a Digital Clock using the given pattern and the default delay.
	 * @param pattern - the pattern describing the date and time format 
	 */
	public DigitalClock(String pattern){
		this.pattern = pattern;
		this.delay = 1000;
		createTimer();
		timer.start();
	}
	/**
	 * Constructs a Digital Clock using the given pattern and delay.
	 * @param delay - the number of milliseconds between action events
	 * @param pattern - the pattern describing the date and time format 
	 */
	public DigitalClock(String pattern, int delay){
		this.pattern = pattern;
		this.delay = delay;
		createTimer();
		timer.start();
	}
	/**
	 * Constructs a Digital Clock using the default pattern and delay.
	 */
	
	public DigitalClock(){
		pattern = "hh:mm:ss a";
	
		this.delay = 1000;
		createTimer();
		timer.start();
	}
	private void createTimer(){
		timer = new Timer(delay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//setText(new SimpleDateFormat(pattern).format(new Date()));
				setText(Date2DateAndTimeStr(new Date()));
			}
		});
	}
	public static String Date2DateAndTimeStr(Date date){
		SimpleDateFormat sdp=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdp.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));

		return sdp.format(date);
	}
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Timer getTimer() {
		return timer;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
}
