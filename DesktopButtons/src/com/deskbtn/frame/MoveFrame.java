package com.deskbtn.frame;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.deskbtn.main.App;
import com.deskbtn.model.Positioning;

public class MoveFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586909906259401889L;
	private JPanel contentPane;
	
	public MoveFrame() {
		setTitle("Positioning");
		
		try {
			setIconImage(ImageIO.read(getClass().getResourceAsStream(App.iconPath)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		setBounds(100, 100, 325, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Positioning position = new Positioning();

		JButton topBtn = new JButton("Top");
		topBtn.addActionListener(e -> {
			position.setTop();
		});
		topBtn.setBounds(109, 11, 89, 23);
		contentPane.add(topBtn);

		JButton bottomBtn = new JButton("Bottom");
		bottomBtn.addActionListener(e -> {
			position.setBottom();
		});
		bottomBtn.setBounds(109, 96, 89, 23);
		contentPane.add(bottomBtn);

		JButton leftBtn = new JButton("Left");
		leftBtn.addActionListener(e -> {
			position.setLeft();
		});
		leftBtn.setBounds(10, 55, 89, 23);
		contentPane.add(leftBtn);

		JButton rightBtn = new JButton("Right");
		rightBtn.addActionListener(e -> {
			position.setRight();
		});
		rightBtn.setBounds(208, 55, 89, 23);
		contentPane.add(rightBtn);

		JButton centerBtn = new JButton("Center");
		centerBtn.addActionListener(e -> {
			position.setCenter();
		});
		centerBtn.setBounds(109, 55, 89, 23);
		contentPane.add(centerBtn);

		JButton topRightBtn = new JButton("Top Right");
		topRightBtn.addActionListener(e -> {
			position.setTopRight();
		});
		topRightBtn.setBounds(208, 11, 89, 23);
		contentPane.add(topRightBtn);

		JButton topLeftBtn = new JButton("Top Left");
		topLeftBtn.addActionListener(e -> {
			position.setTopLeft();
		});
		topLeftBtn.setBounds(10, 11, 89, 23);
		contentPane.add(topLeftBtn);

		JButton bottomRightBtn = new JButton("Bottom Right");
		bottomRightBtn.addActionListener(e -> {
			position.setBottomRight();
		});
		bottomRightBtn.setBounds(208, 96, 89, 23);
		contentPane.add(bottomRightBtn);

		JButton bottomLeftBtn = new JButton("Bottom Left");
		bottomLeftBtn.addActionListener(e -> {
			position.setBottomLeft();
		});
		bottomLeftBtn.setBounds(10, 96, 89, 23);
		contentPane.add(bottomLeftBtn);

	}

}
