package celestibytes.tankytanks;

import java.io.File;

import celestibytes.tankytanks.client.TankyTanksClient;
import celestibytes.tankytanks.common.util.Out;
import celestibytes.tankytanks.common.util.Side;
import celestibytes.tankytanks.util.CLArgHandler;
import celestibytes.tankytanks.util.CLineArg;
import celestibytes.tankytanks.util.args.ArgSide;
import celestibytes.tankytanks.util.args.ArgWindowDims;

public class Start {
	
	public static void main(String[] args) {
		CLArgHandler arger = new CLArgHandler();
		arger.addArg(new ArgSide());
		arger.addArg(new ArgWindowDims());
		boolean success = arger.handleArgs(args);
		if(!success) {
			Out.err("argument handling failed, exiting...");
			System.exit(-1);
		}
//		TankyTanksClient.runGame();
//		System.out.println((int)'0');
//		System.out.println((int)'1');
//		System.out.println((int)'2');
//		System.out.println((int)'3');
//		System.out.println((int)'4');
//		System.out.println((int)'5');
//		System.out.println((int)'6');
//		System.out.println((int)'7');
//		System.out.println((int)'8');
//		System.out.println((int)'9');
		System.out.println((int)'\n');
	}
}
