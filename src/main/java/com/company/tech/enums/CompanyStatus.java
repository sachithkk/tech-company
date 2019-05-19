package com.company.tech.enums;

public enum CompanyStatus {
	
	/*
	 * this enum file is used to controller company status  
	 * 
	 */
	
	ACTIVE("ACTIVE"),
	IN_ACTIVE("INACTIVE");
	
	private String status;

	private CompanyStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
