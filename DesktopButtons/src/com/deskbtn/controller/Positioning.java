package com.deskbtn.controller;

import com.deskbtn.main.App;

public class Positioning {

	private int width = App.screenWidth;
	private int height = App.screenHeight;

	// GraphicsDevice gd =
	// GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	// int width = gd.getDisplayMode().getWidth();
	// int height = gd.getDisplayMode().getHeight();

	public void setRight() {
		int x = width - App.windowWidth;
		int y = height / 3;
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());

	}

	public void setLeft() {
		int x = 0;
		int y = height / 3;
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
	}

	public void setTop() {
		int x = (int) ((width - App.windowWidth) / 2);
		int y = 0;
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());

	}

	public void setBottom() {
		int x = (int) ((width - App.windowWidth) / 2);
		int y = height - App.mainFrame.getHeight();
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
	}

	public void setCenter() {
		int x = (int) ((width - App.windowWidth) / 2);
		int y = (int) ((height - App.mainFrame.getHeight()) / 2);
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
	}

	public void setTopRight() {
		int x = width - App.windowWidth;
		int y = 0;
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
	}

	public void setTopLeft() {
		int x = 0;
		int y = 0;
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
	}

	public void setBottomRight() {
		int x = width - App.windowWidth;
		int y = height - App.mainFrame.getHeight();
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
	}

	public void setBottomLeft() {
		int x = 0;
		int y = height - App.mainFrame.getHeight();
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
	}

}
