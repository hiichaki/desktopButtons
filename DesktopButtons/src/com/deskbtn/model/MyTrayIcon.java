package com.deskbtn.model;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.deskbtn.main.App;

public class MyTrayIcon {

	private static String iconPath = "E:/1/icon32.png";

	public static void initTrayIcon() {
		if (!SystemTray.isSupported()) {
			return;
		}

		PopupMenu trayMenu = new PopupMenu();

		MenuItem settingsItem = new MenuItem("Settings");
		settingsItem.addActionListener(e -> {
			App.frameSettings.setVisible(true);
		});
		trayMenu.add(settingsItem);

		MenuItem exitItem = new MenuItem("Exit");
		exitItem.addActionListener(e -> {
			System.exit(0);
		});
		trayMenu.add(exitItem);

		Image icon = null;
		try {
			icon = ImageIO.read(new File(iconPath));
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

		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (App.window.isVisible()) {
					App.window.setVisible(false);
				} else {
					App.window.setVisible(true);
				}
			}
		});

		trayIcon.displayMessage("title", "Application started!", TrayIcon.MessageType.INFO);
		
	}

}
