package celestibytes.tankytanks.common.tile;

import celestibytes.tankytanks.common.entity.Entity;

public class Tile {
	
	private boolean indestructible = false;
	private float hardness;
	private float durability;
	private final String tileid;
	
	public Tile(String tileid) {
		this.tileid = tileid.toLowerCase();
	}
	
	public String getTileId() {
		return this.tileid;
	}
	
	public boolean isAir() {
		return false;
	}
	
	public void onEntityOver(int x, int y, Entity e) {
		
	}
}
