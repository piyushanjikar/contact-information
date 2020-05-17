package com.piyush.contact.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DTO for update and create contact operation JSON request will be mapped to
 * this class object
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {

	@NotBlank(message = "{error.message.firstname}")
	private String firstName;

	@NotBlank(message = "{error.message.firstname}")
	private String lastName;

	@Email(message = "{error.message.email.valid}")
	@NotBlank(message = "{error.message.email.empty}")
	private String email;

	@NotBlank(message = "{error.message.phone.empty}")
	@Size(min = 10, max = 10, message = "{error.message.phone.length}")
	private String phoneNumber;

}