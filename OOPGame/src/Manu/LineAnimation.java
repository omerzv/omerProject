package Manu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;
import Game.Trail;
import objects.GameObject;
import objects.Handler;

public class LineAnimation extends GameObject {
	private Handler handler;
	private Color color=new Color(234, 169, 122);
	
	
	/**
	 * @param handler To add the tails 
	 * @param x Location in width dimension
	 * @param y Location in height dimension
	 * @param velX Width pixel move every tick
	 * @param velY Height pixel move every tick
	 * 
	 * Liner movement - the speed in width dimension and height dimension remains fixed
	 */
	public LineAnimation(Handler handler,float x,float y,float velX,float velY) {
		this.handler=handler;
		this.x=x;
		this.y=y;
		this.velX=velX;
		this.velY=velY;
	}
	

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		handler.addObject(new Trail(x, y, ID.Trail, 16,
				16, 0.03f, color, handler));
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillArc((int) x, (int) y, 16, 16, 0, 360);
		if(x<-10||x>480||y<0)
			handler.removeObject(this);
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
