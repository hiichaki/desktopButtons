package com.deskbtn.controller;

import java.awt.Color;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import com.deskbtn.main.App;
import com.deskbtn.model.RoundButton;
import com.sun.javafx.scene.control.skin.ColorPalette;

import javafx.scene.control.ColorPicker;

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
			App.mainFrame.deleteButton(btn);
			App.SAVES.saveButtons();
			AddingSettings.trigger();
		});
		
		JMenuItem pathItem = new JMenuItem(btn.getBtnPropperties().getPath());
		pathItem.setEnabled(false);
		
		JMenuItem colorItem = new JMenuItem("Color");
		colorItem.addActionListener(e -> {
	
//			btn.getBtnPropperties().setColor(Color.RED);
//			App.SAVES.saveButtons();
//			App.mainFrame.refresh();
		});
		
		
		this.add(pathItem);
		this.add(colorItem);
		this.add(deleteItem);

	}
}
