package celestibytes.tankytanks.entity;

public abstract class Entity {
	protected float x,y;
	
	protected String name = "nameless";
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void update(float delta);
}
