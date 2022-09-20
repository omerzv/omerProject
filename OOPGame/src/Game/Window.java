package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

import Manu.ActionLis;
import Manu.StartManu;

public class Window {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private ActionLis actionLis;

	public Window(int width, int height, String title, Game game) {
		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();

	}
	public void close() {
		frame.dispose();
	}
	
	public void setVisible(boolean vis){
		this.frame.setVisible(vis);
	}
	public boolean getVisible() {
		return this.frame.isVisible();
	}
	
	public Window(int width, int height, String title, StartManu startManu) {
		frame = new JFrame(title);
		actionLis=ActionLis.getInstance();
		actionLis.setSm(startManu);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		JButton start= new JButton("start");
		start.setLocation(140, 300);
		start.setFont(new Font("Monospaced", 1, 25));
		start.setBackground(new Color(234, 205, 122));
		start.setSize(200,50);
		start.addActionListener(actionLis);
		start.setFocusable(false);
		
		JButton help= new JButton("help");
		help.setLocation(140, 360);
		help.setFont(new Font("Monospaced", 100, 25));
		help.setBackground(new Color(234, 205, 122));
		help.setSize(200,50);
		help.addActionListener(actionLis);
		
		frame.add(start);
		frame.add(help);
		frame.add(startManu);
		
		frame.setVisible(true);
		startManu.start();
	}
	



}
