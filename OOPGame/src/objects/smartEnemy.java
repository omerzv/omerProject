package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;
import Game.Trail;

public class smartEnemy extends GameObject {
	private Handler handler;
	private GameObject player;
	int count=0;
	public smartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		for (int i = 0; i < handler.getList().size(); i++) {
			if (handler.getList().get(i).getId() == ID.player)
				player = handler.getList().get(i);
		}

	}

	@Override
	public void tick() {
		y += velY;
		x += velX;

		float difX = x - player.getX() - 8;
		float difY = y - player.getY() - 8;
		float distance = (float) Math
				.sqrt((difX+8) * (difX+8) + (difY+8) * (difY+8));

		velX = ((-1 / distance) * difX);
		velY = ((-1 / distance) * difY);
		
		handler.addObject(new Trail(x, y, ID.Trail, 16, 16, 0.03f, Color.green, handler));
		count++;
		if(count==100) {
			count=0;
//			System.out.println("difX="+difX+",difY="+difY+",distance="+distance+",velX="+velX+",velY="+velY);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillArc((int) x, (int) y, 16, 16, 0, 360);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

}
