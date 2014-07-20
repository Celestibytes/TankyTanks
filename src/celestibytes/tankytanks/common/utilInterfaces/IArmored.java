package celestibytes.tankytanks.common.utilInterfaces;

public interface IArmored {
	public void damageArmor(int dmg);
	
	/**Relative to 1f, 0f for no protection, 1f for full protection*/
	public float getProtection();
	
}
