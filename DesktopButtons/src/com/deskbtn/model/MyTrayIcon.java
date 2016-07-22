package com.deskbtn.model;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.deskbtn.main.App;

public class MyTrayIcon {
	
	public static void initTrayIcon() {
		if (!SystemTray.isSupported()) {
			return;
		}

		PopupMenu trayMenu = new PopupMenu();

		MenuItem minimizeItem = new MenuItem("Minimize");
		minimizeItem.addActionListener(e -> {
			App.window.setState(Frame.ICONIFIED);
		});
		trayMenu.add(minimizeItem);

		MenuItem normalizeItem = new MenuItem("Normalize");
		minimizeItem.addActionListener(e -> {
			App.window.setState(Frame.NORMAL);
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
