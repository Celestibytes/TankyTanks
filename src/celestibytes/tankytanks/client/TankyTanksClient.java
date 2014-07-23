package celestibytes.tankytanks.client;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import celestibytes.tankytanks.client.render.FontRenderer;
import celestibytes.tankytanks.common.map.Map;
import celestibytes.tankytanks.common.util.Out;
import de.matthiasmann.twl.utils.PNGDecoder;

public class TankyTanksClient {
	
	/**Time elapsed after last tick in seconds*/
	private static float delta = 60f/1000f;
	private static long lastTick = -1;
	private static long cycleTimer = -1;
	private static int FPS = 60;
	
	private static Map map;
	private static FontRenderer fren;
	
	private static void init() {
		fren = new FontRenderer();
		System.out.println(FontRenderer.characters.isInitialized());
	}
	
	public static void runGame() {
		
		// GL setup
		
		try {
			Display.setTitle("TankyTanks - DEV");
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
//		GL11.glViewport(0, 0, 800, 600);
//		GL11.glOrtho(0d, 1d, 0d, 1d, 1d, 1d);
//		GL11.glOrtho(0, 960, 0, 720, -2.0, 2.0);
		GL11.glOrtho(0, 800, 600, 0, -2.0, 2.0);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
//		GL11.glEnable(GL11.GL_DEPTH_TEST);
		
		init();
		
		while(!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			gameLoop();
			Display.update();
			Display.sync(FPS);
		}
		cleanUp();
	}
	
	public static float getDelta() {
		return delta;
	}
	
	private static void cleanUp() {
		try {
			GLHandler.cleanUp();
			Display.destroy();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void calcDelta() {
		if(lastTick == -1) {
			delta = (float)FPS/1000f;
			lastTick = System.currentTimeMillis();
		} else {
			delta = (float) (System.currentTimeMillis()-lastTick) / 1000f;
			lastTick = System.currentTimeMillis();
		}
	}
	
	private static void render() {
//		GL11.glColor3f(1f, 0f, 0f);
//		GL11.glBegin(GL11.GL_QUADS);
//		GL11.glVertex2f(0f, 0f);
//		GL11.glVertex2f(0f, 100f);
//		GL11.glVertex2f(100f, 100f);
//		GL11.glVertex2f(100f, 0f);
//		GL11.glEnd();
//		GL11.glColor3f(.5f,.5f,0f);
		
		fren.renderString("ABCDEFG", 50f, 100f, 100f);
	}
	
	private static void gameLoop() {
		cycleTimer = System.currentTimeMillis();
		
		calcDelta();
		Out.debug("Delta: " + getDelta());
		GL11.glLoadIdentity();
		render();
		
		Out.debug("Cycle time: " + (System.currentTimeMillis()-cycleTimer) + " ms.");
	}
}
