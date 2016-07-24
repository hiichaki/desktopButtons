package com.deskbtn.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;

import com.deskbtn.controller.AddingSettings;
import com.deskbtn.controller.BtnPropSerializing;
import com.deskbtn.controller.FramePropSerializing;
import com.deskbtn.controller.Positioning;
import com.deskbtn.frame.MainFrame;
import com.deskbtn.model.FramePropperties;
import com.deskbtn.model.MyTrayIcon;

public class App {

	/**
	 * !!Pop-up 
	 * !!show/open 
	 * !!fileDialog 
	 * !!saves 
	 * !!settings 
	 * settings interface 
	 * !!color
	 * size 
	 * !!form 
	 * !!position 
	 * labels 
	 * !!remove/add 
	 * drag and drop 
	 * !!positioning open
	 * dialogs count in raw
	 * frames prop save
	 */

	// TODO: use created id for buttons

	public static BtnPropSerializing btnSAVES;

	public static FramePropSerializing frameSAVES;

	public static MainFrame mainFrame;

	public static String homePath = System.getProperty("user.home") + "/DeskBtnsSave";

	public static int windowWidth = 150;

	public static String iconPath = "/com/deskbtn/model/images/icon32.png";

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenWidth = (int) screenSize.getWidth();
	public static int screenHeight = (int) screenSize.getHeight();

	public static boolean isPathExists(String file) {
		return new File(homePath + file).exists();

	}

	public static void setIcon(JDialog dialog) {
		try {
			dialog.setIconImage(ImageIO.read(dialog.getClass().getResourceAsStream(App.iconPath)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void createDir() {
		File theDir = new File(homePath);

		if (!theDir.exists()) {
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		    }        
		    if(result) {    
//****************************************************************
		        System.out.println("DIR created (App)");  
		    }
		}
	}
	
	public static void initSAVES() {
		btnSAVES = BtnPropSerializing.getSAVES();
		frameSAVES = FramePropSerializing.getSAVES();
//****************************************************************
				System.out.println("saves inited (App)");
	}
	
	public static void main(String[] args) {
		
		createDir();
		initSAVES();

		try {
			FramePropperties framePropperties = frameSAVES.getSaves().get("MainFrame");
			mainFrame = new MainFrame(framePropperties); 
//			AddingSettings.trigger();
//****************************************************************
			System.out.println("get frame position from save (App)");
		} catch (ClassNotFoundException | IOException e) {
			mainFrame = new MainFrame();
//****************************************************************
			System.out.println("set default frame position (App)");
		}

		new Positioning().loadPosition(mainFrame.getFramePropperties().getMainFramePosition());

		new MyTrayIcon().initTrayIcon();
		AddingSettings.trigger();

	}

}
