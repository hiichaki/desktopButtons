package com.deskbtn.main;
import com.deskbtn.model.MyTrayIcon;
import com.deskbtn.model.SerializeSaves;
import com.deskbtn.model.TranslucentWindow;

public class App {
	
	/**
	 * Pop-up
	 * show/open
	 * fileDialog
	 * saves
	 * settings
	 * color
	 * size
	 * form
	 * position
	 * labels
	 * remove/add
	 * drag and drop
	 */
		
	
//	TODO: use created id for buttons  
	
	public static FrameSettings frameSettings;

	public static SerializeSaves SAVES;
	
	public static TranslucentWindow window;
	
	
	public static void main(String[] args) {
		frameSettings = new FrameSettings();
		frameSettings.setVisible(true);
		SAVES = SerializeSaves.getSAVES();
		window = new TranslucentWindow();
		MyTrayIcon.initTrayIcon();
		
	}
	
}
