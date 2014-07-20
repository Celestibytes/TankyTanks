package celestibytes.tankytanks.common.tile;

public class TileAir extends Tile {

	public TileAir(String tileid) {
		super(tileid);
	}
	
	@Override
	public boolean isAir() {
		return true;
	}

}
