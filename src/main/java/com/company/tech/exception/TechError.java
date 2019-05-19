/*
 * Created by Sajith Priyankara 
 */

package com.company.tech.exception;

public class TechError {
	
	/* this class use for set company application run time errors. */
	
	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
