package Game;

import java.util.Random;

import objects.BasicEnemy;
import objects.CircalEnemy;
import objects.EatPower;
import objects.Handler;
import objects.MovingEllipseEnemy;
import objects.ShootingEnemy;

public class levels {
	private Handler handler;
	private Random r= new Random();
	private EatPower ep;
	public levels(Handler handler) {
		super();
		this.handler = handler;
	}

	public void level() {
		if(handler.getList().size()>150&&!handler.isPowerOnMap()) {
			handler.addObject(new EatPower(r.nextInt(500)+100, r.nextInt(400)+100, ID.EatPower, handler));
		}
		switch (r.nextInt(6)) {
		case 0:
			handler.addObject(new ShootingEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.ShootingEnemy, handler));
			break;
		case 1,4,5:
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler,r.nextInt(4)+1));
			break;
		case 2:
			handler.addObject(new CircalEnemy(r.nextInt(Game.WIDTH-200)+100,r.nextInt(Game.HEIGHT-400)+150 , ID.CircalEnemy, handler,r.nextInt(170)+50));
			break;
		case 3:
			handler.addObject(new MovingEllipseEnemy(50, r.nextInt(Game.HEIGHT-100)+50, ID.BasicEnemy, handler,r.nextInt(170)+10));
			break;
		}
	}
}
