package com.piyush.contact.constants;

import lombok.Getter;

/**
 * This enum holds the succes and error response messages
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@Getter
public enum ResponseMessages {

	/*
	 * Error code starts from 1000
	 */
	ENTITY_NOT_FOUND(1001, "Entity does not exist"),
	DUPLICATE_CONTACT(1002, "Entity already exist"),
	INTERNAL_SERVER_ERROR(1003, "Internal Server Error"),

	/*
	 * Success code series starts from 2000
	 */
	ENTITY_UPDATED(2001, "Entity updated successfully"), ENTITY_DELETED(2002, "Entity deleted successfully"),
	ENTITY_CREATED(2003, "Entity created successfully");

	private final int code;

	private final String message;

	ResponseMessages(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
