package Game;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import objects.GameObject;
import objects.Handler;
import objects.Player;

public class KeyInput extends KeyAdapter {
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private boolean isDoge=false;
	public KeyInput(Handler handler) {
		this.handler = handler;
		for (int i = 0; i < keyDown.length; i++) {
			keyDown[i] = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.getList().size(); i++) {
			GameObject tempOb = handler.getList().get(i);

			if (tempOb.getId() == ID.player) {
				Player player=(Player) tempOb; 
				if (key == KeyEvent.VK_UP) {
					player.setVelY(player.getUpAndLeft());
					keyDown[0] = true;
				}
				if (key == KeyEvent.VK_DOWN) {
					player.setVelY(player.getDownAndRight());
					keyDown[1] = true;
				}
				if (key == KeyEvent.VK_LEFT) {
					player.setVelX(player.getUpAndLeft());
					keyDown[2] = true;
				}
				if (key == KeyEvent.VK_RIGHT) {
					player.setVelX(player.getDownAndRight());
					keyDown[3] = true;
				}
				if (key == KeyEvent.VK_SPACE&&!isDoge) {
					Color color=player.getColor();
					player.setColor(Color.darkGray);
					if(keyDown[0])player.setVelY(-20);
					if(keyDown[1])player.setVelY(20);
					if(keyDown[2])player.setVelX(-20);
					if(keyDown[3])player.setVelX(20);
					try {
						TimeUnit.MILLISECONDS.sleep(100);
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}finally {
						isDoge=true;
						player.setColor(color);
						if(keyDown[0])player.setVelY(player.getUpAndLeft());
						if(keyDown[1])player.setVelY(player.getDownAndRight());
						if(keyDown[2])player.setVelX(player.getUpAndLeft());
						if(keyDown[3])player.setVelX(player.getDownAndRight());
					}
					
				}//space if

			}

		}
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.getList().size(); i++) {
			GameObject tempOb = handler.getList().get(i);

			if (tempOb.getId() == ID.player) {
				Player player=(Player) tempOb; 
				if (key == KeyEvent.VK_SPACE) {
					isDoge=false;
				}
				if (key == KeyEvent.VK_UP) {
					keyDown[0] = false;
					if(keyDown[1])player.setVelY(player.getDownAndRight());
				}
				if (key == KeyEvent.VK_DOWN) {
					keyDown[1] = false;
					if(keyDown[0])player.setVelY(player.getUpAndLeft());
				}
				if (key == KeyEvent.VK_LEFT) {
					keyDown[2] = false;
					if(keyDown[3])player.setVelX(player.getDownAndRight());
				}
				if (key == KeyEvent.VK_RIGHT) {
					keyDown[3] = false;
					if(keyDown[2])player.setVelX(player.getUpAndLeft());
				}
				if (!keyDown[0] && !keyDown[1])
					tempOb.setVelY(0);
				if (!keyDown[2] && !keyDown[3])
					tempOb.setVelX(0);

			}

		}
	}

}
