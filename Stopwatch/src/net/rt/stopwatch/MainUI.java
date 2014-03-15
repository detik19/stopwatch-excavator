package net.rt.stopwatch;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import net.rt.stopwatch.model.StopWatch;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

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
public class MainUI extends javax.swing.JFrame {
	
	{
		//Set Look & Feel
		try {
			UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton splitButton;
	private JButton jButtonSave;
	private JLabel jLabelIMG;
	private JLabel jLabel1;
	private JPanel jPanelTitle;
	private JTextField jTextFieldSite;
	private JTextField jTextFieldKU;
	private JTextField jTextFieldNRP;
	private JTextField jTextFieldNama;
	private JLabel jLabelSite;
	private JLabel jLabelKodeUnit;
	private JLabel jLabelNRP;
	private JLabel jLabelNAMA;
	private JPanel jPanelOP;
	private JPanel jPanelBottom;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane1;
	private JTable jTableData2;
	private JTable jTableData1;
	private JPanel jPanelTable;
	private JButton repairFrontButton;
	private JButton reposisiButton;
	private JButton waitDTButton;
	private JButton jButtonXLS;
	private Timer timer;
	private StopWatch stopWatch;
	
	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	private JLabel timeWindow;
	private JPanel jPanelCtl;
	private JPanel jPanelID;
	
	private String[] judul= {"No","Digging", "Swing Loaded", "Dumping", "SwingUnloaded", "CYCLE TIME"};
	private String[] judul2= {"WAIT DT","REPOSISI", "REPAIR FRONT"};
	//, "WAIT DT","REPOSISI", "REPAIR FRONT"};
	private Object[][] data= {};
	private Object[][] data2= new Object[1][3];

	private int kolom=0;
	private int baris=0;
	//private int kolom2=0;
	//private int baris2=0;
	
	private int waitCount=0;
	private int reposisiCount=0;
	private int frontCount=0;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainUI inst = new MainUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.0};
			thisLayout.rowHeights = new int[] {90, 229, 203, 7, 7};
			thisLayout.columnWeights = new double[] {0.1};
			thisLayout.columnWidths = new int[] {7};
			getContentPane().setLayout(thisLayout);
			initStopWatch();
			pack();
			this.setSize(806, 705);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	

