package celestibytes.tankytanks.common.utilInterfaces;

public interface IDamageable {
	public int getHealth();
	
	public void damage(int damage, IDamageSource source);
}
