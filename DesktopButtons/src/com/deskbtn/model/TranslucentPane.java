package com.deskbtn.model;
import java.awt.AlphaComposite;
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
            g2d.setComposite(AlphaComposite.SrcOver.derive(0.85f));
            g2d.setColor(new Color(0f,0f,0f,0.01f ));
            g2d.fillRect(0, 0, getWidth(), getHeight());

        }

    }