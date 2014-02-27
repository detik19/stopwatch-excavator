package net.rt.stopwatch.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

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
public class UIFrame extends javax.swing.JFrame {
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
	private JScrollPane jScrollPane2;
	private JTable jTableAux;
	private JScrollPane jScrollPane1;
	private JTable jTableMain;
	private JPanel jPanelTable;
	private ImageIcon ledOff;
	private JPanel jPanelControl;
	private JPanel jPanelTop;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIFrame inst = new UIFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public UIFrame() {
		super();
		initGUI();
	}
	private void initStopWatch(){
		stopWatch = new StopWatch();
		timer = new Timer(3, new TimerListener());
		ledTimer = new Timer(500, new LedTimerListener());
		ledOn = new ImageIcon("ledOn32.png");
		ledOff = new ImageIcon("ledOff32.png");
		ledLabel = new JLabel();
		ledLabel.setIcon(ledOff);
		ledOn = new ImageIcon("ledOn32.png");
		ledOff = new ImageIcon("ledOff32.png");

		ButtonListener listener = new ButtonListener();
		{
			jPanelTop = new JPanel();
			GridBagLayout jPanelTopLayout = new GridBagLayout();
			getContentPane().add(jPanelTop, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelTopLayout.rowWeights = new double[] {0.1, 0.1};
			jPanelTopLayout.rowHeights = new int[] {20, 7};
			jPanelTopLayout.columnWeights = new double[] {0.0, 0.1};
			jPanelTopLayout.columnWidths = new int[] {300, 7};
			jPanelTop.setLayout(jPanelTopLayout);
			{
				timeWindow = new JLabel(stopWatch.toString());
				jPanelTop.add(timeWindow, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				timeWindow.setFont(new Font("Calibri", Font.BOLD, 32)); 
				timeWindow.setForeground(new java.awt.Color(255,128,0));
				timeWindow.setPreferredSize(new java.awt.Dimension(229, 97));
			}
			{
				jPanelControl = new JPanel();
				GridBagLayout jPanelControlLayout = new GridBagLayout();
				jPanelControlLayout.columnWidths = new int[] {183, 7};
				jPanelControlLayout.rowHeights = new int[] {7, 7, 7, 7};
				jPanelControlLayout.columnWeights = new double[] {0.0, 0.1};
				jPanelControlLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanelTop.add(jPanelControl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanelControl.setLayout(jPanelControlLayout);
				{
					stopButton = new JButton("Stop");
					jPanelControl.add(stopButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					stopButton.setPreferredSize(new java.awt.Dimension(100, 30));
					stopButton.setSize(200, 30);
					stopButton.addActionListener(listener);
				}
				{
					startButton = new JButton("Start");
					jPanelControl.add(startButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					startButton.setPreferredSize(new java.awt.Dimension(100, 30));
					startButton.addActionListener(listener);
				}
				{
					resetButton = new JButton("Reset");
					jPanelControl.add(resetButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					resetButton.setPreferredSize(new java.awt.Dimension(100, 30));
					resetButton.setSize(100, 30);
					resetButton.addActionListener(listener);
				}
				{
					ledLabel = new JLabel();
					jPanelControl.add(ledLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					ledLabel.setIcon(ledOff);
					ledLabel.setPreferredSize(new Dimension(32,32));
				}
			}
			{
				
			}
			
		}
		{
			jPanelTable = new JPanel();
			GridBagLayout jPanelTableLayout = new GridBagLayout();
			jPanelTableLayout.columnWidths = new int[] {7, 7};
			jPanelTableLayout.rowHeights = new int[] {7};
			jPanelTableLayout.columnWeights = new double[] {0.1, 0.1};
			jPanelTableLayout.rowWeights = new double[] {0.1};
			getContentPane().add(jPanelTable, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelTable.setLayout(jPanelTableLayout);
			{
				jScrollPane1 = new JScrollPane();
				jPanelTable.add(jScrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					TableModel jTableMainModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });
					jTableMain = new JTable();
					jScrollPane1.setViewportView(jTableMain);
					jTableMain.setModel(jTableMainModel);
				}
			}
			{
				jScrollPane2 = new JScrollPane();
				jPanelTable.add(jScrollPane2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					TableModel jTableAuxModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });
					jTableAux = new JTable();
					jScrollPane2.setViewportView(jTableAux);
					GridBagLayout jTableAuxLayout = new GridBagLayout();
					jTableAuxLayout.columnWidths = new int[] {7, 7, 7, 7};
					jTableAuxLayout.rowHeights = new int[] {7, 7, 7, 7};
					jTableAuxLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jTableAuxLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jTableAux.setModel(jTableAuxModel);
					jTableAux.setLayout(null);
				}
			}
		}
	}
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {-1, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.1};
			thisLayout.columnWidths = new int[] {7};
			getContentPane().setLayout(thisLayout);
			initStopWatch();
			pack();
			this.setSize(755, 550);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
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
