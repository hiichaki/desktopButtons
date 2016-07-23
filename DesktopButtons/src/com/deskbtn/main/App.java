package com.deskbtn.main;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import com.deskbtn.frame.FrameSettings;
import com.deskbtn.frame.TranslucentWindow;
import com.deskbtn.model.MyTrayIcon;
import com.deskbtn.model.Positioning;
import com.deskbtn.model.SerializeSaves;

public class App {
	
	/**
	 * !Pop-up 
	 * !show/open
	 * !fileDialog
	 * !saves
	 * !settings
	 * color
	 * size
	 * form
	 * position
	 * labels
	 * !remove/add
	 * drag and drop
	 */
		
	
//	TODO: use created id for buttons  
	
	public static FrameSettings frameSettings;

	public static SerializeSaves SAVES;
	
	public static TranslucentWindow window;
	
	public static String pathString = System.getProperty( "user.home" ) + "/buttonsSave.txt";
	
	public static int windowWidth = 200;
	
	private  static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenWidth = (int) screenSize.getWidth();
	public static int screenHeight = (int) screenSize.getHeight();
	
	public static boolean isPathExists() {
		return new File (pathString).exists();
		
	}
	
	public static void main(String[] args) {
		frameSettings = new FrameSettings();
		frameSettings.setVisible(true);
		SAVES = SerializeSaves.getSAVES();
		window = new TranslucentWindow();
		new Positioning().setRight();
		new MyTrayIcon().initTrayIcon();
		frameSettings.trigger();
		
	}
	
}
