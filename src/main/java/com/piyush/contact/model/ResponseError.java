package com.piyush.contact.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.piyush.contact.constants.ResponseMessages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Response error format for all resources
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@NoArgsConstructor
@Data
@ToString
public class ResponseError {

	private Date timestamp;

	private int status;

	private String error;

	private List<String> errors = new ArrayList<>();

	public ResponseError(HttpStatus status, List<String> errors) {
		this.timestamp = new Date();
		this.status = status.value();
		this.error = status.getReasonPhrase();
		this.errors = errors;
	}

	public ResponseError(HttpStatus status, ResponseMessages responseMessages) {
		this.timestamp = new Date();
		this.status = status.value();
		this.error = status.getReasonPhrase();
		// this.message = responseMessages.getMessage();
	}

	public ResponseError(HttpStatus status, String message) {
		this.timestamp = new Date();
		this.status = status.value();
		this.error = status.getReasonPhrase();
		this.errors.add(message);
	}

}
