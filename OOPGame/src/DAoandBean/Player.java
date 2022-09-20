package DAoandBean;

public class Player {
	private String name;
	private int score;
	private int level;
	
	public Player(String name,int score,int level) {
		this.name=name;
		this.score=score;
		this.level=level;
	}

	public String getName() {
		return name;
	}

	public String getScore() {
		return  Integer.toString(score);
	}

	public String getLevel() {
		return Integer.toString(level);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", level=" + level + "]";
	}

	
}
