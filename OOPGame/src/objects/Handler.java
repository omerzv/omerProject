package objects;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import Game.ID;

public class Handler {
	private boolean isPowerOnMap=false;
	private List<GameObject> list = new LinkedList<>();

	public Handler() {
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		for (int i = 0; i < this.list.size(); i++) {
			GameObject tempOb = this.list.get(i);
			

			tempOb.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < this.list.size(); i++) {
			GameObject tempOb = this.list.get(i);

			tempOb.render(g);
		}
	}
	public Player getPlayer() {
		for (GameObject gameObject : this.list) {
			if(gameObject.getId()==ID.player) return (Player) gameObject;
		}
		return null;

	}

	public void addObject(GameObject object) {
		this.list.add(object);
		if(object.getClass()==EatPower.class)isPowerOnMap=true;
	}

	public void removeObject(GameObject object) {
		this.list.remove(object);
		if(object.getClass()==EatPower.class)isPowerOnMap=false;
	}

	public List<GameObject> getList() {
		return list;
	}

	public void setList(List<GameObject> list) {
		this.list = list;
	}

	public boolean isPowerOnMap() {
		return isPowerOnMap;
	}
	
}
