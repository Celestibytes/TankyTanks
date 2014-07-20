package celestibytes.tankytanks.entity;

import celestibytes.tankytanks.utilInterfaces.IArmored;

public class EntityTank extends EntityLiving implements IArmored {

	private int armor;
	private float protection;
	
	public EntityTank(float x, float y) {
		super(x, y);
	}

	@Override
	public void damageArmor(int dmg) {
		if(this.armor<=0) {
			return;
		}
		this.armor-=dmg;
	}

	@Override
	public float getProtection() {
		return this.armor > 0 ? this.protection : 0f;
	}

}
