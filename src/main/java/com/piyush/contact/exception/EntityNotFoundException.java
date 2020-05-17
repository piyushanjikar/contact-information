package com.piyush.contact.exception;

import com.piyush.contact.constants.ResponseMessages;

/**
 * 
 * @author PIYUSH ANJIKAR
 *
 */
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(ResponseMessages status, Long id) {
		super(status.getMessage() + " for : " + id);
	}
	
	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}

}
