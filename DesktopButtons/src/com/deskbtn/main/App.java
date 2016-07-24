package com.deskbtn.main;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;

import com.deskbtn.controller.AddingSettings;
import com.deskbtn.controller.Positioning;
import com.deskbtn.controller.SavesSerializing;
import com.deskbtn.frame.AddingFrame;
import com.deskbtn.frame.MainFrame;
import com.deskbtn.model.MyTrayIcon;

public class App {
	
	/**
	 * !Pop-up 
	 * !show/open
	 * !fileDialog
	 * !saves
	 * !settings
	 * settings interface
	 * color
	 * size
	 * !form
	 * !position
	 * labels
	 * !remove/add
	 * drag and drop
	 */
		
	
//	TODO: use created id for buttons  
	
	public static AddingFrame addingFrame;

	public static SavesSerializing SAVES;
	
	public static MainFrame mainFrame;
	
	public static String pathString = System.getProperty( "user.home" ) + "/buttonsSave.txt";
	
	public static int windowWidth = 150;
	
	public static String iconPath = "/com/deskbtn/model/images/icon32.png";
	
	private  static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenWidth = (int) screenSize.getWidth();
	public static int screenHeight = (int) screenSize.getHeight();
	
	public static boolean isPathExists() {
		return new File (pathString).exists();
		
	}
	
	public static void setIcon(JDialog dialog) {
		try {
			dialog.setIconImage(ImageIO.read(dialog.getClass().getResourceAsStream(App.iconPath)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		addingFrame = new AddingFrame();
//		frameSettings.setVisible(true);
		SAVES = SavesSerializing.getSAVES();
		mainFrame = new MainFrame();
		new Positioning().setRight();
		new MyTrayIcon().initTrayIcon();
		AddingSettings.trigger();
		
	}
	
}
