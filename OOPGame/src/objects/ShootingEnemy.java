package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;
import Game.Trail;

public class ShootingEnemy extends GameObject{
	private Handler handler;
	private int frame=0;

	public ShootingEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		velX = 3f;
		velY = 3f;
		this.handler = handler;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	@Override
	public void tick() {
		y += velY;
		x += velX;

		if(this.x<0||this.x>745)velX*=-1;

		if(this.y<0||this.y>540)velY*=-1;


		handler.addObject(new Trail(x, y, ID.Trail, 16,
				16, 0.03f, Color.blue, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillArc((int) x, (int) y, 16, 16, 0, 360);
		frame++;
		if(frame==7000) {
			handler.addObject(new Bullet(this,x,y,ID.Bullet,handler,5));
			frame=0;
		}
	}

}
