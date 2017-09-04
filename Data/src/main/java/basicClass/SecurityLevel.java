package basicClass;

public enum SecurityLevel {

	LOW("low"),
	MIDDLE("middle"),
	HIGH("high"),
	IMPOSSIBLE("impossible");
	
	private String level;

	private SecurityLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

}
