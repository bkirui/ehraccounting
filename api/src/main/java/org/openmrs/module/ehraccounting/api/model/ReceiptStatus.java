package org.openmrs.module.ehraccounting.api.model;

public enum ReceiptStatus {
	CONFIRMED("CONFIRMED"), NEW("NEW");
	
	private String name;
	
	ReceiptStatus(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
