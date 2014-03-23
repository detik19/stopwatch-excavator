package net.rt.stopwatch.model;

import java.io.*;
import javax.swing.*;
import java.util.Scanner;

/**********************************************************************
StopWatch.java implements a virtual stop watch that tracks time to the 
millisecond and can be added to other stop watches, reset, incremented, 
loaded, and saved

The Driver Class for StopWatch.java is the StopWatchGUIPanel.java class
The JUnit Test Class for StopWatch.java is the StopWatchTest.java class

@author Joe Gibson
@version 09.17.12
***********************************************************************/
public class StopWatch {
	
	/** Minutes on the stop watch */
	private int minutes;
	
	/** Seconds on the stop watch */
	private int seconds;
	
	/** Milliseconds on the stop watch */
	private int milliseconds;
	
	/** Number of stop watches created */
	private static int stopWatchesCreated = 0;
	
	/** Last directory accessed for load() and save() methods */
	private static String lastDirectory = "~/";
	
	/** File chooser for load() and save() methods */
	JFileChooser chooser;

	
	/******************************************************************
	Default constructor creates a stop watch with the value 0:00:000
	******************************************************************/
	public StopWatch() {
		
		//Initialize all variables to zero
		minutes = 0;
		seconds = 0;
		milliseconds = 0;
		
		//Increment the number of stop watches created
		stopWatchesCreated++;
	}
	
	
	/******************************************************************
	Constructor creates a stop watch given an initial value for the
	minutes, seconds, and milliseconds
	@param minutes
	@param seconds
	@param milliseconds
	******************************************************************/
	public StopWatch(int minutes, int seconds, int milliseconds) {
		
		//Initialize each variable to the given initial time
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
		
		//Carry over any excess amount of seconds or milliseconds
		carryOver();
		
		//Increment the number of stop watches created
		stopWatchesCreated++;
	}
	
	
	/******************************************************************
	Constructor creates a stop watch given an initial value for the
	seconds, and milliseconds
	@param seconds
	@param milliseconds
	******************************************************************/
	public StopWatch(int seconds, int milliseconds) {
		
		//Initialize minutes to zero
		minutes = 0;
		
		//Initialize seconds and milliseconds to the given value
		this.seconds = seconds;
		this.milliseconds = milliseconds;
		
		//Carry over any excess amount of seconds or milliseconds
		carryOver();
		
		//Increment the number of stop watches created
		stopWatchesCreated++;
	}
	
	
	/******************************************************************
	Constructor creates a stop watch given an initial value for the
	milliseconds only
	@param milliseconds
	******************************************************************/
	public StopWatch(int milliseconds) {
		
		//Initialize minutes and seconds to zero
		minutes = 0;
		seconds = 0;
		
		//Initialize milliseconds to the given initial value
		this.milliseconds = milliseconds;
		
		//Carry over any excess amount of seconds or milliseconds
		carryOver();
		
		//Increment the number of stop watches created
		stopWatchesCreated++;
	}
	
