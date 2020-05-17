package com.piyush.contact.exception;

import com.piyush.contact.constants.ResponseMessages;

public class DuplicateEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateEntityException() {
		super();
	}

	public DuplicateEntityException(ResponseMessages status, String data) {
		super(status.getMessage() + " " + data);
	}
	
	public DuplicateEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateEntityException(String message) {
		super(message);
	}

	public DuplicateEntityException(Throwable cause) {
		super(cause);
	}

}
