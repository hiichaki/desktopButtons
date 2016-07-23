package com.deskbtn.model;

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
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());

	}

	public void setLeft() {
		int x = 0;
		int y = height / 3;
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());
	}

	public void setTop() {
		int x = (int) ((width - App.windowWidth) / 2);
		int y = 0;
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());

	}

	public void setBottom() {
		int x = (int) ((width - App.windowWidth) / 2);
		int y = height - App.window.getHeight();
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());
	}

	public void setCenter() {
		int x = (int) ((width - App.windowWidth) / 2);
		int y = (int) ((height - App.window.getHeight()) / 2);
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());
	}

	public void setTopRight() {
		int x = width - App.windowWidth;
		int y = 0;
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());
	}

	public void setTopLeft() {
		int x = 0;
		int y = 0;
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());
	}
	
	public void setBottomRight() {
		int x = width - App.windowWidth;
		int y = height - App.window.getHeight();
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());
	}
	
	public void setBottomLeft() {
		int x = 0;
		int y = height - App.window.getHeight();
		App.window.setBounds(x, y, App.windowWidth, App.window.getHeight());
	}

}
