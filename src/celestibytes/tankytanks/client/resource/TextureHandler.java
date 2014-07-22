package celestibytes.tankytanks.client.resource;

public class TextureHandler {
	// Textures
	public static final Texture textureCharacters = new Texture(new Resource("textures/characters.png"));
	
	
	public void bindTexture(Texture tex) {
		tex.bindTexture();
	}
}
