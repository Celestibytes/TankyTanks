package celestibytes.tankytanks.util;

import celestibytes.tankytanks.common.util.Side;

public class CLineArg {
	
	private final String key;
	private final int valueCount;
	private final Side side;
	
	public CLineArg(String key, int values, Side side) {
		this.key = key;
		this.valueCount = values;
		this.side = side;
	}
	
	public void parseArg(String[] values) {
		
	}
}
