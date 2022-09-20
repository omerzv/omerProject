package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;
import Game.Trail;

public class CircalEnemy extends GameObject {

	private Handler handelr;
	private float xCenter;
	private float yCenter;
	private float t=0f;
	private float radios;
	public CircalEnemy(float xCenter, float yCenter, ID id,Handler handler,float radios) {
		super(1, 1, id);
		this.handelr=handler;
		this.xCenter=xCenter;
		this.yCenter=yCenter;
		this.radios=radios;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	@Override
	public void tick() {
		y= (float) (yCenter+this.radios*Math.sin(t));
		x =(float) (xCenter+this.radios*Math.cos(t));;
		t+=0.06f;

		handelr.addObject(new Trail(x, y, ID.Trail, 16, 16,0.1f, Color.MAGENTA, handelr));
	}
	public void collision() {

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.MAGENTA);
		g.fillArc((int) x, (int) y, 16, 16, 0, 360);
//		g.fillOval((int)xCenter,(int) yCenter, 5, 5);
	}

}