	public void initStopWatch() {
		
		
		stopWatch = new StopWatch();
		timer = new Timer(3, new TimerListener());

		
		
		ButtonListener listener = new ButtonListener();

		{
			jPanelID = new JPanel();
			GridBagLayout jPanelIDLayout = new GridBagLayout();
			getContentPane().add(jPanelID, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelIDLayout.rowWeights = new double[] {0.0, 0.0, 0.0};
			jPanelIDLayout.rowHeights = new int[] {137, 7, 128};
			jPanelIDLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
			jPanelIDLayout.columnWidths = new int[] {7, 399, 7};
			jPanelID.setLayout(jPanelIDLayout);
			{
				timeWindow = new JLabel();
				jPanelID.add(timeWindow, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				timeWindow.setText(stopWatch.toString());
				timeWindow.setForeground(Color.ORANGE);
				timeWindow.setFont(new java.awt.Font("Calibri",1,62));
				timeWindow.setPreferredSize(new java.awt.Dimension(229,97));
			}
			{
				jPanelCtl = new JPanel();
				GridBagLayout jPanelCtlLayout = new GridBagLayout();
				jPanelID.add(jPanelCtl, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanelCtlLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanelCtlLayout.rowHeights = new int[] {7, 7, 7, 7};
				jPanelCtlLayout.columnWeights = new double[] {0.0, 0.1};
				jPanelCtlLayout.columnWidths = new int[] {211, 7};
				jPanelCtl.setLayout(jPanelCtlLayout);
				{
					stopButton = new JButton("Stop");
					jPanelCtl.add(stopButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					stopButton.setPreferredSize(new java.awt.Dimension(120, 30));
					stopButton.addActionListener(listener);
				}
				{
					startButton = new JButton("Start");
					jPanelCtl.add(startButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					startButton.setPreferredSize(new java.awt.Dimension(120, 30));
					startButton.addActionListener(listener);
					
				}
				{
					resetButton = new JButton("Reset");
					jPanelCtl.add(resetButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					resetButton.setPreferredSize(new java.awt.Dimension(120, 30));
					resetButton.addActionListener(listener);
				}
				{
					splitButton = new JButton();
					jPanelCtl.add(splitButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					splitButton.setText("Split");
					splitButton.setPreferredSize(new java.awt.Dimension(120, 30));
				}
				{
					waitDTButton = new JButton();
					jPanelCtl.add(waitDTButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					waitDTButton.setText("WAIT DT");
					waitDTButton.setPreferredSize(new java.awt.Dimension(120, 30));
				}
				{
					reposisiButton = new JButton();
					jPanelCtl.add(reposisiButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					reposisiButton.setText("REPOSISI");
					reposisiButton.setPreferredSize(new java.awt.Dimension(120, 30));
				}
				{
					repairFrontButton = new JButton();
					jPanelCtl.add(repairFrontButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					repairFrontButton.setText("REPAIR FRONT");
					repairFrontButton.setPreferredSize(new java.awt.Dimension(120, 30));
				}
			}
			{
				jPanelOP = new JPanel();
				jPanelID.add(jPanelOP, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				GridBagLayout jPanelOPLayout = new GridBagLayout();
				jPanelOPLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0};
				jPanelOPLayout.rowHeights = new int[] {32, 30, 23, 37};
				jPanelOPLayout.columnWeights = new double[] {0.0, 0.1};
				jPanelOPLayout.columnWidths = new int[] {118, 7};
				jPanelOP.setLayout(jPanelOPLayout);
				{
					jLabelNAMA = new JLabel();
					jPanelOP.add(jLabelNAMA, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelNAMA.setText("NAMA :");
				}
				{
					jLabelNRP = new JLabel();
					jPanelOP.add(jLabelNRP, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelNRP.setText("NRP");
				}
				{
					jLabelKodeUnit = new JLabel();
					jPanelOP.add(jLabelKodeUnit, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelKodeUnit.setText("Kode Unit");
				}
				{
					jLabelSite = new JLabel();
					jPanelOP.add(jLabelSite, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelSite.setText("SITE :");
				}
				{
					jTextFieldNama = new JTextField();
					jPanelOP.add(jTextFieldNama, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldNRP = new JTextField();
					jPanelOP.add(jTextFieldNRP, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldKU = new JTextField();
					jPanelOP.add(jTextFieldKU, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldSite = new JTextField();
					jPanelOP.add(jTextFieldSite, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
			}
		}
		{
			jPanelTable = new JPanel();
			GridBagLayout jPanelTableLayout = new GridBagLayout();
			getContentPane().add(jPanelTable, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelTableLayout.rowWeights = new double[] {0.1};
			jPanelTableLayout.rowHeights = new int[] {7};
			jPanelTableLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.0};
			jPanelTableLayout.columnWidths = new int[] {7, 522, 7, 7, 7};
			jPanelTable.setLayout(jPanelTableLayout);
			jPanelTable.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			{
				jScrollPane1 = new JScrollPane();
				jPanelTable.add(jScrollPane1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					TableModel jTableData1Model = 
							new DefaultTableModel(
									data,
									judul);
					jTableData1 = new JTable();
					jScrollPane1.setViewportView(jTableData1);
					jTableData1.setModel(jTableData1Model);
				}
			}
			{
				jScrollPane2 = new JScrollPane();
				jPanelTable.add(jScrollPane2, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					TableModel jTableData2Model = 
							new DefaultTableModel(
									data,
									judul2);
					jTableData2 = new JTable();
					jScrollPane2.setViewportView(jTableData2);
					jTableData2.setModel(jTableData2Model);
				}
			}
		}
		{
			jPanelBottom = new JPanel();
			GridBagLayout jPanelBottomLayout = new GridBagLayout();
			jPanelBottomLayout.rowWeights = new double[] {0.1};
			jPanelBottomLayout.rowHeights = new int[] {7};
			jPanelBottomLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanelBottomLayout.columnWidths = new int[] {7, 7, 7, 7};
			jPanelBottom.setLayout(jPanelBottomLayout);
			getContentPane().add(jPanelBottom, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			{
				jButtonSave = new JButton();
				jPanelBottom.add(jButtonSave, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButtonSave.setText("SAVE");
				jButtonSave.setPreferredSize(new java.awt.Dimension(120, 30));
			}
		}
		{
			jPanelTitle = new JPanel();
			getContentPane().add(jPanelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelTitle.setLayout(null);
			{
				jLabel1 = new JLabel();
				jPanelTitle.add(jLabel1);
				jLabel1.setText("PERHITUNGAN CYCLE TIME EXCAVATOR");
				jLabel1.setFont(new java.awt.Font("Segoe UI",1,20));
				jLabel1.setBounds(205, 26, 383, 27);
			}
			{
				jLabelIMG = new JLabel();
				jPanelTitle.add(jLabelIMG);
				jLabelIMG.setIcon(new ImageIcon(getClass().getClassLoader().getResource("net/rt/stopwatch/pama3.png")));
				jLabelIMG.setBounds(128, 12, 50, 52);
			}
		}
	}
	
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			stopWatch.add(3);
			timeWindow.setText(stopWatch.toString());
		}
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == startButton) {	
				timer.start();
			}

			if(event.getSource() == stopButton) {
				timer.stop();
			}

			if(event.getSource() == resetButton) {
				timer.stop();
				stopWatch.reset();
			}
			
			timeWindow.setText(stopWatch.toString());
		}

	
	}
}