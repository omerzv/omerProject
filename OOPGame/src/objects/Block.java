package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;

public class Block extends GameObject {
	private Handler handler;
	private Player player;
	public Block(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.player=this.handler.getPlayer();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 64, 16);
	}

	@Override
	public void tick() {
		if(this.getBounds().intersects(player.getBounds())) {
			System.out.println("ss");
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int) x, (int) y, 64, 16);

	}

}
