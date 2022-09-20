package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;
import Game.Spawn;

public class apple extends GameObject {
	private Handler handler;
	private Player player;
	private Spawn spawnner;
	public apple(float x, float y, ID id,Handler handler,Spawn spawnner) {
		super(x, y, id);
		this.handler = handler;
		for (int i = 0; i < handler.getList().size(); i++) {
			if (handler.getList().get(i).getId() == ID.player)
				player = (Player)handler.getList().get(i);
		}
		this.spawnner=spawnner;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	@Override
	public void tick() {
		collision();

	}
	public void collision() {
		if(player.getX()>(this.getX()-20)&&player.getX()<(this.getX()+20)) {
			if(player.getY()>(this.getY()-20)&&player.getY()<(this.getY()+20)) {
				spawnner.setScoreKeep(spawnner.getScoreKeep()+1);
				handler.removeObject(this);
				player.setAppleAte();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int) x, (int) y, 16, 16);
	}

}
