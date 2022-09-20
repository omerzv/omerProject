package Game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	private static float HEALTH;
	private float greenValue = 255;
	private int redValue = 75;

	private int score = 0;
	private int level = 1;
	public HUD() {
		HEALTH=100;
	}

	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, HEALTH);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALTH * 2;
		score++;
	}
	public static void setHEALTH(float hEALTH) {
		HEALTH = hEALTH;
	}
	public static float getHEALTH() {
		return HEALTH;
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(redValue, (int) greenValue, 0));
		g.fillRect(15, 15, (int) HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, (int) HEALTH * 2, 32);

		g.drawString("Score: " + score, 10, 60);
		g.drawString("Level: " + level, 10, 74);
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
