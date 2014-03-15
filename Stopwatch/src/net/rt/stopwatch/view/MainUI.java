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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import net.rt.stopwatch.controller.ExcelHandler;
import net.rt.stopwatch.model.Operator;
import net.rt.stopwatch.model.SimulationResult;
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
public class MainUI extends javax.swing.JFrame {

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
	private JButton splitButton;
	private JButton repairButton;
	private JButton reposisiButton;
	private JButton waitDTButton;
	private JButton jButtonXLS;

	private Timer timer;

	
	private ImageIcon ledOn;
	private JTextField jTextFieldNama;
	private JLabel timeWindow;
	private JPanel jPanelTime;
	private JPanel jPanelControl;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;

	private JTable jTableMain;
	private JTable jTableAux;

	private JPanel jPanelTable;
	private JTextField jTextFieldSITE;
	private JTextField jTextFieldKU;
	private JTextField jTextFieldNRP;
	private JLabel jLabel1;
	private JPanel jPanelID;
	private JPanel jPanelTop;
	private JPanel jPanelButtom;

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
	private SimulationResult sim;

	private final int COL_NO=0;
	private final int COL_DIGGING=1;
	private final int COL_SWING_LOADED=2;
	private final int COL_DUMPING=3;
	private final int COL_SWING_UNLOADED=4;
	private final int COL_CYCLE_TIME=5;

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
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {76, 293, 238, 7, 7};
			thisLayout.columnWeights = new double[] {0.1};
			thisLayout.columnWidths = new int[] {7};
			getContentPane().setLayout(thisLayout);
			initStopWatch();