	/******************************************************************
	Constructor creates a stop watch given string of minutes, seconds,
	and milliseconds
	@param string in the format "minutes:seconds:milliseconds"
	******************************************************************/
	public StopWatch(String startTime) {
		
		//Check for how many ':'s are in the parameter string
		int count = countOccurrences(startTime, ':');
		
		//Initialize two index variables for parsing the string
		int index = 0;
		int index2 = 0;
		
		//Parse the string based on number of ':'s
		switch(count) {
		
		case 0 : 
			minutes = 0;
			seconds = 0;
			
			//Convert entire string to an integer
			milliseconds = Integer.parseInt(startTime);
			break;

		case 1 :
			index = startTime.indexOf(':');
			minutes = 0;
			
			//Parse the seconds by starting at the 
			//beginning of the string until the ':'
			seconds = Integer.parseInt(startTime.substring(0, index));
			
			//Parse the milliseconds by starting at the ':' and
			//ending at the last character
			milliseconds = Integer.parseInt(startTime.substring(index 
					+ 1, startTime.length()));
			break;

		case 2 :
			index = startTime.indexOf(':');
			index2 = startTime.lastIndexOf(':');
			
			//Parse all three by sectioning off three substrings
			//around the ':'s
			minutes = Integer.parseInt(startTime.substring(0, index));
			seconds = Integer.parseInt(startTime.substring(index + 1,
					index2));
			milliseconds = Integer.parseInt(startTime.substring(index2 
					+ 1, startTime.length()));
			break;

		default :
			break;
		}
		
		//Carry over any excess amount of seconds or milliseconds
		carryOver();
		
		//Increment the number of stop watches created
		stopWatchesCreated++;
	}
	
	
	/******************************************************************
	Reset the time to 0:00:000
	@param none
	@return none
	******************************************************************/
	public void reset() {
		this.minutes = 0;
		this.seconds = 0;
		this.milliseconds = 0;
	}
	
	
	/******************************************************************
	Returns the minutes of this stop watch
	@param none
	@return minutes on stop watch
	******************************************************************/
	public int getMinutes() {
		return minutes;
	}

	
	/******************************************************************
	Sets the number of minutes on this stop watch
	@param number of minutes
	@return none
	******************************************************************/
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	
	/******************************************************************
	Returns the seconds of this stop watch
	@param none
	@return seconds on stop watch
	******************************************************************/
	public int getSeconds() {
		return seconds;
	}

	
	/******************************************************************
	Sets the number of seconds on this stop watch
	@param number of seconds
	@return none
	******************************************************************/
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	
	/******************************************************************
	Returns the milliseconds of this stop watch
	@param none
	@return milliseconds on stop watch
	******************************************************************/
	public int getMilliseconds() {
		return milliseconds;
	}

	
	/******************************************************************
	Sets the number of milliseconds on this stop watch
	@param number of milliseconds
	@return none
	******************************************************************/
	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}

	
	/******************************************************************
	Checks to see if this stop watch's total time in milliseconds is
	equal to the total time in milliseconds of a given stop watch
	@param a comparison stop watch
	@return true or false
	******************************************************************/
	public boolean equals(StopWatch other) {
		if(minutes == other.minutes && seconds == other.seconds && 
				milliseconds == other.milliseconds)
			return true;
		else
			return false;
	}
	
	
	/******************************************************************
	Returns the total time on this stop watch in milliseconds
	@param none
	@return  total time in milliseconds
	******************************************************************/
	public int totalMilliseconds() {
		return milliseconds + (seconds * 1000) + (minutes * 60000);
	}
	
	
	/******************************************************************
	Determines, in numeric order, whether this stop watch is less than,
	greater than, or equal to a given stop watch by comparing their 
	total number of milliseconds
	@param a comparison stop watch
	@return 1 if this greater, 0 if equal, -1 if less, else -2
	******************************************************************/
	public int compareTo(StopWatch other) {
		if(this.totalMilliseconds() > other.totalMilliseconds())
			return 1;
		else if(this.totalMilliseconds() < other.totalMilliseconds())
			return -1;
		else if(this.equals(other))
			return 0;
		else
			return -2;
	}
	
	
	/******************************************************************
	Adds the given number of milliseconds to the stop watch
	@param number of milliseconds
	@return none
	******************************************************************/
	public void add(int milliseconds) {
		this.milliseconds += milliseconds;
		
		//Carry over any excess amount of seconds or 
		//milliseconds after adding
		carryOver();
	}
	
	
	/******************************************************************
	Adds the value of a given stop watch to this stop watch
	@param a stop watch to add
	@return none
	******************************************************************/
	public void add(StopWatch other) {
		this.minutes += other.minutes;
		this.seconds += other.seconds;
		this.milliseconds += other.milliseconds;
		
		//Carry over any excess amount of seconds or milliseconds
		carryOver();
	}
	
	
	/******************************************************************
	Increments this stop watch by 1 millisecond
	@param none
	@return none
	******************************************************************/
	public void inc() {
		this.milliseconds++;
		carryOver();
	}
	
	
	/******************************************************************
	Counts the number of occurrences of a given character in a given 
	string
	@param string to search in
	@param character to search for
	@return number of occurrences of character in string
	******************************************************************/
	public int countOccurrences(String s, char c) {
		int count = 0;
		
		for(int i = 0; i < (s.length() - 1); i++) {
			if(s.charAt(i) == c)
				count++;
		}
		
		return count;
	}
	
	
	/******************************************************************
	Saves the time information into a file using the showSaveDialog in
	the format 'minutes' \n 'seconds' \n 'milliseconds' \n
	@param none
	@return none
	******************************************************************/
	public void save() {
		
		//Create file chooser to initialize in the last directory
		chooser = new JFileChooser(lastDirectory);
		
		//Catch an IOException error
		try {
			
			//Display the save dialog
			int status = chooser.showSaveDialog(null);
			
			//Alert that no file has been selected if necessary
			if(status != JFileChooser.APPROVE_OPTION)
				JOptionPane.showMessageDialog(null, 
						"No file selected!");
			else {
				
				//Initialize a PrintWriter
				PrintWriter out = null;
				
				//Get the selected file and store it's path as the 
				//last directory
				File file = chooser.getSelectedFile();
				lastDirectory = file.getPath();
				
				//Print the stop watch's time information to the 
				//file and close it
				out = new PrintWriter(new BufferedWriter( 
						new FileWriter(file)));
				out.println("" + this.minutes + " " + this.seconds + 
						" " + this.milliseconds + " \n");
				out.close();
			}
		} catch(IOException error) {
			
			//Alert that the saving process was unable to succeed
			JOptionPane.showMessageDialog(null, 
					"Unable to save file!");
		}
	}
	
	
	/******************************************************************
	Loads time information from a file into the stop watch
	@param none
	@return none
	******************************************************************/
	public void load() {
		
		//Create JFileChooser to initialize in the last directory
		chooser = new JFileChooser(lastDirectory);
		
		//Catch an IOException error
		try {
			
			//Display the open dialog
			int status = chooser.showOpenDialog(null);
			
			//Alert that no file has been selected if necessary
			if(status != JFileChooser.APPROVE_OPTION)
				JOptionPane.showMessageDialog(null, 
						"No file selected!");
			else {
				//Get the selected file and store it's path as the 
				//last directory
				File file = chooser.getSelectedFile();
				lastDirectory = file.getPath();
				
				//Set up a scanner to read the file
				Scanner scan = new Scanner(file);
				
				//Scan the information from the file into temporary 
				//variables
				int tempM = scan.nextInt();
				int tempS = scan.nextInt();
				int tempMs = scan.nextInt();

				//Set the current time information to the 
				//new information
				this.minutes = tempM;
				this.seconds = tempS;
				this.milliseconds = tempMs;
				
				//If the file is empty, initialize time information to 
				//0:00:000
				if(file.toString().equals(null)) {
					this.minutes = 0;
					this.seconds = 0;
					this.milliseconds = 0;
				}
			}
		} catch(IOException error) {
			
			//Alert that the loading process was unable to succeed
			JOptionPane.showMessageDialog(null, "Load failed!");
		}
	}
	
	
	/******************************************************************
	Converts the time information from integers to a string formatted 
	as "M:SS:mmm" maintaining leading zeros where necessary
	@param none
	@return formatted string
	******************************************************************/
	public String toString() {
		String s = "";

		s += minutes + ":";

		if(seconds < 10)
			s += "0";
		s += seconds + ":";

		if(milliseconds < 100)
			s += "0";
		if(milliseconds < 10)
			s += "0";
		s += milliseconds;

		return s;
	}
	
	
	/******************************************************************
	Returns the number of stop watches created 
	@param none
	@return number of stop watches created
	******************************************************************/
	public static int getNumberCreated() {
		return stopWatchesCreated;
	}
	
	
	/******************************************************************
	Carries over any excess amount of seconds or milliseconds as needed
	@param none
	@return none
	******************************************************************/
	public void carryOver() {
		
		//If milliseconds are overflowing, convert excess to seconds 
		//and the remainder stays milliseconds
		if(milliseconds >= 1000) {
			this.seconds += this.milliseconds / 1000;
			this.milliseconds = this.milliseconds % 1000;
		}
		
		
		//If seconds are overflowing, convert excess to minutes 
		//and the remainder stays seconds
		if(this.seconds >= 60) {
			this.minutes += this.seconds / 60;
			this.seconds = this.seconds % 60;
		}
	}
	
	
	/******************************************************************
	Main method to test stop watches in addition to JUnit Test
	@param array of string arguments
	@return none
	******************************************************************/
	public static void main(String[] args) {
		
		//Used in StopWatchGUIPanel to use the Apple Menu bar
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		
		/*
		Main Method Tests
		
		StopWatch s = new StopWatch(20);
		StopWatch s2 = new StopWatch(100,2300,600);
		StopWatch s3 = new StopWatch("3:60:1000");
		StopWatch s4 = new StopWatch("65100");
		StopWatch s5 = new StopWatch("04:600:61800");
		StopWatch s6 = new StopWatch("64:4200");

		System.out.println(s);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
		
		s.save();
		s6.load();
		
		System.out.println(s6);
		*/
	}
}
