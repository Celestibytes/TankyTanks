package celestibytes.tankytanks.entity;

import celestibytes.tankytanks.util.MathHelper;

public class EntityMobile extends Entity {
	
	private float dx, dy;
	
	public EntityMobile(float x, float y) {
		super(x, y);
	}
	
	public void addSpeed(float dx, float dy) {
		this.dx+=dx;
		this.dy+=dy;
	}
	
	public void setSpeed(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public void update(float delta) {
		this.x+=this.dx*delta;
		this.y+=this.dy*delta;
		
		if(this.dx < 0) {
			this.dx = MathHelper.clampFloat(this.dx+0.1f, this.dx, 0f);
		}
		if(this.dx > 0) {
			this.dx = MathHelper.clampFloat(this.dx+0.1f, 0f, this.dx);
		}
		
		if(this.dy < 0) {
			this.dy = MathHelper.clampFloat(this.dy+0.1f, this.dy, 0f);
		}
		if(this.dy > 0) {
			this.dy = MathHelper.clampFloat(this.dy+0.1f, 0f, this.dy);
		}
	}

}
