package celestibytes.tankytanks.client.util;

public class GLHelper {
	
	private static Colour oldColor = null;
	private static Colour nowColor = null;
	
	public static void glSetColor(Colour c) {
		c.setGLColor();
		if(nowColor != null) {
			oldColor = nowColor.getCopy();
		}
		nowColor = c.getCopy();
	}
	
	public static Colour getOldColor() {
		return oldColor;
	}
	
	public static Colour getCurrentColor() {
		return nowColor;
	}
	
	public static void glSetOldColor() {
		if(oldColor != null) {
			oldColor.setGLColor();
			oldColor = nowColor.getCopy();
		}
	}
}
