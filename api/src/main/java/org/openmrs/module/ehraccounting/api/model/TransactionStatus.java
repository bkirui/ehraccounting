package org.openmrs.module.ehraccounting.api.model;

public enum TransactionStatus {
	OPEN("OPEN"), CLOSED("CLOSED"), CANCELED("CANCELED");
	
	private String name;
	
	TransactionStatus(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
