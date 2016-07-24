package com.deskbtn.controller;

import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.deskbtn.main.App;
import com.deskbtn.model.BtnPropperties;
import com.deskbtn.model.RoundButton;

public class SavesSerializing {

	private ArrayList<BtnPropperties> list;

	private static SavesSerializing SAVES;

	private SavesSerializing() {
		list = new ArrayList<BtnPropperties>();
	}

	static {
		setSAVES(new SavesSerializing());
	}

	public void addSave(BtnPropperties btnPropperties) throws IOException {
		list.add(btnPropperties);
		setBytesIntoFile(convertToBytes(list));
	}

	public void delSave(BtnPropperties btnPropperties) throws IOException {
		list.remove(btnPropperties);
		setBytesIntoFile(convertToBytes(list));
	}

	@SuppressWarnings("unchecked")
	public ArrayList<BtnPropperties> getSave() throws ClassNotFoundException, IOException {
		return ((ArrayList<BtnPropperties>) convertFromBytes(getBytesFromFile()));

	}

	public byte[] getBytesFromFile() throws IOException {
		Path path = Paths.get(App.pathString);
		byte[] data = Files.readAllBytes(path);
		return data;

	}

	public void setBytesIntoFile(byte[] byteArray) throws IOException {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(App.pathString);
			fos.write(byteArray);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Object convertFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes); ObjectInput in = new ObjectInputStream(bis)) {
			return in.readObject();
		}
	}

	private byte[] convertToBytes(Object object) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
			out.writeObject(object);
			return bos.toByteArray();
		}
	}

	public static SavesSerializing getSAVES() {
		return SAVES;
	}

	public static void setSAVES(SavesSerializing SAVES) {
		SavesSerializing.SAVES = SAVES;
	}

	public void saveButtons() {
		clearFile();
		list.clear();

		Component[] com = App.mainFrame.getContentPane().getComponents();
		for (Component tmp : com) {
			list.add(((RoundButton) tmp).getBtnPropperties());
		}
		try {
			setBytesIntoFile(convertToBytes(list));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void clearFile() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(App.pathString));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		writer.print("");
		writer.close();
	}

}
