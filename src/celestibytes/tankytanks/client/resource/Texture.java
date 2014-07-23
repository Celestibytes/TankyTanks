package celestibytes.tankytanks.client.resource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import celestibytes.tankytanks.client.GLHandler;
import celestibytes.tankytanks.client.util.GLObjectType;
import celestibytes.tankytanks.client.util.IGLObject;
import celestibytes.tankytanks.common.util.Out;


public class Texture implements IGLObject, IResource {
	
	private int textureWidth;
	private int textureHeight;
	
	private int glTexId = -1;
	
	private boolean hasAlpha = true;
	
	private Resource resource;
	
	protected Texture(Resource res) {
		this.resource = res;
		InputStream is = null;
		try {
			is = new FileInputStream(res.getFile()); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		loadTexture(is);
		GLHandler.registerGLObject(this);
	}
	
	public void bindTexture() {
		if(this.glTexId == -1) {
			return;
		}
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.glTexId);
	}
	
	private void loadTexture(InputStream in) {
		this.glTexId = GL11.glGenTextures();
		BufferedImage img = null;
		try {
			img = ImageIO.read(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(img != null) {
			this.textureWidth = img.getWidth();
			this.textureHeight = img.getHeight();
			this.texData(img);
		} else {
			Out.err("Img null!");
		}
	}
	
	private void texData(BufferedImage img) {
		if(glTexId == -1 || img == null) {
			return;
		}
		
		int[] pixels = new int[textureWidth*textureHeight];
		img.getRGB(0, 0, textureWidth, textureHeight, pixels, 0, textureWidth);
		
		Out.dbg("TexData!");
		ByteBuffer buf = BufferUtils.createByteBuffer(textureWidth*textureHeight*(hasAlpha ? 4 : 3));
		
		for(int y=0;y<textureHeight;y++) {
			for(int x=0;x<textureWidth;x++) {
				int pixel = pixels[y*textureWidth+x];
				buf.put((byte)((pixel >> 16) & 0xFF));
				buf.put((byte)((pixel >> 8) & 0xFF));
				buf.put((byte)((pixel) & 0xFF));
				buf.put((byte)((pixel >> 24) & 0xFF));
				Out.out("alpha: " + ((pixel >> 24) & 0xFF));
				Out.out("red: " + ((pixel >> 16) & 0xFF));
				Out.out("green: " + ((pixel >> 6) & 0xFF));
				Out.out("blue: " + ((pixel >> 0) & 0xFF));
//				buf.put((byte)0);
//				buf.put((byte)0);
//				buf.put((byte)0);
//				buf.put((byte)0);
			}
		}
		buf.flip();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexId);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, textureWidth, textureHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buf);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}

	@Override
	public GLObjectType getType() {
		return GLObjectType.TEXTURE;
	}

	@Override
	public int getObjectId() {
		return glTexId;
	}

	@Override
	public boolean isInitialized() {
		return glTexId != -1;
	}

	@Override
	public File getFile() {
		return resource != null ? resource.getFile() : null;
	}

	@Override
	public ResourceType getResType() {
		return ResourceType.TEXTURE;
	}
}
