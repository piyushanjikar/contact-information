/**
 * 
 */
package com.piyush.contact.constants;

/**
 * This ENUM holds the value for status of contact
 * 
 * @author PIYUSH ANJIKAR
 *
 */
public enum ContactStatus {

	ACTIVE("Active"), INACTIVE("Inactive");

	private String status;

	ContactStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
