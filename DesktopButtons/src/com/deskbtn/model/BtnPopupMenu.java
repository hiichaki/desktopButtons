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
			App.frameSettings.trigger();
		});
		JMenuItem testItem = new JMenuItem(btn.getPath());
		testItem.addActionListener(e -> {

		});
		testItem.setEnabled(false);
		
		this.add(testItem);
		this.add(deleteItem);
		
	}
}
