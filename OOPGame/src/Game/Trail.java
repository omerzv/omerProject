package Game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import objects.GameObject;
import objects.Handler;

public class Trail extends GameObject {
	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width;
	private int height;
	private float life;
	private ID id;

	public Trail(float x, float y, ID id, int width, int height, float life, Color color, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;

		return AlphaComposite.getInstance(type, alpha);
	}

	@Override
	public void tick() {
		if (alpha > life)
			alpha -= life - 0.001f;
		else
			handler.removeObject(this);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));

		g.setColor(color);
		g.fillArc((int) x, (int) y, this.width, this.height, 0, 360);

		g2d.setComposite(makeTransparent(1));
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int) x, (int) y, 16, 16);
	}
}
