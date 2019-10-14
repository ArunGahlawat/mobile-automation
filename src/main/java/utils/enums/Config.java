package utils.enums;

public enum Config {
	COMMON("common"),
	ANDROID("android");

	String config;
	Config(String config) {
		this.config = config;
	}

	public String value() {
		return this.config;
	}
}
