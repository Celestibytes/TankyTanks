package celestibytes.tankytanks.common.utilInterfaces;

import celestibytes.tankytanks.common.entity.EntityLiving;

public interface IDamageSource {
	
	public String getDeathMessage(EntityLiving e);
	
	/**Relative to 1f, 0f for no penetration, 1f for full penetration.*/
	public float getArmorPenetration();
	
}
