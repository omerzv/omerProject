package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Game;
import Game.HUD;
import Game.ID;

public class Player extends GameObject {

	private Handler handler;
	private float dyingSpeed=3;
	private int appleAte=1;
	private boolean isBoosted=false;
	private int upAndLeft=-5;
	private int downAndRight=5;
	private Color color=Color.white;
	private boolean canEat=false;
	private int countToEat=0;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {

		x += velX;
		y += velY;

		x = Game.clamp((int) x, 0, Game.WIDTH - 32);
		y = Game.clamp((int) y, 0, Game.HEIGHT - 55);
		if(color==Color.white||color==Color.yellow)
			collision();
		if(this.appleAte%10==0&&!this.isBoosted) {

			this.dyingSpeed-=0.3;
			if(this.upAndLeft>-8) {
				System.out.println(2);
				this.upAndLeft-=1;
				this.downAndRight+=1;
			}
			this.isBoosted=true;
		}
		if(this.canEat) {
			this.countToEat++;
			if(countToEat%130==0) {
				this.canEat=false;
				color=Color.white;
			}

		}
	}

	public void collision() {
		for (int i = 0; i < handler.getList().size(); i++) {
			GameObject temp = handler.getList().get(i);

			if (temp.getId() == ID.BasicEnemy || temp.getId() == ID.smartEnemy||
					temp.getId()==ID.ShootingEnemy||temp.getId()==ID.CircalEnemy||
					temp.getId()==ID.MovingEllipseEnemy||temp.getId()==ID.Bullet) {

				if (getBounds().intersects(temp.getBounds())) {
					if(this.canEat) handler.removeObject(temp);	

					else {
						HUD.setHEALTH(HUD.getHEALTH()-dyingSpeed);
						if(temp.getId()==ID.Bullet) this.handler.removeObject(temp);
					}
				}
			}


		}

	}

	@Override
	public void render(Graphics g) {

		g.setColor(color);
		g.fillRect((int) x, (int) y, 16, 16);

	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	public int getUpAndLeft() {
		return upAndLeft;
	}

	public int getDownAndRight() {
		return downAndRight;
	}
	public void setAppleAte() {
		this.appleAte++;
		if(this.appleAte%10==0)this.isBoosted=false;
	}
	@Override
	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 16, 16);
	}
	public void setCanEat(boolean canEat) {
		this.canEat = canEat;
		color=Color.yellow;
	}

}
