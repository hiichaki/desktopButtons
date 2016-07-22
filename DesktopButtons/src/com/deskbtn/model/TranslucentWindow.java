package com.deskbtn.model;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.UIManager;

import com.deskbtn.main.App;

public class TranslucentWindow extends JFrame {

	// private JFrame this;

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

				// this = new JFrame();
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

				setTrayIcon();
	
	}

	public void addButton(JButton btn) {
		this.add(btn);
		this.repaint();
		this.revalidate();
	}

	private void setTrayIcon() {
		if (!SystemTray.isSupported()) {
			return;
		}

		PopupMenu trayMenu = new PopupMenu();

		MenuItem minimizeItem = new MenuItem("Minimize");
		minimizeItem.addActionListener(e -> {
			this.setState(Frame.ICONIFIED);
		});
		trayMenu.add(minimizeItem);

		MenuItem normalizeItem = new MenuItem("Normalize");
		minimizeItem.addActionListener(e -> {
			this.setState(Frame.NORMAL);
		});
		trayMenu.add(normalizeItem);

		MenuItem exitItem = new MenuItem("Exit");
		exitItem.addActionListener(e -> {
			System.exit(0);
		});
		trayMenu.add(exitItem);

		Image icon = null;
		try {
			icon = ImageIO.read(new File("E:/1/icon32.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		TrayIcon trayIcon = new TrayIcon(icon, "some tooltip", trayMenu);
		trayIcon.setImageAutoSize(true);

		SystemTray tray = SystemTray.getSystemTray();
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		trayIcon.displayMessage("title", "Application started!", TrayIcon.MessageType.INFO);
	}
}