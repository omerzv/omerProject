package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;

public class Bullet extends GameObject {
	private Handler handler;
	private Player target;
	private ShootingEnemy shooter;
	private int frame=0;
	public Bullet(ShootingEnemy shooter,float x, float y, ID id, Handler handler,int speed) {
		super(x, y, id);
		for (int i = 0; i < handler.getList().size(); i++) {
			if (handler.getList().get(i).getId() == ID.player)
				target = (Player) handler.getList().get(i);
		}
		this.shooter=shooter;
		this.handler=handler;
	}
	
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 10, 10);
	}
	@Override
	public void tick() {
		y += velY;
		x += velX;
		float difX = x - target.getX();
		float difY = y - target.getY();
		float distance = (float) Math
				.sqrt((difX) * (difX) + (difY) * (difY));

		velX = ((-1 / distance) * difX)*4;
		velY = ((-1 / distance) * difY)*4;
		if(frame>500) {
			velX *=0.8;
			velY *=0.8;
		}
		if(this.x==target.getX())handler.removeObject(this);
		if(this.y==target.getY())handler.removeObject(this);
		
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillArc((int) x, (int) y, 10, 10, 0, 360);
		frame++;
		if(frame==7000)handler.removeObject(this);
	}
}
