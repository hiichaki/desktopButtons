package com.deskbtn.controller;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;

import com.deskbtn.frame.MainFrame;
import com.deskbtn.main.App;
import com.deskbtn.model.BtnPropperties;
import com.deskbtn.model.RoundButton;

public class AddingSettings {

	public static File getFile() {
		JFileChooser fileChooser = new JFileChooser();
		File file = null;
		// fileChooser.setCurrentDirectory(new
		// File("D://Transcend//MortalKombatTrilogy"));
		int ret = fileChooser.showDialog(null, "Open file");
		if (ret == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		}

		return file;
	}

	public static File getDirectory() {
		JFileChooser fileChooser = new JFileChooser();
		File file = null;
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		int ret = fileChooser.showDialog(null, "Open file");
		if (ret == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		}
		return file;
	}

	public static void createFileButton(File file) {
		RoundButton tmpButton = new RoundButton(file.getPath());
		tmpButton.addActionListener(event -> {
			try {

				String[] split = file.getPath().split("\\.");
				String extension = split[split.length - 1].toLowerCase();

				if (extension.equals("txt")) {
					Runtime.getRuntime().exec("notepad " + (file.getPath()));
				}

				if (extension.equals("exe")) {
					Runtime.getRuntime().exec(file.getAbsolutePath(), null, file.getParentFile());
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		save(tmpButton.getBtnPropperties());
		trigger();

	}

	public static void createDirectoryButton(File file) {
		RoundButton tmpButton = new RoundButton(file.getPath());
		tmpButton.addActionListener(event -> {
			try {
				Desktop.getDesktop().open(file);
			} catch (Exception ex) {
				ex.getStackTrace();
			}
		});

		save(tmpButton.getBtnPropperties());
		trigger();

	}

	private static void save(BtnPropperties btnPropperties) {
		try {
			App.btnSAVES.addSave(btnPropperties);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void load() {
		if (App.isPathExists("/buttonsSave.txt")) {
			App.mainFrame.clear();
			try {
				ArrayList<BtnPropperties> loadFiles = App.btnSAVES.getSave();
				Iterator<BtnPropperties> iter = loadFiles.iterator();
				while (iter.hasNext()) {
//****************************************************************
					System.out.println("load (AddingSettings)");
					// System.out.println(tmpFile.getName());
					RoundButton tmpRB = new RoundButton(iter.next());
					tmpRB.addActionListener(event -> {
						try {
							Desktop.getDesktop().open(new File(tmpRB.getBtnPropperties().getPath()));
						} catch (Exception ex) {
							ex.getStackTrace();
						}
					});
					App.mainFrame.addButton(tmpRB);

				}
				App.mainFrame.refresh();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void trigger() {
//****************************************************************
		System.out.println("trigger (AddingSettings)");
		App.mainFrame.clear();
		load();
		resize();
	}

	private static void resize() {
		double count = App.mainFrame.getContentPane().getComponents().length;
		double inRaw = App.windowWidth / 48.0;
		double raws = Math.ceil(count / inRaw);
		double height = raws * 50;
		if ((App.mainFrame.getY() + height) > App.screenHeight)
			App.mainFrame.setLocation(App.mainFrame.getX(), App.mainFrame.getY() - 50);
		App.mainFrame.setSize(new Dimension(App.windowWidth, (int) height));

	}
}
