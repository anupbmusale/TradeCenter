package net.jpmc.constant;

public enum InstructionType {
	
	BUY("B"),
	SELL("S");
	
	private String code;
	
	InstructionType(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
}
