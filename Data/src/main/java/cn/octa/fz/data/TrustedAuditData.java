package cn.octa.fz.data;

import basicClass.AbstractData;

public class TrustedAuditData extends AbstractData {

	private String searchField = "Master";
	private String completeData = "master";
	private String fuzzyData = "master";
	private String incorrectData = "master";
	

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getCompleteData() {
		return completeData;
	}

	public void setCompleteData(String completeData) {
		this.completeData = completeData;
	}

	public String getFuzzyData() {
		return fuzzyData;
	}

	public void setFuzzyData(String fuzzyData) {
		this.fuzzyData = fuzzyData;
	}

	public String getIncorrectData() {
		return incorrectData;
	}

	public void setIncorrectData(String incorrectData) {
		this.incorrectData = incorrectData;
	}

	
}
