package celestibytes.tankytanks.client;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import celestibytes.tankytanks.client.util.IGLObject;
import celestibytes.tankytanks.common.util.Out;

public class GLHandler {
	private static List<IGLObject> glObjects = new ArrayList<IGLObject>();
	
	public void registerGLObject(IGLObject obj) {
		if(obj.isInitialized()) {
			glObjects.add(obj);
			Out.dbg("Registering a GLObject of type: " + obj.getType().toString());
		}
	}
	
	
	
	
	
	public static void cleanUp() {
		for(IGLObject globj : glObjects) {
			switch(globj.getType()) {
			case TEXTURE:
				GL11.glDeleteTextures(globj.getObjectId());
			default:
				Out.err("Unknown GLObject!!! (or OkkapeL was lazy...)");
			}
		}
	}
}
