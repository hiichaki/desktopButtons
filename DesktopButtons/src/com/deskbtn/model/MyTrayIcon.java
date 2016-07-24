package com.deskbtn.model;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.deskbtn.frame.MoveFrame;
import com.deskbtn.main.App;

public class MyTrayIcon {

	public void initTrayIcon() {
		if (!SystemTray.isSupported()) {
			JOptionPane.showMessageDialog(null, "!SystemTray.isSupported()");
			return;
		}

		PopupMenu trayMenu = new PopupMenu();

		// Menu submenu = new Menu("submenu");
		// submenu.add("qwe");
		// submenu.add("asd");
		// trayMenu.add(submenu);

		MenuItem moveItem = new MenuItem("Move");
		moveItem.addActionListener(e -> {
			new MoveFrame().setVisible(true);
			;
		});
		trayMenu.add(moveItem);

		MenuItem settingsItem = new MenuItem("Add");
		settingsItem.addActionListener(e -> {
			App.addingFrame.setVisible(true);
		});
		trayMenu.add(settingsItem);

		MenuItem exitItem = new MenuItem("Exit");
		exitItem.addActionListener(e -> {
			System.exit(0);
		});
		trayMenu.add(exitItem);

		TrayIcon trayIcon = new TrayIcon(getImage(), "some tooltip", trayMenu);
		trayIcon.setImageAutoSize(true);

		SystemTray tray = SystemTray.getSystemTray();
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (App.mainFrame.isVisible()) {
						App.mainFrame.setVisible(false);
					} else {
						App.mainFrame.setVisible(true);
					}
				}
			}
		});

		trayIcon.displayMessage("title", "Application started!", TrayIcon.MessageType.INFO);

	}

	public BufferedImage getImage() {

		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(App.iconPath));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return image;

	}

}
