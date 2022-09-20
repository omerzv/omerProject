package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Game;
import Game.ID;
import Game.Trail;

public class MovingEllipseEnemy extends GameObject {

	private Handler handelr;
	private float xCenter;
	private float yCenter;
	private float t=0f;
	private float plusOrMinos=1f;
	private int xRadius;
	private int yRadius;
	
	public MovingEllipseEnemy(float xCenter, float yCenter, ID id,Handler handler,int xRadius) {
		super(1, 1, id);
		this.handelr=handler;
		this.xCenter=xCenter;
		this.yCenter=yCenter;
		this.xRadius=xRadius;
		this.yRadius=150;
		if(xRadius>80)
			yRadius=10;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	@Override
	public void tick() {
		if(xCenter==+50)plusOrMinos=1f;
		if(xCenter==Game.WIDTH-50) plusOrMinos=-1f;
		xCenter+=plusOrMinos;
		
		y= (float) (yCenter+this.xRadius*Math.sin(t));
		x =(float) (xCenter+this.yRadius*Math.cos(t));;
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
