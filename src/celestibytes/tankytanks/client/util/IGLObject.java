package celestibytes.tankytanks.client.util;

public interface IGLObject {
	public GLObjectType getType();
	
	public int getObjectId();
	
	/**Is this object put on the GPU*/
	public boolean isInitialized();
}
