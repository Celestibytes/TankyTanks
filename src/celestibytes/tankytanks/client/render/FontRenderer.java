package celestibytes.tankytanks.client.render;

import celestibytes.tankytanks.client.resource.Texture;
import celestibytes.tankytanks.client.resource.TextureHandler;
import celestibytes.tankytanks.common.util.Out;

public class FontRenderer {
	private static Texture characters = TextureHandler.textureCharacters;
	
	private static final int charWidth = 8;
	private static final int textureWidth = 256;
	private static final float charSpacing = 1f;
	
	private boolean sgaMode = false;
	private boolean newlines = false;
	private boolean wordwrap = false;
	
	private static final byte[] charData = new byte[] { // 1024
		(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 5, /**/(0 << 4) | 4, /**/(0 << 4) | 1, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 3, /**/(0 << 4) | 7, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 4, /**/(0 << 4) | 6, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 7, /**/(0 << 4) | 6, /**/(0 << 4) | 5, /**/(0 << 4) | 5, /**/(0 << 4) | 4, /**/(0 << 4) | 4, /**/(0 << 4) | 5 /**/ /*3 free spaces*/
	};
	
	/**@return the width of the char in pixels*/
	public int getCharWidth(char chr) {
		int cInd = this.getCharIndex(chr);
		if(cInd > -1 && cInd < charData.length) {
			byte data = charData[cInd];
			return (data & 0xF)-((data >> 4) & 0xF);
		}
		Out.warn("Character(" + (chr < 0 ? "NEGATIVE" : chr) + ":" + (int)chr + ") is missing size mapping, using default charWidth!");
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
	
	
	
	public void renderString(int[] charIndexArray) {
		
	}
	
	public void renderString(String str) {
		int[] charInds = new int[str.length()];
		int discarded = 0;
		for(int i=0;i<str.length();i++) {
			char chr = str.charAt(i);
			if(newlines) {
				
			}
			
		}
		int[] ret = new int[charInds.length-discarded];
	}
}
