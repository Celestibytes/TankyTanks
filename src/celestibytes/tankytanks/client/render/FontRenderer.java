package celestibytes.tankytanks.client.render;

import org.lwjgl.opengl.GL11;

import celestibytes.tankytanks.client.resource.Texture;
import celestibytes.tankytanks.client.resource.TextureHandler;
import celestibytes.tankytanks.common.util.Out;

public class FontRenderer {
	public static Texture characters = TextureHandler.textureCharacters;
	
	private static final int charWidth = 8;
	private static final int textureWidth = 256;
	private static final float charSpacing = 1f;
	
	private boolean sgaMode = false;
	private boolean newlines = false;
	private boolean wordwrap = false;
	private float zLevel = 1f;
	
	private static final byte[] charData = new byte[] { // 1024
		(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 5, /**/(0 << 4) | 4, /**/(0 << 4) | 1, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 3, /**/(0 << 4) | 7, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 4, /**/(0 << 4) | 6, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 7, /**/(0 << 4) | 6, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 5 /**/ /*3 free spaces*/
	};
	
	/**@return the width of the char in pixels*/
	public int getCharWidth(char chr) {
		int cInd = this.getCharIndex(chr);
		return getCharWidth(cInd);
	}
	
	public int getCharWidth(int cInd) {
		if(cInd > -1 && cInd < charData.length) {
			byte data = charData[cInd];
			return (data & 0xF)-((data >> 4) & 0xF);
		}
		Out.warn("Character(" + (cInd < 0 ? "NEGATIVE" : cInd) + ":" + (int)cInd + ") is missing size mapping, using default charWidth!"); // TODO: clean up
		return charWidth;
	}
	
	private void enableWordWrap(boolean enable) {
		this.wordwrap = enable;
	}
	
	public void enableNewlines(boolean enable) {
		this.newlines = enable;
	}
	
	public void enableSGAMode(boolean enable) {
		this.sgaMode = enable;
	}
	
	public void setZLevel(float zLevel) {
		this.zLevel = zLevel;
	}
	
	public int getCharIndex(char chr) {
		switch((int)chr) {
		case 20: // whitespace
			return 1023;
		}
		if((int) chr >= (int)'A' && (int) chr <= (int) 'Z') {
			return (sgaMode ? 96 : 0)+(int)chr-(int)'A';
		}
		if((int) chr >= (int)'a' && (int) chr <= (int) 'z') {
			return (sgaMode ? 96 : 32)+(int)chr-(int)'a';
		}
		if((int) chr >= (int)'0' && (int)chr <= (int) '9') {
			return 64+((int)chr-(int)'0');
		}
		return 0; // Default to capital A
	}
	
	public void renderString(int[] charIndexArray, float size, float x, float y) {
		float offset = 0f;
		for(int i=0;i<charIndexArray.length;i++) {
			int cInd = charIndexArray[i];
			renderChar(x+offset,y,cInd,size);
			offset+=size/(float)getCharWidth(cInd);
			offset+=charSpacing;
		}
	}
	
	public int[] stringToIndArray(String str) {
		int[] charInds = new int[str.length()];
		int discarded = 0;
		for(int i=0;i<str.length();i++) {
			char chr = str.charAt(i);
			int chrInd = getCharIndex(chr);
			charInds[i]=chrInd;
		}
		int[] ret = new int[charInds.length-discarded];
		System.arraycopy(charInds, 0, ret, 0, ret.length);
		return ret;
	}
	
	public void renderString(String s, float size, float x, float y) {
		renderString(stringToIndArray(s), size, x, y);
	}
	
	/*Yes, I know this is the slowest way of rendering...*/
	public void renderChar(float x, float y, int id, float size) {
		Out.debug("render char: " + id);
		int charX = id%32;
		int charY = (int)Math.floor(id/32);
		
		characters.bindTexture();
		GL11.glColor3f(1f,0f,1f);
		GL11.glBegin(GL11.GL_QUADS);
		
			GL11.glTexCoord2f(0f, 0f);
//			GL11.glTexCoord2f((float)(charX)*(charWidth/256f), (float)(charY)*(charWidth/256f));
			GL11.glVertex3f(x, y, this.zLevel);
			
			GL11.glTexCoord2f(1f, 0f);
//			GL11.glTexCoord2f((float)(charX+1)*(charWidth/256f), (float)(charY)*(charWidth/256f));
			GL11.glVertex3f(x+size, y, this.zLevel);
			
			GL11.glTexCoord2f(1f, 1f);
//			GL11.glTexCoord2f((float)(charX+1)*(charWidth/256f), (float)(charY+1)*(charWidth/256f));
			GL11.glVertex3f(x+size, y+size, this.zLevel);
			
			
//			GL11.glTexCoord2f((float)(charX+1)*(charWidth/256f), (float)(charY+1)*(charWidth/256f));
//			GL11.glVertex3f(x+size, y+size, this.zLevel);
			GL11.glTexCoord2f(0f, 1f);
//			GL11.glTexCoord2f((float)(charX)*(charWidth/256f), (float)(charY+1)*(charWidth/256f));
			GL11.glVertex3f(x, y+size, this.zLevel);
			
//			GL11.glTexCoord2f((float)(charX)*(charWidth/256f), (float)(charY)*(charWidth/256f));
//			GL11.glVertex3f(x, y, this.zLevel);
			
		GL11.glEnd();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
//		GL11.glDisable(GL11.GL_BLEND);
//		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
}
