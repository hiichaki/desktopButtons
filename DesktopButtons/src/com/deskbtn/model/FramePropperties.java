package com.deskbtn.model;

import java.io.Serializable;

public class FramePropperties implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770307112617698004L;
	
	private int mainFramePosition;
	
	private int width;

	public FramePropperties() {
	}

	public int getMainFramePosition() {
		return mainFramePosition;
	}

	public void setMainFramePosition(int mainFramePosition) {
		this.mainFramePosition = mainFramePosition;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int inRaw) {
		this.width = inRaw;
	}
	
	
	
	

}
