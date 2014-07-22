package celestibytes.tankytanks.client.resource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import celestibytes.tankytanks.client.util.GLObjectType;
import celestibytes.tankytanks.client.util.IGLObject;


public class Texture implements IGLObject, IResource {
	
	private int textureWidth;
	private int textureHeight;
	
	private int glTexId = -1;
	
	private boolean hasAlpha = true;
	
	private Resource resource;
	
	protected Texture(Resource res) {
		this.resource = res;
	}
	
	public void bindTexture() {
		if(this.glTexId == -1) {
			return;
		}
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.glTexId);
	}
	
	private void loadTexture(InputStream in) {
//		BufferedImage img = ImageIO.read(in);
		this.glTexId = GL11.glGenTextures();
	}
	
	private void texData(BufferedImage img) {
		if(glTexId == -1) {
			return;
		}
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTexId);
		int[] pixels = new int[textureWidth*textureHeight];
		img.getRGB(0, 0, textureWidth, textureHeight, pixels, 0, textureWidth);
		
		ByteBuffer buf = BufferUtils.createByteBuffer(textureWidth*textureHeight*(hasAlpha ? 4 : 3));
		
		for(int y=0;y<textureHeight;y++) {
			for(int x=0;x<textureHeight;x++) {
				int pixel = pixels[y*textureWidth+x];
				buf.put((byte)((pixel >> 16) & 0xFF));
				buf.put((byte)((pixel >> 8) & 0xFF));
				buf.put((byte)((pixel) & 0xFF));
				buf.put((byte)((pixel >> 24) & 0xFF));
			}
		}
		buf.flip();
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, textureWidth, textureHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buf);
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
