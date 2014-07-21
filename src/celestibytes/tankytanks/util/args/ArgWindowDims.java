package celestibytes.tankytanks.util.args;

import celestibytes.tankytanks.common.Properties;
import celestibytes.tankytanks.common.util.Side;
import celestibytes.tankytanks.util.CLineArg;

public class ArgWindowDims extends CLineArg {

	public ArgWindowDims() {
		super("--dims", 2, Side.CLIENT);
	}

	@Override
	public boolean parseArg(String[] values) {
		int w = Integer.parseInt(values[0]);
		int h = Integer.parseInt(values[1]);
		
		if(w>0 && h>0) {
			Properties.Client.WINDOW_WIDTH = w;
			Properties.Client.WINDOW_HEIGHT = h;
			return true;
		}
		return false;
	}

}
