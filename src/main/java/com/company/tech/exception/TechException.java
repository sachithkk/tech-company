/*
 * Created By Sachith Tharaka 
 */

package com.company.tech.exception;

import com.company.tech.enums.TechCompanyErrors;

public class TechException extends RuntimeException{
	
	private String errorCode;
	private String errorMessage;
	
	public TechException(TechCompanyErrors errors) {
		this.errorCode = errors.getStatusCode();
		this.errorMessage = errors.getStatusMessage();
	}
	
	public TechException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
