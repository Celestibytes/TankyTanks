package celestibytes.tankytanks.util;

import celestibytes.tankytanks.common.util.Out;
import celestibytes.tankytanks.common.util.Side;

public abstract class CLineArg {
	
	private final String key;
	private final int valueCount;
	private final Side side;
	private String[] defaultValues = null;
	private boolean required = false;
	
	public CLineArg(String key, int values, Side side) {
		this.key = key;
		this.valueCount = values;
		this.side = side;
		this.defaultValues = new String[values];
	}
	
	public CLineArg setRequired(boolean val) {
		this.required = true;
		return this;
	}
	
	public int getValCount() {
		return this.valueCount;
	}
	
	public boolean isRequired() {
		return this.required;
	}
	
	public Side getSide() {
		return this.side;
	}
	
	public void setDefaultValues(String[] defaultValues) {
		if(defaultValues == null) {
			return;
		}
		if(this.defaultValues.length != defaultValues.length) {
			Out.err("Invalid amount of values for CLineArg(While setting the defaultValues): " + this.key);
			return;
		}
		System.arraycopy(defaultValues, 0, this.defaultValues, 0, defaultValues.length);
	}
	
	public String getKey() {
		return this.key;
	}
	
	public abstract boolean parseArg(String[] values);
}
