package net.jpmc.constant;

public enum CurrencyType {
	
	AED("AED"),
	SER("SER"),
	USD("USD");
	
	private String code;
	
	CurrencyType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

}
