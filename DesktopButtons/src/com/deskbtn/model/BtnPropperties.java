package com.deskbtn.model;

import java.io.Serializable;

public class BtnPropperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5313579596579966661L;

	private String path;

	public BtnPropperties() {

	}

	public BtnPropperties(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
