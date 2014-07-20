package celestibytes.tankytanks.common.map;

public class Map {
	private final int mapWidth;
	private final int mapHeight;
	
	public Map(int mw, int mh) {
		this.mapWidth = mw;
		this.mapHeight = mh;
	}
	
	public int getMapWidth() {
		return this.mapWidth;
	}
	
	public int getMapHeight() {
		return this.mapHeight;
	}
}
