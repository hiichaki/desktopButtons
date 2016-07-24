package com.deskbtn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.deskbtn.main.App;
import com.deskbtn.model.FramePropperties;

public class FramePropSerializing {

	private Map<String, FramePropperties> map;
	
	private static FramePropSerializing SAVES;
	
	private FramePropSerializing() {
		map = new HashMap<String, FramePropperties>();
	}
	
	static {
		setSAVES(new FramePropSerializing());
	}
	
	public static void setSAVES(FramePropSerializing SAVES) {
		FramePropSerializing.SAVES = SAVES;
	}
	
	public static FramePropSerializing getSAVES() {
		return SAVES;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, FramePropperties> getSaves() throws ClassNotFoundException, IOException {
		return  (HashMap<String, FramePropperties>) Serializer.convertFromBytes(Serializer.getBytesFromFile(App.homePath + "/frameSave.txt"));
	}
	
	public void addSave(FramePropperties framePropperties, String key) throws IOException {
		map.put(key, framePropperties);
		Serializer.setBytesIntoFile(Serializer.convertToBytes(map), App.homePath + "/frameSave.txt");
	}
	
	public void delSave(String key) throws IOException {
		map.remove(key);
		Serializer.setBytesIntoFile(Serializer.convertToBytes(map), App.homePath + "/frameSave.txt");
	}
	
}
