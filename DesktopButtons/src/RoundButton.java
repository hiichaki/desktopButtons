import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

import javax.swing.JButton;

public class RoundButton extends JButton implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3824829552537309541L;
	
	private String test;
	
	public String getTest() {
		return test;
	}
	
	public void setTest(String s) {
		test = s;
	}
	
	public RoundButton() {

		Dimension size = new Dimension(40, 40); //getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);

		setContentAreaFilled(false);
		
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(Color.lightGray);
		}
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

	}

	Shape shape;

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}

}
