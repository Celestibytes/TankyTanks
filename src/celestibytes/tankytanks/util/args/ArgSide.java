package celestibytes.tankytanks.util.args;

import celestibytes.tankytanks.common.Properties;
import celestibytes.tankytanks.common.util.Side;
import celestibytes.tankytanks.util.CLineArg;

public class ArgSide extends CLineArg {

	public ArgSide() {
		super("--side", 1, Side.COMMON);
	}
	
	@Override
	public boolean parseArg(String[] values) {
		if("server".equalsIgnoreCase(values[0])) {
			Properties.Common.SIDE = Side.SERVER;
			return true;
		}
		if("client".equalsIgnoreCase(values[0])) {
			Properties.Common.SIDE = Side.CLIENT;
			return true;
		}
		return false;
	}

}
