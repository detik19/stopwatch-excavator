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
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private StopWatch stopWatch;
	
	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	private JButton repairButton;
	private JButton reposisiButton;
	private JButton waitDSButton;

	private JLabel timeWindow;
	private Timer timer;
	private Timer ledTimer;
	private boolean ledStatus = false;
	private JLabel ledLabel;
	private ImageIcon ledOn;
	private JScrollPane jScrollPane1;
	private JTable jTableMain;
	private TableColumn column;
	private ImageIcon ledOff;
	private JTextField jTextFieldSite;
	private JTextField jTextFieldKodeUnit;
	private JTextField jTextFieldNRP;
	private JTextField jTextFieldName;
	private JButton splitButton;
	private JLabel jLabelSite;
	private JLabel jLabelKodeUnit;
	private JLabel jLabelNRP;
	private JLabel jLabelNama;
	private JPanel jPanelID;
	private JPanel jPanelControl;
	private JPanel jPanelTop;
	private JPanel jPanelTable;

	private String[] judul= {"No","Digging", "Swing Loaded", "Dumping", "SwingUnloaded", "CYCLE TIME", "WAIT DT","REPOSISI", "REPAIR FRONT"};
	private Object[][] data= {};
	private int kolom=0;
	private int baris=0;
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
			jPanelTopLayout.rowWeights = new double[] {0.0, 0.1, 0.1};
			jPanelTopLayout.rowHeights = new int[] {48, 20, 7};
			jPanelTopLayout.columnWeights = new double[] {0.0, 0.1};
			jPanelTopLayout.columnWidths = new int[] {424, 7};
			jPanelTop.setLayout(jPanelTopLayout);
			{
				timeWindow = new JLabel(stopWatch.toString());
				jPanelTop.add(timeWindow, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				timeWindow.setFont(new java.awt.Font("Calibri",1,72)); 
				timeWindow.setForeground(new java.awt.Color(255,128,0));
				timeWindow.setPreferredSize(new java.awt.Dimension(300, 150));
			}
			{
				jPanelControl = new JPanel();
				GridBagLayout jPanelControlLayout = new GridBagLayout();
				jPanelControlLayout.columnWidths = new int[] {172, 7};
				jPanelControlLayout.rowHeights = new int[] {7, 7, 7, 7};
				jPanelControlLayout.columnWeights = new double[] {0.0, 0.1};
				jPanelControlLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanelTop.add(jPanelControl, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanelControl.setLayout(jPanelControlLayout);
				{
					stopButton = new JButton("Stop");
					jPanelControl.add(stopButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					stopButton.setPreferredSize(new java.awt.Dimension(120, 30));
					stopButton.setSize(200, 30);
					stopButton.addActionListener(listener);
				}
				{
					startButton = new JButton("Start");
					jPanelControl.add(startButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					startButton.setPreferredSize(new java.awt.Dimension(120, 30));
					startButton.addActionListener(listener);
				}
				{
					resetButton = new JButton("Reset");
					jPanelControl.add(resetButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					resetButton.setPreferredSize(new java.awt.Dimension(120, 30));
					resetButton.setSize(100, 30);
					resetButton.addActionListener(listener);
				}
				{
					ledLabel = new JLabel();
					jPanelControl.add(ledLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					ledLabel.setIcon(ledOff);
					ledLabel.setPreferredSize(new Dimension(32,32));
				}
				{
					splitButton = new JButton();
					jPanelControl.add(splitButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					splitButton.setText("SPLIT");
					splitButton.setPreferredSize(new java.awt.Dimension(120, 30));
					splitButton.addActionListener(listener);

				}
				{
					waitDSButton = new JButton();
					jPanelControl.add(waitDSButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					waitDSButton.setText("WAIT DS");
					waitDSButton.setPreferredSize(new java.awt.Dimension(120, 30));
				}
				{
					reposisiButton = new JButton();
					jPanelControl.add(reposisiButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					reposisiButton.setText("REPOSISI");
					reposisiButton.setPreferredSize(new java.awt.Dimension(120, 30));
				}
				{
					repairButton = new JButton();
					jPanelControl.add(repairButton, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					repairButton.setText("REPAIR FRONT");
					repairButton.setPreferredSize(new java.awt.Dimension(120, 30));
				}
			}
			{
				jPanelID = new JPanel();
				GridBagLayout jPanelIDLayout = new GridBagLayout();
				jPanelTop.add(jPanelID, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanelIDLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0};
				jPanelIDLayout.rowHeights = new int[] {30, 31, 28, 29};
				jPanelIDLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
				jPanelIDLayout.columnWidths = new int[] {7, 109, 7};
				jPanelID.setLayout(jPanelIDLayout);
				{
					jLabelNama = new JLabel();
					jPanelID.add(jLabelNama, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelNama.setText("NAMA :");
				}
				{
					jLabelNRP = new JLabel();
					jPanelID.add(jLabelNRP, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelNRP.setText("NRP :");
				}
				{
					jLabelKodeUnit = new JLabel();
					jPanelID.add(jLabelKodeUnit, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelKodeUnit.setText("KODE UNIT :");
				}
				{
					jLabelSite = new JLabel();
					jPanelID.add(jLabelSite, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelSite.setText("SITE :");
				}
				{
					jTextFieldName = new JTextField();
					jPanelID.add(jTextFieldName, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldNRP = new JTextField();
					jPanelID.add(jTextFieldNRP, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldKodeUnit = new JTextField();
					jPanelID.add(jTextFieldKodeUnit, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldSite = new JTextField();
					jPanelID.add(jTextFieldSite, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
			}
			{
				
			}
			
		}
		{
			jPanelTable = new JPanel();
			getContentPane().add(jPanelTable, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		{
			jScrollPane1 = new JScrollPane();
			getContentPane().add(jScrollPane1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			{
				TableModel jTableMainModel = new DefaultTableModel(data, judul);
				jTableMain = new JTable();
				
				
				jScrollPane1.setViewportView(jTableMain);
				jTableMain.setModel(jTableMainModel);
				//					jTableMain.getColumnModel().getColumn(0).setMaxWidth(40);
				//					jTableMain.getColumnModel().getColumn(1).setMaxWidth(100);
				//					jTableMain.getColumnModel().getColumn(2).setMaxWidth(100);
				//					jTableMain.getColumnModel().getColumn(3).setMaxWidth(100);
				//					jTableMain.getColumnModel().getColumn(4).setMaxWidth(100);
				//					jTableMain.getColumnModel().getColumn(5).setMaxWidth(100);
				//					jTableMain.getColumnModel().getColumn(6).setMaxWidth(100);
				//					jTableMain.getColumnModel().getColumn(7).setMaxWidth(100);
				//					jTableMain.getColumnModel().getColumn(8).setMaxWidth(100);
				
				
			}
		}
	}
	
//	private TableColumnModel setColumnTableSize(TableColumnModel columnmodel){
//		columnmodel.getColumn(0).setPreferredWidth(5);
//		columnmodel.getColumn(1).setPreferredWidth(5);
//		columnmodel.getColumn(2).setPreferredWidth(5);
//		columnmodel.getColumn(3).setPreferredWidth(5);
//		columnmodel.getColumn(4).setPreferredWidth(5);
//		columnmodel.getColumn(5).setPreferredWidth(5);
//		columnmodel.getColumn(6).setPreferredWidth(5);
//		columnmodel.getColumn(7).setPreferredWidth(5);
//		columnmodel.getColumn(8).setPreferredWidth(5);
//
//		
//		return columnmodel;
//	}
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
			this.setSize(981, 634);
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
		int baris=0;
		int kolom=0;
				
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
			if(event.getSource() == splitButton){
				updateTable(stopWatch.toString());
				//updateTable(stopWatch.toString(),baris, kolom );
			}
			timeWindow.setText(stopWatch.toString());
		}
	}
	
	private void updateTable(String value){
		//jumlah array 1
		Object [][] temp = new Object[baris+1][6];
		
		//inisialisasi
		for(int brs=0;brs<data.length;brs++)

		{
			for(int klm=0;klm<6;klm++)
			{
				temp[brs][klm]=data[brs][klm];
			}
		}		
		if(kolom==0){
			temp[baris][kolom]=baris+1;
			kolom++;
		}
		//array ke satu=0
		temp[baris][kolom]=value;

		data=temp;
		jTableMain.setModel(new DefaultTableModel(data, judul));
		
		if(kolom<5){
			kolom++;
		}else{
			kolom=0;
			baris++;
		}
	}
}
