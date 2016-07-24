package com.deskbtn.controller;

import java.io.IOException;

import com.deskbtn.main.App;

public class Positioning {

	private int width = App.screenWidth;
	private int height = App.screenHeight;
	private int x;
	private int y;
	// GraphicsDevice gd =
	// GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	// int width = gd.getDisplayMode().getWidth();
	// int height = gd.getDisplayMode().getHeight();

	public void setPosition(int mainFramePosition) {
		switch (mainFramePosition) {
		case 1:
			setBottomLeft();
			break;
		case 2:
			setBottom();
			break;
		case 3:
			setBottomRight();
			break;
		case 4:
			setLeft();
			break;
		case 5:
			setCenter();
			break;
		case 6:
			setRight();
			break;
		case 7:
			setTopLeft();
			break;
		case 8:
			setTop();
			break;
		case 9:
			setTopRight();
			break;
		}
	}

	public void setRight() {
		x = width - App.windowWidth;
		y = height / 3;
		App.mainFrame.getFramePropperties().setMainFramePosition(6);
		trigger();
	}

	public void setLeft() {
		x = 0;
		y = height / 3;
		App.mainFrame.getFramePropperties().setMainFramePosition(4);
		trigger();
	}

	public void setTop() {
		x = (int) ((width - App.windowWidth) / 2);
		y = 0;
		App.mainFrame.getFramePropperties().setMainFramePosition(8);
		trigger();

	}

	public void setBottom() {
		x = (int) ((width - App.windowWidth) / 2);
		y = height - App.mainFrame.getHeight();
		App.mainFrame.getFramePropperties().setMainFramePosition(2);
		trigger();
	}

	public void setCenter() {
		x = (int) ((width - App.windowWidth) / 2);
		y = (int) ((height - App.mainFrame.getHeight()) / 2);
		App.mainFrame.getFramePropperties().setMainFramePosition(5);
		trigger();
	}

	public void setTopRight() {
		x = width - App.windowWidth;
		y = 0;
		App.mainFrame.getFramePropperties().setMainFramePosition(9);
		trigger();
	}

	public void setTopLeft() {
		x = 0;
		y = 0;
		App.mainFrame.getFramePropperties().setMainFramePosition(7);
		trigger();
	}

	public void setBottomRight() {
		x = width - App.windowWidth;
		y = height - App.mainFrame.getHeight();
		App.mainFrame.getFramePropperties().setMainFramePosition(3);
		trigger();
	}

	public void setBottomLeft() {
		x = 0;
		y = height - App.mainFrame.getHeight();
		App.mainFrame.getFramePropperties().setMainFramePosition(1);
		trigger();
	}

	private void trigger() {
		App.mainFrame.setBounds(x, y, App.windowWidth, App.mainFrame.getHeight());
		try {
//			App.frameSAVES.delSave("MainFrame");
			App.frameSAVES.addSave(App.mainFrame.getFramePropperties(), "MainFrame");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
