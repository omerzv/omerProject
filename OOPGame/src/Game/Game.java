package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Manu.EndMenu;
import objects.Handler;
import objects.Player;
import objects.smartEnemy;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 780;
	public static final int HEIGHT = WIDTH / 4 * 3;//585
	private Thread t;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Spawn spawnner;
	private Window window;

	public Game() {
		this.handler = new Handler();
		this.hud = new HUD();
		this.addKeyListener(new KeyInput(handler));
		this.handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, ID.player, handler));
		this.spawnner = new Spawn(handler, hud);
		this.window=new Window(WIDTH, HEIGHT, "My Game", this);
		this.handler.addObject(new smartEnemy(WIDTH/3, HEIGHT/2, ID.smartEnemy, handler));

	}


	public synchronized void start() {
		t = new Thread(this,"Game");
		t.start();
		running = true;

	}

	public synchronized void stop() {
		running=false;
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1){
				tick();
				delta--;
			}
			if (running)
				render();
		}
		this.window.close();
		new EndMenu(hud.getScore(),hud.getLevel());
	}

	private void tick() {
		handler.tick();
		spawnner.tick();
		hud.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(47,38,38));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		try {
			hud.render(g);
		} catch (Exception e) {
			stop();
		}

		g.dispose();
		bs.show();
	}

	public static float clamp(float var, float min, float max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}


}
