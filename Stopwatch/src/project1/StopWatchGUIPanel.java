package project1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.rt.stopwatch.model.StopWatch;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class StopWatchGUIPanel extends JPanel {
	private static final long serialVersionUID = 7487661355099475892L;

	private StopWatch stopWatch;
	
	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	
	private JLabel timeWindow;
	
	private Timer timer;
	private Timer ledTimer;
	
	private boolean ledStatus = false;
	private JLabel ledLabel;
	private ImageIcon ledOn;
	private ImageIcon ledOff;
	
	private JMenuItem saveMenuItem, loadMenuItem, aboutMenuItem;
	
	public StopWatchGUIPanel(JMenuItem saveMenuItem, JMenuItem loadMenuItem, JMenuItem aboutMenuItem) {
		this.saveMenuItem = saveMenuItem;
		this.loadMenuItem = loadMenuItem;
		this.aboutMenuItem = aboutMenuItem;
		
		stopWatch = new StopWatch();
		timer = new Timer(3, new TimerListener());
		ledTimer = new Timer(500, new LedTimerListener());
		
		ledOn = new ImageIcon("ledOn32.png");
		ledOff = new ImageIcon("ledOff32.png");
		ledLabel = new JLabel();
		ledLabel.setIcon(ledOff);
		
		ledLabel.setPreferredSize(new Dimension(32,32));
		
		add(ledLabel);
		
		timeWindow = new JLabel(stopWatch.toString());
		timeWindow.setFont(new Font("Calibri", Font.BOLD, 32)); 
		timeWindow.setForeground(Color.white);
		
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		resetButton = new JButton("Reset");
		
		startButton.setPreferredSize(new Dimension(200,50));
		stopButton.setPreferredSize(new Dimension(200,50));
		resetButton.setPreferredSize(new Dimension(200,50));
		
		ButtonListener listener = new ButtonListener();
		startButton.addActionListener(listener);
		stopButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		
		saveMenuItem.addActionListener(listener);
		loadMenuItem.addActionListener(listener);
		aboutMenuItem.addActionListener(listener);
		
		this.setPreferredSize(new java.awt.Dimension(652, 240));
	    setBackground (Color.darkGray);
		
		add(timeWindow, BorderLayout.NORTH);
		timeWindow.setPreferredSize(new java.awt.Dimension(229, 97));
		add(startButton, BorderLayout.CENTER);
		add(stopButton, BorderLayout.CENTER);
		add(resetButton, BorderLayout.CENTER);
	}
	
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			stopWatch.add(3);
			timeWindow.setText(stopWatch.toString());
		}
	}
	
	
	private class LedTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(!ledStatus) {
				ledStatus = true;
				ledLabel.setIcon(ledOn);
			}
			
			else {
				ledStatus = false;
				ledLabel.setIcon(ledOff);
			}
		}
	}
	
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == saveMenuItem) {
				stopWatch.save();
			}

			if(event.getSource() == loadMenuItem) {
				stopWatch.load();
			}

			if(event.getSource() == aboutMenuItem) {
				JOptionPane.showMessageDialog(null, "Stop Watch v1.0 \n Designed by Joe Gibson");
			}
			
			if(event.getSource() == startButton) {	
				ledTimer.start();
				timer.start();
			}

			if(event.getSource() == stopButton) {
				ledTimer.stop();
				ledLabel.setIcon(ledOn);
				timer.stop();
			}

			if(event.getSource() == resetButton) {
				timer.stop();
				ledTimer.stop();
				ledLabel.setIcon(ledOff);
				stopWatch.reset();
			}
			
			timeWindow.setText(stopWatch.toString());
		}
	}
}