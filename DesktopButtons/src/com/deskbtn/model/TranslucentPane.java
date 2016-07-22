package com.deskbtn.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TranslucentPane extends JPanel {

	/**
	* 
	*/
	private static final long serialVersionUID = -3425074194719557745L;

	public TranslucentPane() {
		setOpaque(false);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(getBackground());
		// g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		// g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Color.BLACK);
		g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		g2d.dispose();
	}

}