package com.deskbtn.model;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SerializeSaves{
	
	private ArrayList<String> list;
	
	private static SerializeSaves SAVES;
	
	private String pathString = "E://1.txt";
	
	private  SerializeSaves() {
		list = new ArrayList<String>();
	}
	
	static {
		setSAVES(new SerializeSaves());
	}
	
	public void addSave(String file) throws IOException {
		list.add(file);
		setBytesIntoFile(convertToBytes(list));
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getSave() throws ClassNotFoundException, IOException {
		return ((ArrayList<String>) convertFromBytes(getBytesFromFile()));
	}
	
	public byte[] getBytesFromFile() throws IOException {
		Path path = Paths.get(pathString);
		byte[] data = Files.readAllBytes(path);
		return data;
		
	}
	
	public void setBytesIntoFile(byte[] byteArray) throws IOException {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(pathString);
			fos.write(byteArray);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Object convertFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
	    try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
	        ObjectInput in = new ObjectInputStream(bis)) {
	        return in.readObject();
	    } 
	}
	
	private byte[] convertToBytes(Object object) throws IOException {
	    try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        ObjectOutput out = new ObjectOutputStream(bos)) {
	        out.writeObject(object);
	        return bos.toByteArray();
	    } 
	}

	public static SerializeSaves getSAVES() {
		return SAVES;
	}

	public static void setSAVES(SerializeSaves sAVES) {
		SAVES = sAVES;
	}
	
}
