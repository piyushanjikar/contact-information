package com.piyush.contact.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.piyush.contact.constants.ResponseMessages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Response format when response is success but need not to send entity in
 * response
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@NoArgsConstructor
@Data
@ToString
public class ResponseSuccess {

	private Date timestamp;

	private int code;

	private String status;

	private String message;

	public ResponseSuccess(HttpStatus status, String message) {
		this.timestamp = new Date();
		this.code = status.value();
		this.status = status.toString();
		this.message = message;
	}

	public ResponseSuccess(HttpStatus status, ResponseMessages responseStatus) {
		this.timestamp = new Date();
		this.code = status.value();
		this.status = status.toString();
		this.message = responseStatus.getMessage();
	}

}