			pack();
			this.setSize(987, 720);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void initStopWatch(){
		stopWatch = new StopWatch();
		timer = new Timer(3, new TimerListener());
		//ledTimer = new Timer(500, new LedTimerListener());
		ledOn = new ImageIcon("ledOn32.png");
		ledOn = new ImageIcon("ledOn32.png");

		ButtonListener listener = new ButtonListener();

		this.setPreferredSize(new java.awt.Dimension(987, 720));

		{
			jPanelTop = new JPanel();
			GridBagLayout jPanelTopLayout = new GridBagLayout();
			getContentPane().add(jPanelTop, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelTopLayout.rowWeights = new double[] {0.0, 0.1};
			jPanelTopLayout.rowHeights = new int[] {142, 7};
			jPanelTopLayout.columnWeights = new double[] {0.0, 0.1};
			jPanelTopLayout.columnWidths = new int[] {439, 7};
			jPanelTop.setLayout(jPanelTopLayout);
			{
				jPanelID = new JPanel();
				GridBagLayout jPanelIDLayout = new GridBagLayout();
				jPanelTop.add(jPanelID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanelIDLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0};
				jPanelIDLayout.rowHeights = new int[] {32, 32, 35, 34};
				jPanelIDLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
				jPanelIDLayout.columnWidths = new int[] {7, 155, 7};
				jPanelID.setLayout(jPanelIDLayout);
				{
					jLabel1 = new JLabel();
					jPanelID.add(jLabel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel1.setText("NAMA :");
				}
				{
					jLabel2 = new JLabel();
					jPanelID.add(jLabel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel2.setText("NRP :");
				}
				{
					jLabel3 = new JLabel();
					jPanelID.add(jLabel3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel3.setText("KODE UNIT :");
				}
				{
					jLabel4 = new JLabel();
					jPanelID.add(jLabel4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel4.setText("SITE :");
				}
				{
					jTextFieldNama = new JTextField();
					jPanelID.add(jTextFieldNama, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldNRP = new JTextField();
					jPanelID.add(jTextFieldNRP, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldKU = new JTextField();
					jPanelID.add(jTextFieldKU, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldSITE = new JTextField();
					jPanelID.add(jTextFieldSITE, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
			}
			{
				jPanelControl = new JPanel();
				GridBagLayout jPanelControlLayout = new GridBagLayout();
				jPanelTop.add(jPanelControl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanelControlLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				jPanelControlLayout.rowHeights = new int[] {7, 7, 7, 20};
				jPanelControlLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
				jPanelControlLayout.columnWidths = new int[] {182, 178, 20};
				jPanelControl.setLayout(jPanelControlLayout);
				{
					startButton = new JButton("Start");
					jPanelControl.add(startButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					startButton.setPreferredSize(new java.awt.Dimension(120, 30));
					startButton.addActionListener(listener);
				}
				{
					stopButton = new JButton("Stop");
					jPanelControl.add(stopButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					stopButton.setPreferredSize(new java.awt.Dimension(120, 30));
					stopButton.addActionListener(listener);
				}
				{
					resetButton = new JButton("Reset");
					jPanelControl.add(resetButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					resetButton.setPreferredSize(new java.awt.Dimension(120, 30));
					resetButton.addActionListener(listener);
				}
				{
					splitButton = new JButton();
					jPanelControl.add(splitButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					splitButton.setText("Split");
					splitButton.setPreferredSize(new java.awt.Dimension(120, 30));
					splitButton.addActionListener(listener);

				}
				{
					waitDTButton = new JButton();
					jPanelControl.add(waitDTButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					waitDTButton.setText("WAIT DT");
					waitDTButton.setPreferredSize(new java.awt.Dimension(120, 30));
					waitDTButton.addActionListener(listener);

				}
				{
					reposisiButton = new JButton();
					jPanelControl.add(reposisiButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					reposisiButton.setText("REPOSISI");
					reposisiButton.setPreferredSize(new java.awt.Dimension(120, 30));
					reposisiButton.addActionListener(listener);

				}
				{
					repairButton = new JButton();
					jPanelControl.add(repairButton, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					repairButton.setText("REPAIR FRONT");
					repairButton.setPreferredSize(new java.awt.Dimension(120, 30));
					repairButton.addActionListener(listener);

				}
			}
			{
				jPanelTime = new JPanel();
				GridBagLayout jPanelTimeLayout = new GridBagLayout();
				jPanelTop.add(jPanelTime, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jPanelTimeLayout.rowWeights = new double[] {0.1};
				jPanelTimeLayout.rowHeights = new int[] {7};
				jPanelTimeLayout.columnWeights = new double[] {0.0, 0.1};
				jPanelTimeLayout.columnWidths = new int[] {154, 7};
				jPanelTime.setLayout(jPanelTimeLayout);
				{
					timeWindow = new JLabel();
					jPanelTime.add(timeWindow, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					timeWindow.setText(stopWatch.toString());
					timeWindow.setForeground(new java.awt.Color(255,128,0));
					timeWindow.setFont(new java.awt.Font("Calibri",1,48));
					timeWindow.setPreferredSize(new java.awt.Dimension(300,150));
				}
			}
		}
		{
			jPanelTable = new JPanel();
			GridBagLayout jPanelTableLayout = new GridBagLayout();
			getContentPane().add(jPanelTable, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelTableLayout.rowWeights = new double[] {0.1};
			jPanelTableLayout.rowHeights = new int[] {7};
			jPanelTableLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
			jPanelTableLayout.columnWidths = new int[] {554, 7, 20};
			jPanelTable.setLayout(jPanelTableLayout);
			{
				jScrollPane1 = new JScrollPane();
				jPanelTable.add(jScrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					TableModel jTableMainModel = 
							new DefaultTableModel(data, judul);
					jTableMain = new JTable();
					jScrollPane1.setViewportView(jTableMain);
					jTableMain.setModel(jTableMainModel);
				}
			}
			{
				jScrollPane2 = new JScrollPane();
				jPanelTable.add(jScrollPane2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					TableModel jTableAuxModel = 
							new DefaultTableModel(
									data2,
									judul2);
					jTableAux = new JTable();
					jScrollPane2.setViewportView(jTableAux);
					jTableAux.setModel(jTableAuxModel);
				}
			}
		}
		{
			jPanelButtom = new JPanel();
			GridBagLayout jPanelButtomLayout = new GridBagLayout();
			getContentPane().add(jPanelButtom, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanelButtomLayout.rowWeights = new double[] {0.1};
			jPanelButtomLayout.rowHeights = new int[] {7};
			jPanelButtomLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanelButtomLayout.columnWidths = new int[] {7, 7, 7, 7};
			jPanelButtom.setLayout(jPanelButtomLayout);
			{
				jButtonXLS = new JButton();
				jPanelButtom.add(jButtonXLS, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButtonXLS.setText("SAVE");
				jButtonXLS.setPreferredSize(new java.awt.Dimension(100, 30));
				jButtonXLS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonXLSActionPerformed(evt);
					}
				});
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
				sim=new SimulationResult();
				sim.setDate(new Date());
			}

			if(event.getSource() == stopButton) {
//				ledLabel.setIcon(ledOn);
				timer.stop();
			}

			if(event.getSource() == resetButton) {
				timer.stop();
				stopWatch.reset();
			}
			
			if(event.getSource() == splitButton){
				updateTable(stopWatch.toString());
			}
			
			if(event.getSource()== waitDTButton){
				updateAux(stopWatch.toString(),waitCount,0);
				waitCount++;
			}
			
			if(event.getSource()== reposisiButton){
				updateAux(stopWatch.toString(),reposisiCount,1);
				reposisiCount++;
			}
			
			if(event.getSource()==repairButton){
				updateAux(stopWatch.toString(),frontCount,2);
				frontCount++;
			}
			timeWindow.setText(stopWatch.toString());
		}
	}
	
	private void updateAux(String wait, int baris2, int kolom2){
		Object [][] temp =null;
		if(baris2>=data2.length){
			temp = new Object[data2.length+1][3];
		}
		else{
			temp = new Object[data2.length][3];
		}

		//inisialisasi
		for(int brs=0;brs<data2.length;brs++)
		{
			for(int klm=0;klm<=2;klm++)
			{
				temp[brs][klm]=data2[brs][klm];
			}
		}		
		
		temp[baris2][kolom2]=wait;
		data2=temp;
		jTableAux.setModel(new DefaultTableModel(data2, judul2));
		
		
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
	
	private void jButtonXLSActionPerformed(ActionEvent evt) {
		Thread t= new Thread()
		{
			public void run()
			{
				dataCollector();

			}
			
		};
		t.start();
	}
	
	private void dataCollector(){
//		
//		for(int i=0; i<data.length; i++)
//		{
//			data[i][COL_NO].toString();
//			data[i][COL_SWING_LOADED].toString();
//			data[i][COL_DUMPING].toString();
//			data[i][COL_SWING_UNLOADED].toString();
//			data[i][COL_CYCLE_TIME].toString(); 
//		
//		}
		Operator op=new Operator();
		op.setName(jTextFieldNama.getText());
		op.setNrp(jTextFieldNRP.getText());
		op.setKU(jTextFieldKU.getText());
		op.setSite(jTextFieldSITE.getText());
		sim.setOperator(op);
		sim.setData(data);
		sim.setData2(data2);
		
		ExcelHandler handler=new ExcelHandler();
		handler.printTask(sim);
		
	}
}
