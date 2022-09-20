package Manu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAoandBean.GameDAO;

public class EndMenu extends FrameFactory {
	private int score;
	private int level;
	private JTextField name;
	private JButton start;
	private JButton leaderBord;
	private GameDAO dao;
	
	
	public EndMenu(int score,int level) {
		super(400,600,"End");
		this.score=score;
		this.level=level;
		this.actionLis.setEm(this);
		
		//getting the DB for saving score
		this.dao=GameDAO.getInstance();
		this.dao.setLevel(level);
		this.dao.setScore(score);
		
		//styling the text field
		this.name = new JTextField();
		this.name.setBackground(Color.white);
		this.name.setSize(200, 20);
		this.name.setLocation(90, 380);
		this.name.addActionListener(actionLis);
		this.add(this.name);
		
		//styling the buttons
		this.start=new JButton("Start Again");
		this.start.setLocation(90,420);
		this.start.setFont(new Font("Monospaced", 1, 20));
		this.start.setBackground(new Color(100, 90, 20));
		this.start.setSize(200,40);
		this.start.addActionListener(actionLis);
		this.add(this.start);
	
		this.leaderBord=new JButton("LeaderBord");
		this.leaderBord.setLocation(90,470);
		this.leaderBord.setFont(new Font("Monospaced",2, 20));
		this.leaderBord.setBackground(new Color(100, 90, 20));
		this.leaderBord.setSize(200,40);
		this.leaderBord.addActionListener(actionLis);
		this.add(this.leaderBord);
		
		this.frame.add(this);
		this.frame.pack();
		this.frame.setVisible(true);
		
	}
	@Override
	public void close() {
		super.close();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(new Color(47,38,38));
		g2d.fillRect(0, 0, 400,600);
		
		g2d.setColor(new Color(255,68,68));
		g2d.setFont(new Font("Ariel", 1, 35));
		g2d.drawString("Game Over", 100, 150);
		
		g2d.setFont(new Font("Ariel", 1, 20));
		g2d.drawString("Your score: "+score, 120, 200);
		
		g2d.setFont(new Font("Ariel", 1, 20));
		g2d.drawString("Your level: "+level, 130, 230);
		
		g2d.setFont(new Font("Ariel", 1, 15));
		g2d.drawString("Name your run and press enter to save", 70, 350);
	}
	

}
