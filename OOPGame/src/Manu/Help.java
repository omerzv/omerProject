package Manu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import Game.Game;

public class Help extends FrameFactory   {
	
	
	
	public Help() {
		super(Game.WIDTH,Game. HEIGHT,"Help");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.add(this);
		this.frame.setVisible(true);
	}
	
	
	
	@Override
	public  void paint(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g2d.setColor(Color.green);
		g2d.setFont(new Font("Monospaced", ALLBITS, 25));
		g2d.drawString("HELP", 350, 40);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Monospaced", ERROR, 18));
		
		g2d.drawString("The goal of this game is to survive as long as you can.", 50, 70);
		g2d.drawString("If any of the enemy touching you, your health will get down.", 50, 100);
		g2d.drawString("You are the white player,and you can move with the arrows.", 50, 150);
		g2d.drawString("Pressing space will triger a dodge and your player become gray,", 50, 180);
		g2d.drawString("in this state you dont get any damage for less then a second.", 50, 210);
		g2d.drawString("There are green apple that spwan around the screen,", 50, 260);
		g2d.drawString("only when you eat one the other will spwan.", 50, 290);
		g2d.drawString("Every apple you eat will rise your level,", 50, 320);
		g2d.drawString("every 10 levels you will get faster and more durable to touching.", 50, 350);
		g2d.drawString("There are also blue apples.", 50, 400);
		g2d.drawString("They are giving you the ability to eat enemy", 50, 430);
		g2d.drawString("and swpan only if there are more then 6 enemy.", 50, 460);
		g2d.drawString("This ability last only for a second", 50, 490);
	}

	
	
	
	


}