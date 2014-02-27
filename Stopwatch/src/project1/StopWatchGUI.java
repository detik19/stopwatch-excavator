package project1;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StopWatchGUI {
	
	public static void main (String[] args)
	{  
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Stop Watch");
		
		JMenuBar menuBar;
		JMenu fileMenu, helpMenu;
		JMenuItem saveMenuItem, loadMenuItem, aboutMenuItem;
		
		menuBar = new JMenuBar();
	    fileMenu = new JMenu("File");
	    saveMenuItem = new JMenuItem("Save");
	    loadMenuItem = new JMenuItem("Load");
	    helpMenu = new JMenu("Help");
	    aboutMenuItem = new JMenuItem("About");
	    
	    menuBar.add(fileMenu);
	    menuBar.add(helpMenu);
	    fileMenu.add(saveMenuItem);
	    fileMenu.add(loadMenuItem);
	    helpMenu.add(aboutMenuItem); 

		JFrame frame = new JFrame ("Stop Watch");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(menuBar);

		frame.getContentPane().add(new StopWatchGUIPanel(saveMenuItem, loadMenuItem, aboutMenuItem));

		frame.pack();
		frame.setVisible(true);
	}
}