package celestibytes.tankytanks.util;

import java.util.HashMap;
import java.util.Map;

import celestibytes.tankytanks.common.Properties;
import celestibytes.tankytanks.common.util.Out;
import celestibytes.tankytanks.common.util.Side;

public class CLArgHandler {

	public Map<String, CLineArg> args = new HashMap<String, CLineArg>();
	private int reqBalance = 0;
	
	public void addArg(CLineArg arg) {
		if(!args.containsKey(arg.getKey())) {
			args.put(arg.getKey(), arg);
			if(arg.isRequired()) {
				reqBalance--;
			}
		}
	}
	
	public boolean handleArgs(String[] args) {
		for(int i=0;i<args.length;i++) {
			if(args[i].startsWith("--")){
				if(this.args.containsKey(args[i])) {
					CLineArg arg = this.args.get(args[i]);
					if(arg != null) {
						if(i==0) {
							if(!"--side".equalsIgnoreCase(args[0])) {
								return false;
							}
						}
						if(arg.getSide() == Properties.Common.SIDE || arg.getSide() == Side.COMMON) {
							String[] argVals = new String[arg.getValCount()];
							System.arraycopy(args, i+1, argVals, 0, arg.getValCount());
							boolean succ = arg.parseArg(argVals);
							if(arg.isRequired() && succ) {
								reqBalance++;
							}
							if(succ) {
								i += 1+arg.getValCount();
							}
							if(!succ) {
								Out.warn("Parsing of CLineArg \"" + arg.getKey() + "\" failed.");
							}
						}
					}
				}
			}
		}
		if(reqBalance < 0) {
			Out.err("Missing required commandline options.");
			return false;
		} else if (reqBalance > 0) {
			Out.err("Umm, What?!?!?");
			return false;
		}
		return true;
	}
}
