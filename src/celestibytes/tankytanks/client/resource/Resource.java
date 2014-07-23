package celestibytes.tankytanks.client.resource;

import java.io.File;

public class Resource implements IResource {
	
	public static final String resDir = "../res";
	
	private String path;
	
	/**@param path - path in the resources dir*/
	public Resource(String path) {
		this.path = path;
	}

	@Override
	public File getFile() {
		return new File(resourceDir(), path);
	}

	@Override
	public ResourceType getResType() {
		return ResourceType.ANY;
	}
	
	private static File resourceDir() {
		return new File(resDir);
	}
}
