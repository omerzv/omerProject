package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Game.ID;
import Game.Trail;

public class BasicEnemy extends GameObject {
	private Handler handler;
	private Random r;


	public BasicEnemy(float x, float y, ID id, Handler handler,float speed) {
		super(x, y, id);
		r= new Random();
		velX = r.nextInt(2)+3;
		velY =  (r.nextInt(2)+3);
		this.handler = handler;
	}


	@Override
	public void tick() {
		y += velY;
		x += velX;

		if(this.x<0)velX = r.nextInt(2)+3;
		if(this.x>745) {
			velX = r.nextInt(2)+3;
			velX*=-1;
		}
		
		if(this.y<0) velY =  (r.nextInt(2)+3);
		if(this.y>540) {
			velY =  r.nextInt(2)+3;
			velY*=-1;
		}


		handler.addObject(new Trail(x, y, ID.Trail, 16,
				16, 0.03f, Color.red, handler));
	}



	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillArc((int) x, (int) y, 16, 16, 0, 360);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

}
