package com.deskbtn.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.deskbtn.main.App;
import com.deskbtn.model.RoundButton;
import com.deskbtn.model.TranslucentPane;

/*
 * frame with buttons
 */
public class TranslucentWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531962971491318167L;

	public TranslucentWindow() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.getStackTrace();
		}

		try {
			if (App.isPathExists()) {

				for (Iterator<String> iter = App.SAVES.getSave().iterator(); iter.hasNext();) {
					App.SAVES.addSave(iter.next());
				}

			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setUndecorated(true);
		// frame.setAlwaysOnTop(true);
		this.setBackground(new Color(0, 0, 0, 0));
		TranslucentPane pane = new TranslucentPane();
		this.setContentPane(pane);
		this.setSize(new Dimension(200, 400));
		pane.setLayout(new FlowLayout());

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void addButton(JButton btn) {
		this.add(btn);
		refresh();
	}

	public void clear() {
		this.getContentPane().removeAll();
		refresh();
	}

	public void deleteButton(RoundButton btn) {
		this.getContentPane().remove(btn);
		refresh();
	}

	private void refresh() {
		this.repaint();
		this.revalidate();
	}

}