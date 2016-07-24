package com.deskbtn.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.UIManager;

import com.deskbtn.main.App;
import com.deskbtn.model.BtnPropperties;
import com.deskbtn.model.RoundButton;
import com.deskbtn.model.TranslucentPane;

/*
 * frame with buttons
 */
public class MainFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531962971491318167L;

	public MainFrame() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.getStackTrace();
		}

		App.setIcon(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		try {
			if (App.isPathExists()) {
				for (Iterator<BtnPropperties> iter = App.SAVES.getSave().iterator(); iter.hasNext();) {
					App.SAVES.addSave(iter.next());
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));

		TranslucentPane pane = new TranslucentPane();
		this.setContentPane(pane);
		this.setSize(new Dimension(App.windowWidth, 50));
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

	public void refresh() {
		this.repaint();
		this.revalidate();
	}

}