package com.deskbtn.controller;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;

import com.deskbtn.main.App;
import com.deskbtn.model.BtnPropperties;
import com.deskbtn.model.RoundButton;

public class BtnPropSerializing {

	private ArrayList<BtnPropperties> list;

	private static BtnPropSerializing SAVES;

	private BtnPropSerializing() {
		list = new ArrayList<BtnPropperties>();
	}

	static {
		setSAVES(new BtnPropSerializing());
	}

	public void addSave(BtnPropperties btnPropperties) throws IOException {
		list.add(btnPropperties);
		Serializer.setBytesIntoFile(Serializer.convertToBytes(list), App.homePath + "/buttonsSave.txt");
	}

	public void delSave(BtnPropperties btnPropperties) throws IOException {
		list.remove(btnPropperties);
		Serializer.setBytesIntoFile(Serializer.convertToBytes(list), App.homePath + "/buttonsSave.txt");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<BtnPropperties> getSave() throws ClassNotFoundException, IOException {
		return ((ArrayList<BtnPropperties>) Serializer
				.convertFromBytes(Serializer.getBytesFromFile(App.homePath + "/buttonsSave.txt")));

	}

	public static BtnPropSerializing getSAVES() {
		return SAVES;
	}

	public static void setSAVES(BtnPropSerializing SAVES) {
		BtnPropSerializing.SAVES = SAVES;
	}

	public void saveButtons() {
		Serializer.clearFile(App.homePath + "/buttonsSave.txt");
		list.clear();

		Component[] com = App.mainFrame.getContentPane().getComponents();
		for (Component tmp : com) {
			list.add(((RoundButton) tmp).getBtnPropperties());
		}
		try {
			Serializer.setBytesIntoFile(Serializer.convertToBytes(list), App.homePath + "/buttonsSave.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
