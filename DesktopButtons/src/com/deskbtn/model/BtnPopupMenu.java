package com.deskbtn.model;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import com.deskbtn.main.App;

public class BtnPopupMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7839956365939247560L;

	public BtnPopupMenu(RoundButton btn) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JMenuItem deleteItem = new JMenuItem("Delete");
		deleteItem.addActionListener(e -> {
			App.window.deleteButton(btn);
			App.SAVES.saveButtons();

		});
		JMenuItem testItem = new JMenuItem("Test");
		testItem.addActionListener(e -> {
			btn.setBackground(Color.RED);
			App.window.refresh();

		});
		
		this.add(testItem);
		this.add(deleteItem);
		
	}
}
