package Manu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Game.Window;
import objects.Handler;

public class StartManu extends Canvas implements Runnable {

	public static final int WIDTH = 480;
	public static final int HEIGHT = WIDTH/4 *5;
	private Thread t;
	private boolean running = false;
	private Handler handler;
	private Window window;
	

	public StartManu() {
		handler = new Handler();
		window=new Window(WIDTH, HEIGHT, "startM", this);
		
		Animation.startAnima(handler);

	}


	public synchronized void start() {
		t = new Thread(this,"StartManu");
		t.start();
		running = true;

	}

	public synchronized void stop() {
		running=false;

	}

	/**
	 *This function is the game loop that do the render and ticking of all the moving object 
	 *also renders text
	 */
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;

			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
		}
		this.window.close();
	}

	private void tick() {
		handler.tick();

	}
	public void setRunning(boolean running) {
		this.running = running;

	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(40, 20, 20));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		g.setColor(new Color(40, 117, 96));
		g.setFont(new Font("Monospaced", WIDTH, 40));
		g.drawString("MyGame", 165, 90);


		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new StartManu();

	}


}
