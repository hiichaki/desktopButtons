package com.deskbtn.model;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.deskbtn.main.App;

/*
 * frame with buttons
 */
public class TranslucentWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531962971491318167L;

	public TranslucentWindow() {
	
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
					ex.getStackTrace();
				}

				try {
					if (!App.SAVES.getSave().equals(null)) {

						for (Iterator<String> iter = App.SAVES.getSave().iterator(); iter.hasNext();) {
							App.SAVES.addSave(iter.next());
						}

					}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}

				this.setUndecorated(true);
				// frame.setAlwaysOnTop(true);
				this.setBackground(new Color(0, 0, 0, 0));
				TranslucentPane pane = new TranslucentPane();
				this.setContentPane(pane);
				this.setSize(new Dimension(200, 400));
				pane.setLayout(new FlowLayout());

				// folder open
				// Desktop.getDesktop().open(new File("C:\\"));

				// exe open
				// Runtime.getRuntime().exec("D:\\Transcend\\MortalKombatTrilogy\\MKTRILW.EXE",
				// null, new File("D:\\Transcend\\MortalKombatTrilogy"));

				// txt open in notepad
				// Process p = Runtime.getRuntime().exec("notepad " +
				// ("c:\\1.txt"));

				// frame.pack();

				this.setLocationRelativeTo(null);
				this.setVisible(true);
	
	}

	public void addButton(JButton btn) {
		this.add(btn);
		this.repaint();
		this.revalidate();
	}
	
	public void clear() {
		this.getContentPane().removeAll();
		this.repaint();
		this.revalidate();
	}

}