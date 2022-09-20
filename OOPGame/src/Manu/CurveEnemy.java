package Manu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;
import Game.Trail;
import objects.GameObject;
import objects.Handler;

public class CurveEnemy extends GameObject {
	
	private Handler handler;
	private float count=0;
	private boolean xOrY;
	private Color color=new Color(234, 169, 122);
	
	/**
	 * @param handler To add the tails 
	 * @param x (Float) Location in width dimension
	 * @param y (Float) Location in height dimension
	 * @param velX (Float) Width pixel move every tick
	 * @param velY (Float) Height pixel move every tick
	 * @param xOrY (Boolean) true= width fixed, height changes, false= width changes, height fixed
	 * @
	 * Curve movement - the speed in width dimension and height dimension changes 
	 * 
	 */
	public CurveEnemy(Handler handler,float x,float y,float velX,float velY,boolean xOrY) {
		this.handler=handler;
		this.x=x;
		this.y=y;
		this.velX=velX;
		this.velY=velY;
		 this.xOrY=xOrY;
	}
	

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
	
		count++;
		if(count%2==0) {
			
		}
		if(xOrY)	
			velY-=0.14;
		else if(velX>0)
			velX+=0.14;
		else
			velX-=0.14;
		handler.addObject(new Trail(x, y, ID.Trail, 16, 16,0.03f,color, handler));
	}

	@Override
	public void render(Graphics g) {

		g.setColor(color);
		g.fillArc((int) x, (int) y, 16, 16, 0, 360);
		if(x<-10||x>480||y<0)
			handler.removeObject(this);
	}

}
