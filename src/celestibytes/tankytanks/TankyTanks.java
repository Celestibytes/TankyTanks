package celestibytes.tankytanks;

import celestibytes.tankytanks.map.Map;

public class TankyTanks {
	
	/**Time elapsed after last tick in seconds*/
	private static float delta = 60f/1000f;
	private static long lastTick = -1;
	private static int FPS = 60;
	
	private static Map map;
	
	public static void main(String[] args) {
		
	}
	
	
	public static float getDelta() {
		return delta;
	}
	
	private static void calcDelta() {
		if(lastTick == -1) {
			delta = (float)FPS/1000f;
			lastTick = System.currentTimeMillis();
		} else {
			delta = (float) (System.currentTimeMillis()-lastTick) / 1000f;
		}
	}
	
	private static void render() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void gameLoop() {
		calcDelta();
	}
}
