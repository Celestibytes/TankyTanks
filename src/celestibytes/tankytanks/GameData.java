package celestibytes.tankytanks;

import celestibytes.tankytanks.tile.Tile;
import celestibytes.tankytanks.tile.TileAir;

public class GameData {
	public static Tile[] allTiles = new Tile[2048];
	private static boolean vanillaTilesAdded = false;
	
	public static void addTile(Tile t) {
		if(allTiles != null) {
			for(int i=0;i<allTiles.length;i++) {
				if(allTiles[i]==null) {
					allTiles[i] = t;
					return;
				} else {
					if(allTiles[i].getTileId().equalsIgnoreCase(t.getTileId())) {
						return;
					}
				}
			}
		}
	}
	
	public static final Tile tileAir = new TileAir("air");
	
	
	
	public static void onGameStart() {
		if(vanillaTilesAdded) {
			return;
		}
		
	}
}
