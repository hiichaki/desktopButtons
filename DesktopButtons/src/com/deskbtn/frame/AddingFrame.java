package com.deskbtn.frame;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.deskbtn.controller.AddingSettings;
import com.deskbtn.main.App;

/*
 * frame which creates buttons
 */
public class AddingFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private JTextField browseFileField;

	private File file = new File(System.getProperty("user.home"));

	public AddingFrame() {
		setTitle("Adding");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.getStackTrace();
		}

		App.setIcon(this);

		setBounds(100, 100, 490, 335);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextField browseFileField = new JTextField();
		browseFileField.setBounds(10, 60, 454, 20);
		contentPane.add(browseFileField);
		browseFileField.setColumns(10);
		browseFileField.setEnabled(false);

		JButton browseFileButton = new JButton("Browse");
		browseFileButton.addActionListener(e -> {
			file = AddingSettings.getFile();
			if (!(file == null)) {
				browseFileField.setText(file.getAbsolutePath());
			}

		});
		browseFileButton.setBounds(123, 91, 89, 23);
		contentPane.add(browseFileButton);

		JButton createFileButton = new JButton("Create");
		createFileButton.addActionListener(e -> {
			AddingSettings.createFileButton(file);
			browseFileField.setText("");

		});
		createFileButton.setBounds(222, 91, 89, 23);
		contentPane.add(createFileButton);

		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(186, 35, 46, 14);
		contentPane.add(lblFile);

		JTextField browseDirectoryField = new JTextField();
		browseDirectoryField.setEnabled(false);
		browseDirectoryField.setColumns(10);
		browseDirectoryField.setBounds(10, 168, 454, 20);
		contentPane.add(browseDirectoryField);

		JButton browseDirectoryButton = new JButton("Browse");
		browseDirectoryButton.addActionListener(e -> {
			file = AddingSettings.getDirectory();
			if (!(file == null)) {
				browseDirectoryField.setText(file.getAbsolutePath());
			}

		});
		browseDirectoryButton.setBounds(123, 199, 89, 23);
		contentPane.add(browseDirectoryButton);

		JButton createDirectoryButton = new JButton("Create");
		createDirectoryButton.addActionListener(e -> {
			AddingSettings.createDirectoryButton(file);
			browseDirectoryField.setText("");

		});
		createDirectoryButton.setBounds(222, 199, 89, 23);
		contentPane.add(createDirectoryButton);

		JLabel lblDirectory = new JLabel("Directory:");
		lblDirectory.setBounds(186, 143, 125, 14);
		contentPane.add(lblDirectory);

		JButton loadButton = new JButton("load");
		loadButton.addActionListener(e -> {
			AddingSettings.load();
		});
		loadButton.setBounds(174, 248, 89, 23);
		contentPane.add(loadButton);

		// JButton testBtn = new JButton("test");
		// testBtn.addActionListener(e -> {
		//
		// });
		// testBtn.setBounds(280, 248, 89, 23);
		// contentPane.add(testBtn);
		repaint();
		revalidate();
	}

}
