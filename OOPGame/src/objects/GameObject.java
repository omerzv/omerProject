package objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.ID;

public abstract class GameObject {
	protected float x, y;
	protected ID id;
	protected float velX, velY;

	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public GameObject() {
		
	}

	public abstract Rectangle getBounds();

	public abstract void tick();

	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float f) {
		this.y = f;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

}
