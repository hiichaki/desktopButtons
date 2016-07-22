package com.deskbtn.model;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.deskbtn.main.App;

public class RoundBtnPopupMenu extends JPopupMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7839956365939247560L;
	
	public RoundBtnPopupMenu(RoundButton btn) {
		JMenuItem deleteItem = new JMenuItem("Delete");
		deleteItem.addActionListener(e -> {
			App.window.deleteButton(btn);

		});
		this.add(deleteItem);
	}
}
