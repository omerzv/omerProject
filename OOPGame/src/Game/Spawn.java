package Game;

import java.util.Random;

import objects.Handler;
import objects.apple;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private apple a;
	private Random r= new Random();
	private levels levels;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		levels= new levels(handler);

		this.a=new apple(r.nextInt(650)+50, r.nextInt(450)+60, ID.Apple, handler,this);
		handler.addObject(a);
	}
	public void setScoreKeep(int scoreKeep) {
		this.scoreKeep = scoreKeep;
		this.a=new apple(r.nextInt(650)+50, r.nextInt(450)+50, ID.Apple, handler,this);
		handler.addObject(a);
	}
	public int getScoreKeep() {
		return scoreKeep;
	}

	public void tick() {
		if (scoreKeep >= 1) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);

		}
	
		if (hud.getScore()%500==0&&hud.getScore()!=0) {
			levels.level();
		}
	}

	public void render() {

	}
	public void collision() {

	}

}
