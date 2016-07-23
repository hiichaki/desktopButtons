package com.deskbtn.frame;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.deskbtn.main.App;
import com.deskbtn.model.RoundButton;

/*
 * frame which creates buttons
 */
public class FrameSettings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField browseFileField;
	private JButton createFileButton;
	private File file;
	private JFileChooser fileChooser;
	private JTextField browseDirectoryField;

	public FrameSettings() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.getStackTrace();
		}

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton browseFileButton = new JButton("Browse");
		browseFileButton.addActionListener(e -> {
			file = null;
			fileChooser = new JFileChooser();
			// fileChooser.setCurrentDirectory(new
			// File("D://Transcend//MortalKombatTrilogy"));
			int ret = fileChooser.showDialog(null, "Open file");
			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				browseFileField.setText(file.getAbsolutePath());
			}

		});

		browseFileButton.setBounds(123, 91, 89, 23);
		contentPane.add(browseFileButton);

		browseFileField = new JTextField();
		browseFileField.setBounds(10, 60, 454, 20);
		contentPane.add(browseFileField);
		browseFileField.setColumns(10);
		browseFileField.setEnabled(false);

		createFileButton = new JButton("Create");
		createFileButton.addActionListener(e -> {
			RoundButton tmpButton = new RoundButton(file.getPath());
			tmpButton.addActionListener(event -> {
				try {

					String[] split = browseFileField.getText().split("\\.");
					String extension = split[split.length - 1].toLowerCase();

					if (extension.equals("txt")) {
						Runtime.getRuntime().exec("notepad " + (browseFileField.getText()));
					}

					if (extension.equals("exe")) {
						Runtime.getRuntime().exec(file.getAbsolutePath(), null, file.getParentFile());
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});

			try {
				// App.serializeSaves.addSave(tmpButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			App.window.addButton(tmpButton);
		});
		createFileButton.setBounds(222, 91, 89, 23);
		contentPane.add(createFileButton);

		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(186, 35, 46, 14);
		contentPane.add(lblFile);

		JButton browseDirectoryButton = new JButton("Browse");
		browseDirectoryButton.addActionListener(e -> {
			file = null;
			fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			int ret = fileChooser.showDialog(null, "Open file");
			if (ret == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				browseDirectoryField.setText(file.getAbsolutePath());
			}

		});
		browseDirectoryButton.setBounds(123, 199, 89, 23);
		contentPane.add(browseDirectoryButton);

		browseDirectoryField = new JTextField();
		browseDirectoryField.setEnabled(false);
		browseDirectoryField.setColumns(10);
		browseDirectoryField.setBounds(10, 168, 454, 20);
		contentPane.add(browseDirectoryField);

		JButton createDirectoryButton = new JButton("Create");
		createDirectoryButton.addActionListener(e -> {
			createDirectoryButton();
		});
		createDirectoryButton.setBounds(222, 199, 89, 23);
		contentPane.add(createDirectoryButton);

		JLabel lblDirectory = new JLabel("Directory:");
		lblDirectory.setBounds(186, 143, 125, 14);
		contentPane.add(lblDirectory);

		JButton loadButton = new JButton("load");
		loadButton.addActionListener(e -> {
			load();
		});
		loadButton.setBounds(174, 248, 89, 23);
		contentPane.add(loadButton);

		JButton testBtn = new JButton("test");
		testBtn.addActionListener(e -> {
			Component[] com = App.window.getContentPane().getComponents();
			for (Component tmp : com) {
				System.out.println(((RoundButton) tmp).getPath());
			}
		});
		testBtn.setBounds(280, 248, 89, 23);
		contentPane.add(testBtn);
		repaint();
		revalidate();
	}

	private void createDirectoryButton() {
		RoundButton tmpButton = new RoundButton(file.getPath());
		// tmpButton.setPath(file.getPath());
		tmpButton.addActionListener(event -> {
			try {
				Desktop.getDesktop().open(file);
			} catch (Exception ex) {
				ex.getStackTrace();
			}
		});

		try {
			App.SAVES.addSave(file.getPath());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		App.window.clear();
		load();
	}

	private void load() {
		if (App.isPathExists()) {
			App.window.clear();
			try {
				ArrayList<String> loadFiles = App.SAVES.getSave();
				Iterator<String> iter = loadFiles.iterator();
				while (iter.hasNext()) {
					File tmpFile = new File(iter.next());

					System.out.println(tmpFile.getName());
					RoundButton tmpRB = new RoundButton(tmpFile.getPath());
					tmpRB.addActionListener(event -> {
						try {
							Desktop.getDesktop().open(tmpFile);
						} catch (Exception ex) {
							ex.getStackTrace();
						}
					});
					App.window.addButton(tmpRB);

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
