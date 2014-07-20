package celestibytes.tankytanks.common.entity;

import celestibytes.tankytanks.common.utilInterfaces.IArmored;
import celestibytes.tankytanks.common.utilInterfaces.IDamageSource;
import celestibytes.tankytanks.common.utilInterfaces.IDamageable;

public class EntityLiving extends EntityMobile implements IDamageable {

	private int maxHealth = 100;
	private int health = this.maxHealth;
	
	
	public EntityLiving(float x, float y) {
		super(x, y);
	}
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		this.health = this.maxHealth;
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public void damage(int damage, IDamageSource source) {
		if(this instanceof IArmored) {
			((IArmored)this).damageArmor(damage);
			this.health-=(int)Math.floor(((IArmored)this).getProtection()*damage);
		} else {
			this.health -= damage;
		}
		
		if(this.health <=0f) {
			this.kill(source);
		}
	}
	
	public void kill(IDamageSource source) {
		
	}

}
