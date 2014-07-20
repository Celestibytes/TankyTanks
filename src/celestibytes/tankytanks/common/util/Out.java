package celestibytes.tankytanks.common.util;

import celestibytes.tankytanks.Properties;

public class Out {
	
	private static void print(String tag, Object txt, boolean err) {
		if(err) {
			System.err.println("[" + tag + "]: " + String.valueOf(txt));
		} else {
			System.out.println("[" + tag + "]: " + String.valueOf(txt));
		}
	}
	
	public static void out(Object obj) {
		print("STDOUT", obj, false);
	}
	
	public static void warn(Object obj) {
		print("WARNING", obj, false);
	}
	
	public static void err(Object obj) {
		print("ERROR", obj, false);
	}
	
	public static void debug(Object obj) {
		if(!Properties.Common.DEBUG) {
			return;
		}
		print("DEBUG", obj, false);
	}
	
	public static void dbg(Object obj) {
		debug(obj);
	}
}
