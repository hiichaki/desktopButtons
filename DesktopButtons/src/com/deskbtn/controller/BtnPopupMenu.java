package com.deskbtn.controller;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.deskbtn.main.App;
import com.deskbtn.model.RoundButton;

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
			Display d = new Display();
			Shell s = new Shell(d);

			ColorDialog cd = new ColorDialog(s);
			cd.setText("ColorDialog");
			cd.setRGB(new RGB(150, 150, 150));
			RGB color = cd.open();
			if (color == null) {
				return;
			}
			btn.getBtnPropperties().setColor(color);
			App.SAVES.saveButtons();
			App.mainFrame.refresh();
			d.close();

		});

		this.add(pathItem);
		this.add(colorItem);
		this.add(deleteItem);

	}
}
